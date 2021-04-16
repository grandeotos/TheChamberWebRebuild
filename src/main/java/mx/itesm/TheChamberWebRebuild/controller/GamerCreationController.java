package mx.itesm.TheChamberWebRebuild.controller;

import mx.itesm.TheChamberWebRebuild.DAO.AccountDAO;
import mx.itesm.TheChamberWebRebuild.model.Account;
import mx.itesm.TheChamberWebRebuild.DAO.AccountTablesDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewGamerRegistrationController", value = "/gidMake")
public class GamerCreationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private AccountTablesDAO accountTablesDAO;
    @Override
    public void init() {
        accountTablesDAO = new AccountTablesDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post2");
        HttpSession sesion = request.getSession();
        String gamerID = request.getParameter("gIdUsername");
        String email = request.getParameter("gIdEmail");
        System.out.println("Formularios de GIDMAKE" + gamerID + " " + email);
        AccountDAO accountDao = new AccountDAO();
        System.out.println("Entra boolean");
        int isRegistered = accountDao.registerGamer(gamerID,  email);
        System.out.println(isRegistered);
        System.out.println("Sale boolean");
        try {
            List<Account> listaCuentas = accountTablesDAO.list();
            request.setAttribute("accTable", listaCuentas); // Will be available as ${products} in JSP
            System.out.println("Case de gidMake: " + isRegistered);
            switch (isRegistered){
                case 1:
                    request.setAttribute("message", "Registrado correctamente. Favor de entrar en este portal");
                    request.setAttribute("messageType", "Success");
                    //request.getRequestDispatcher("adminPanel").forward(request, response);
                    response.sendRedirect("adminPanel");
                    break;
                case 2:
                    request.setAttribute("message", "Tu registro ha fallado, Este GamerId ya está en uso.");
                    request.setAttribute("messageType", "WarningError");
                    request.getRequestDispatcher("adminPanel").forward(request, response);
                    break;
                default:
                    request.setAttribute("message", "Tu registro ha fallado, favor de contactar a Chayomix Studios (A01751038@itesm.mx) para reportar este incidente.");
                    request.setAttribute("messageType", "FatalError");
                    request.getRequestDispatcher("adminPanel").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
