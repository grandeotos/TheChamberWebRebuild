package mx.itesm.TheChamberWebRebuild.controller;

import com.google.gson.Gson;
import mx.itesm.TheChamberWebRebuild.DAO.AccountDAO;
import mx.itesm.TheChamberWebRebuild.DAO.AccountTablesDAO;
import mx.itesm.TheChamberWebRebuild.model.Account;
import mx.itesm.TheChamberWebRebuild.model.Applicant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "getApplicantInternalController", value = "/getApplicantInternal")
public class getApplicantInternal extends HttpServlet {
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
        System.out.println(request.getParameter("appId"));
        int appId;
        try {
            appId = Integer.parseInt(request.getParameter("appId"));
        } catch(Exception e) {
            // Log exception.
            appId = 0;
        }
        System.out.println(appId);
        AccountTablesDAO accountTablesDAO = new AccountTablesDAO();
        Applicant applicant = accountTablesDAO.getApplicantById(appId);
        Gson gson = new Gson();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(applicant));
    }
}
