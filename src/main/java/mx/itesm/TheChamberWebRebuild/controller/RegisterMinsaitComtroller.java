package mx.itesm.TheChamberWebRebuild.controller;

import mx.itesm.TheChamberWebRebuild.model.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterMinsait", value = "/registerMinstait")
public class RegisterMinsaitComtroller extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Holaaas");
        HttpSession session = request.getSession();
        try {
            if(session.getAttribute("administrador") != null || session.getAttribute("superAdministrador") != null){
                request.setAttribute("message", "ERROR: Eres un administrador, no deberías estar en este portal, usa el panel de control, entrando con tus credenciales.");
                request.setAttribute("messageType", "WarningError");
                request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
            } else if(session.getAttribute("candidatoAceptado") != null) {
                Account cuenta = (Account) session.getAttribute("candidatoAceptado");
                request.setAttribute("firstName", cuenta.getFirstName());
                request.setAttribute("lastName", cuenta.getLastName());
                request.setAttribute("curp", cuenta.getCurp());
                request.setAttribute("username", cuenta.getUsername());
                request.setAttribute("email", cuenta.getEmail());
                request.setAttribute("roleId", cuenta.getRolId());
                request.getRequestDispatcher("WEB-INF/registerMinsait.jsp").forward(request, response);

            } else if(session.getAttribute("jugador") != null){
                request.setAttribute("message", "ERROR: Eres un jugador, no deberías estar en este portal, para poder jugar, inicia sesión en el siguiente portal.");
                request.setAttribute("messageType", "WarningError");
                request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
            }
            else{
                request.setAttribute("message", "ERROR: No tienes acceso a este portal, inicia sesión para poder acceder.");
                request.setAttribute("messageType", "WarningError");
                request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
            }
            //request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

