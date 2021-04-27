package mx.itesm.TheChamberWebRebuild.controller;

import com.sun.javafx.collections.MappingChange;
import mx.itesm.TheChamberWebRebuild.DAO.AccountTablesDAO;
import mx.itesm.TheChamberWebRebuild.model.Account;
import mx.itesm.TheChamberWebRebuild.util.MySQLConnection;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.SimpleFileResolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AdvancedViewController", value = "/advancedView")
public class AdvancedViewController extends HttpServlet {
    private AccountTablesDAO accountTablesDAO;
    @Override
    public void init() {
        accountTablesDAO = new AccountTablesDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("Sesion:");
        System.out.println(session.getAttributeNames());
        Enumeration<String> attributes = request.getSession().getAttributeNames();
        String Player = request.getParameter("username");
        while (attributes.hasMoreElements()) {
            String attribute = (String) attributes.nextElement();
            System.out.println(attribute+" : "+request.getSession().getAttribute(attribute));
        }
        try{
            if(session.getAttribute("administrador") != null || session.getAttribute("superAdministrador") != null){
                Account accountId = accountTablesDAO.getAccountByUsername(Player);
                request.setAttribute("cuenta", accountId); // Will be available as ${products} in JSP
                //request.getRequestDispatcher("WEB-INF/adminPanel.jsp").forward(request, response);
                request.getRequestDispatcher("WEB-INF/advancedView.jsp").forward(request, response);
            }else{
                request.setAttribute("message", "ERROR: No tienes acceso a este portal.");
                request.setAttribute("messageType", "WarningError");
                request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username =request.getParameter("username");
        System.out.println(username);
        String madeBy =request.getParameter("madeBy");
        String reportLocation = "WEB-INF/reports/account.jasper";
        String reportBasicLocation = "WEB-INF/reports/basicAccount.jasper";
        String generator = request.getParameter("generatedBy");
        String WORK_DIRECTORY = "WEB-INF/reports/";
        //"C:\\Users\\jluso\\JaspersoftWorkspace\\MyReports\\"
        WORK_DIRECTORY = getServletContext().getRealPath("/WEB-INF/reports/");
        File file = new File(getServletContext().getRealPath(reportLocation));
        InputStream inputStream = new FileInputStream(file);
        Map parameters = new HashMap();
        System.out.println(WORK_DIRECTORY);
        parameters.put("WORK_DIRECTORY",WORK_DIRECTORY);
        parameters.put("accountUsername",username);
        parameters.put("madeBy", generator);
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        try{
            byte[] bytes = JasperRunManager.runReportToPdf(inputStream, parameters, MySQLConnection.getConnection());
            System.out.println(bytes.length);
            if(bytes.length > 1000){
                out.write(bytes);
            }else {
                System.out.println("Reporte basico");
                File file2 = new File(getServletContext().getRealPath(reportBasicLocation));
                InputStream inputStream2 = new FileInputStream(file2);
                byte[] bytes2 = JasperRunManager.runReportToPdf(inputStream2, parameters, MySQLConnection.getConnection());
                out.write(bytes2);
            }
            out.flush();
            out.close();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
