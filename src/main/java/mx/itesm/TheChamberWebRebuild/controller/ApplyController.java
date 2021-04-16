package mx.itesm.TheChamberWebRebuild.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegistSubmit", value = "/apply")
public class ApplyController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.getRequestDispatcher("WEB-INF/apply.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

