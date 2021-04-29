package mx.itesm.TheChamberWebRebuild.controller;

import mx.itesm.TheChamberWebRebuild.DAO.AccountDAO;
import mx.itesm.TheChamberWebRebuild.model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GamerIdReg", value = "/gamerRegist")
public class GamerIdRegCtrller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>" + "Hola mundo" + "</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("gidredg");
        HttpSession session = request.getSession();
        session.removeAttribute("aplicante");
        session.removeAttribute("jugador");
        session.removeAttribute("completado");
        session.removeAttribute("newAdministrador");
        session.removeAttribute("newSuperAdministrador");
        session.removeAttribute("administrador");
        session.removeAttribute("superAdministrator");
        String gamerID = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String email = request.getParameter("email");
        String curp = request.getParameter("curp");
        if(password.equals(password2)){
            AccountDAO accountDao = new AccountDAO();
            int isRegistered = accountDao.registerGamer(firstName,  lastName,  gamerID,  email,  password,  curp);
            Account cuenta;
            if(session.getAttribute("aplicante") != null){
                cuenta = (Account) session.getAttribute("aplicante");
            }else{
                cuenta = (Account) session.getAttribute("candidatoAceptado");
            }
            try {

                switch (isRegistered){
                    case 1:
                        request.setAttribute("message", "Registrado correctamente. Favor de entrar en este portal");
                        request.setAttribute("messageType", "Success");
                        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
                        break;
                    case 2:
                        request.setAttribute("message", "Tu registro ha fallado, Este GamerId/usuario ya está en uso.");
                        request.setAttribute("messageType", "WarningError");
                        request.setAttribute("username",  cuenta.getUsername());
                        request.setAttribute("email", cuenta.getEmail());
                        request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
                        break;
                    case 3:
                        request.setAttribute("message", "Tu registro ha fallado, Te olvidaste de llenar algún campo.");
                        request.setAttribute("messageType", "WarningError");
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
            try{
                request.setAttribute("username", gamerID);
                request.setAttribute("email", email);
                request.setAttribute("messageType", "WarningError");
                request.setAttribute("message", "ERROR: Las contraseñas no coinciden. Imposible registrar.");
                request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
            } catch (Exception ex){
                System.out.println(ex.getClass().getCanonicalName() + " " + ex.getMessage());
            }
        }
    }
}
