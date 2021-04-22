package mx.itesm.TheChamberWebRebuild.controller;

import mx.itesm.TheChamberWebRebuild.DAO.AccountTablesDAO;
import mx.itesm.TheChamberWebRebuild.model.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

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
        while (attributes.hasMoreElements()) {
            String attribute = (String) attributes.nextElement();
            System.out.println(attribute+" : "+request.getSession().getAttribute(attribute));
        }
        try{
            if(session.getAttribute("administrador") != null){
                List<Account> listaCuentas = accountTablesDAO.list();
                request.setAttribute("accTable", listaCuentas); // Will be available as ${products} in JSP
                //request.getRequestDispatcher("WEB-INF/adminPanel.jsp").forward(request, response);
                request.getRequestDispatcher("/advancedView.jsp").forward(request, response);

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

    }
}
