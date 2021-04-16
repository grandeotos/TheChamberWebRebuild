package mx.itesm.TheChamberWebRebuild.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FAQController", value = "/FAQ")
public class FAQController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FAAAAAAQ");
        try {
            request.getRequestDispatcher("WEB-INF/faq.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

