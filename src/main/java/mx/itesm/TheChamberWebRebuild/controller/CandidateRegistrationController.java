package mx.itesm.TheChamberWebRebuild.controller;

import mx.itesm.TheChamberWebRebuild.DAO.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GamerRegistrationController2", value = "/appReg")
public class CandidateRegistrationController extends HttpServlet {

    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        sesion.removeAttribute("aplicante");
        sesion.removeAttribute("jugador");
        sesion.removeAttribute("administrador");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String telp = request.getParameter("telep");
        int exper = Integer.parseInt(request.getParameter("exper"));
        int profix = Integer.parseInt(request.getParameter("profix"));
        AccountDAO accountDao = new AccountDAO();
        int isRegistered = accountDao.registerApplicant(firstName,  lastName,  email,  telp,  exper,  profix);
        try {
            switch (isRegistered){
                case 1:
                    request.setAttribute("message", "Registrado correctamente. Te contactaremos en caso de tener vacantes disponibles");
                    request.setAttribute("messageType", "Success");
                    request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
                    break;
                case 2:
                    request.setAttribute("message", "Tu registro ha fallado, Este correo ya está en uso.");
                    request.setAttribute("messageType", "WarningError");
                    request.getRequestDispatcher("WEB-INF/apply.jsp").forward(request, response);
                    break;
                case 3:
                    request.setAttribute("message", "Tu registro ha fallado, Te olvidaste de llenar algún campo.");
                    request.setAttribute("messageType", "WarningError");
                    request.getRequestDispatcher("WEB-INF/apply.jsp").forward(request, response);
                    break;
                default:
                    request.setAttribute("message", "Tu registro ha fallado, favor de contactar a Chayomix Studios (A01751038@itesm.mx) para reportar este incidente.");
                    request.setAttribute("messageType", "FatalError");
                    request.getRequestDispatcher("WEB-INF/apply.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}