package mx.itesm.TheChamberWebRebuild.controller;

import com.google.gson.Gson;
import mx.itesm.TheChamberWebRebuild.DAO.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NewGamerRegistrationController", value = "/admMake")
public class AdministratorCreationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    /*
    private AccountTablesDAO accountTablesDAO;
    @Override
    public void init() {
        accountTablesDAO = new AccountTablesDAO();
    }
*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String gamerID = request.getParameter("username");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        AccountDAO accountDao = new AccountDAO();
        int isRegistered = accountDao.registerAdmin(gamerID,  email, role);
        System.out.println(isRegistered);
        try {
            //List<Account> listaCuentas = accountTablesDAO.list();
            //request.setAttribute("accTable", listaCuentas); // Will be available as ${products} in JSP
            Gson gson = new Gson();
            String mensaje;
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            switch (isRegistered){
                case 1:
                    request.setAttribute("message", "Registrado correctamente. Favor de entrar en este portal");
                    request.setAttribute("messageType", "Success");
                    //request.getRequestDispatcher("adminPanel").forward(request, response);
                    //response.sendRedirect("adminPanel");
                    mensaje = "Registrado administrador correctamente.";
                    out.print(gson.toJson(mensaje));
                    break;
                case 2:
                    request.setAttribute("message", "Tu registro ha fallado, Este usuario ya está en uso.");
                    request.setAttribute("messageType", "WarningError");
                    //request.getRequestDispatcher("adminPanel").forward(request, response);
                    mensaje = "Tu registro ha fallado, Este usuario ya está en uso.";
                    out.print(gson.toJson(mensaje));
                    break;
                default:
                    request.setAttribute("message", "Tu registro ha fallado, favor de contactar a Chayomix Studios (A01751038@itesm.mx) para reportar este incidente.");
                    request.setAttribute("messageType", "FatalError");
                    //request.getRequestDispatcher("adminPanel").forward(request, response);
                    mensaje = "Tu registro ha fallado, favor de contactar a Chayomix Studios (A01751038@itesm.mx) para reportar este incidente.";
                    out.print(gson.toJson(mensaje));
                    break;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
