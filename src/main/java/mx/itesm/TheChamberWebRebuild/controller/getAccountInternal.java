package mx.itesm.TheChamberWebRebuild.controller;

import com.google.gson.Gson;
import mx.itesm.TheChamberWebRebuild.DAO.AccountDAO;
import mx.itesm.TheChamberWebRebuild.DAO.AccountTablesDAO;
import mx.itesm.TheChamberWebRebuild.model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@WebServlet(name = "getAccountInternalController", value = "/getAccountInternal")
public class getAccountInternal extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountDAO accountDAO = new AccountDAO();
        String isRegistered = accountDAO.getNewGamerID();
        Gson gson = new Gson();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(isRegistered));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("username"));
        String username = request.getParameter("username");
        System.out.println(username);
        AccountTablesDAO accountTablesDAO = new AccountTablesDAO();
        Account account = accountTablesDAO.getAccountByUsername(username);
        Gson gson = new Gson();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(account));
    }
}
