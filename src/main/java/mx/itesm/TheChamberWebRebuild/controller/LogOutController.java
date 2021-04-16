package mx.itesm.TheChamberWebRebuild.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogOutController", value = "/logout")
public class LogOutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        try{
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
