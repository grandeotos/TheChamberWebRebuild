package mx.itesm.TheChamberWebRebuild.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PlayController", value = "/finished")
public class FinishedController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("completado") != null){
            request.getRequestDispatcher("WEB-INF/finish.jsp").forward(request,response);
        } else if(session.getAttribute("jugador") != null){
            request.setAttribute("message", "ERROR: Eres un jugador, no deberías estar en este portal, para poder jugar, inicia sesión en el siguiente portal.");
            request.setAttribute("messageType", "WarningError");
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
        }else{
            request.setAttribute("mensaje", "No tienes acceso a este portal.\nPor favor ingrese en el siguiente portal.");
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

