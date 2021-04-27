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
import java.util.List;

@WebServlet(name = "SuperAdminPanel", value = "/superAdminPanel")
public class SuperAdminPanelController extends HttpServlet {
    private AccountTablesDAO accountTablesDAO;
    @Override
    public void init() {
        accountTablesDAO = new AccountTablesDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("super admin panel");
        try{
            if(session.getAttribute("administrador") != null){
                response.sendRedirect("adminPanel");
            }else if(session.getAttribute("superAdministrador") != null ){
                List<Account> listaCuentas = accountTablesDAO.listAll();
                request.setAttribute("accTable", listaCuentas); // Will be available as ${products} in JSP
                request.getRequestDispatcher("WEB-INF/SuperAdminPanel.jsp").forward(request, response);
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
