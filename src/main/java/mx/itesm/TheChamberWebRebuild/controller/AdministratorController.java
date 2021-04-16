package mx.itesm.TheChamberWebRebuild.controller;

import mx.itesm.TheChamberWebRebuild.DAO.AccountTablesDAO;
import mx.itesm.TheChamberWebRebuild.model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "AdministratorController", value = "/adminPanel")
public class AdministratorController extends HttpServlet {
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
                request.getRequestDispatcher("WEB-INF/adminPanel.jsp").forward(request, response);
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
