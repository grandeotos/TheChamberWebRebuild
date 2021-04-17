package mx.itesm.TheChamberWebRebuild.controller;

import mx.itesm.TheChamberWebRebuild.DAO.AccountDAO;
import mx.itesm.TheChamberWebRebuild.model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GamerRegistrationController", value = "/gidReg")
public class GamerRegistrationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("posteame esta");
        HttpSession session = request.getSession();
        session.removeAttribute("aplicante");
        session.removeAttribute("jugador");
        session.removeAttribute("administrador");
        String gamerID = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String email = request.getParameter("email");
        String curp = request.getParameter("curp");
        if(password.equals(password2)){
            System.out.println("Contras conciden");
            AccountDAO accountDao = new AccountDAO();
            System.out.println("Entra boolean");
            int isRegistered = accountDao.registerGamer(firstName,  lastName,  gamerID,  email,  password,  curp);
            System.out.println(isRegistered);
            System.out.println("Sale boolean");
            Account cuenta = (Account) session.getAttribute("aplicante");
            try {
                switch (isRegistered){
                    case 1:
                        request.setAttribute("message", "Registrado correctamente. Favor de entrar en este portal");
                        request.setAttribute("messageType", "Success");
                        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
                        break;
                    case 2:
                        request.setAttribute("message", "Tu registro ha fallado, Este GamerId ya está en uso.");
                        request.setAttribute("messageType", "WarningError");
                        request.setAttribute("username", cuenta.getUsername());
                        request.setAttribute("email", cuenta.getEmail());
                        request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
                        break;
                    default:
                        request.setAttribute("message", "Tu registro ha fallado, Revisa tus campos y verificalos correctamente.");
                        request.setAttribute("messageType", "FatalError");
                        request.setAttribute("username", cuenta.getUsername());
                        request.setAttribute("email", cuenta.getEmail());
                        request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
                        break;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }else{
            System.out.println("PASSWORD MISMATCH");
            try{
                request.setAttribute("messageType", "WarningError");
                request.setAttribute("message", "ERROR: Las contraseñas no coinciden. Imposible registrar.");
                request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
            } catch (Exception ex){
                System.out.println(ex.getClass().getCanonicalName() + " " + ex.getMessage());
            }
        }
    }
}