package mx.itesm.TheChamberWebRebuild.controller;

import mx.itesm.TheChamberWebRebuild.DAO.AccountDAO;
import mx.itesm.TheChamberWebRebuild.model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LoginController", value = "/auth")
public class LoginController extends HttpServlet {

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username + " password: " + password);
        AccountDAO accountDao = new AccountDAO();
        Account account = accountDao.auth(username, password);
        HttpSession sesion = request.getSession();
        System.out.println("La cuenta es: " + account);
        sesion.removeAttribute("aplicante");
        sesion.removeAttribute("jugador");
        sesion.removeAttribute("administrador");
        try {
            if (account == null) {
                request.setAttribute("messageType", "WarningError");
                request.setAttribute("message", "El usuario o contraseña son incorrectos");
                request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
            } else {
                try {
                    System.out.println(account.getRolId());
                    switch (account.getRolId()){
                        case 0:
                            sesion.setAttribute("aplicante", account);
                            response.sendRedirect("register");
                            break;
                        case 1:
                            sesion.setAttribute("jugador", account);
                            response.sendRedirect("play");
                            break;
                        case 2:
                            sesion.setAttribute("completado", account);
                            response.sendRedirect("finished");
                            break;
                        case 3:
                            sesion.setAttribute("candidatoAceptado", account);
                            response.sendRedirect("registerMinstait");
                            break;
                        case 4:
                        case 5:
                            sesion.setAttribute("newAdministrator", account);
                            response.sendRedirect("newAdminRegistration");
                            break;
                        case 6:
                            sesion.setAttribute("administrador", account);
                            response.sendRedirect("adminPanel");
                            break;
                        case 7:
                            sesion.setAttribute("superAdministrador", account);
                            response.sendRedirect("superAdminPanel");
                            break;

                        default:
                            request.setAttribute("message", "Un ERROR desconocido ha sucedido, contacte al equipo del sitio web");
                            request.setAttribute("messageType", "FatalError");
                            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
                            break;
                    }

                } catch (Exception b) {
                    System.out.println("La excepción es: " + b.getCause() + " " + b.getMessage());
                }
            }
        } catch (Exception c) {
            System.out.println("La excepción es: " + c.getCause() + " " + c.getMessage());
        }
    }
}