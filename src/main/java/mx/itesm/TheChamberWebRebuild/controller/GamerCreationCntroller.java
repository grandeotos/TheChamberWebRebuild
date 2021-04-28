package mx.itesm.TheChamberWebRebuild.controller;

import com.google.gson.Gson;
import mx.itesm.TheChamberWebRebuild.DAO.AccountDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GamerCreationCntroller", value = "/gidCMake")
public class GamerCreationCntroller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>Hola Mundo</h1>");

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
        System.out.println("post2");
        HttpSession sesion = request.getSession();
        String gamerID = request.getParameter("username");
        String email = request.getParameter("email");
        System.out.println("Formularios de gidCMake" + gamerID + " " + email);
        AccountDAO accountDao = new AccountDAO();
        System.out.println("Entra boolean");
        int isRegistered = accountDao.registerGamer(gamerID,  email);
        System.out.println(isRegistered);
        System.out.println("Sale boolean");
        try {
            //List<Account> listaCuentas = accountTablesDAO.list();
            //request.setAttribute("accTable", listaCuentas); // Will be available as ${products} in JSP
            System.out.println("Case de gidCMake: " + isRegistered);
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
                    mensaje = "Registrado correctamente.";
                    out.print(gson.toJson(mensaje));
                    break;
                case 2:
                    request.setAttribute("message", "Tu registro ha fallado, Este GamerId ya está en uso.");
                    request.setAttribute("messageType", "WarningError");
                    //request.getRequestDispatcher("adminPanel").forward(request, response);
                    mensaje = "Tu registro ha fallado, Este GamerId ya está en uso.";
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
