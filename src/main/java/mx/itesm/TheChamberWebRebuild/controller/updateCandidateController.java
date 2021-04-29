package mx.itesm.TheChamberWebRebuild.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import mx.itesm.TheChamberWebRebuild.DAO.AccountDAO;
import mx.itesm.TheChamberWebRebuild.DAO.AccountTablesDAO;
import mx.itesm.TheChamberWebRebuild.model.Account;
import mx.itesm.TheChamberWebRebuild.model.Applicant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "updateCandidateController", value = "/upCand")
public class updateCandidateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int appId = Integer.parseInt(request.getParameter("appId"));
        String action = request.getParameter("action");
        AccountTablesDAO accountTablesDAO = new AccountTablesDAO();
        Applicant applicant = accountTablesDAO.getApplicantById(appId);
        Gson gson = new Gson();
        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("error", 0);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        int actionInt = 4;
        int appRegistered;
        if (applicant != null){
            AccountDAO accountDAO = new AccountDAO();
            System.out.println(action);
            switch (action){
                case "dAasNotViewed":
                    actionInt = 0;
                    appRegistered = accountDAO.updateApplicant(appId, actionInt);
                    if(appRegistered == 1){
                        jsonResponse.addProperty("message", "Candidato MARCADO SIN REVISAR con exito");
                    }else {
                        jsonResponse.addProperty("message", "ERROR no update");
                    }
                    break;
                case "dAaccept":
                    String newGid = accountDAO.getNewGamerID();
                    accountDAO = new AccountDAO();
                    int isRegistered = accountDAO.registerGamer(newGid, applicant.getFirstName(), applicant.getLastName(), applicant.getEmail());
                    jsonResponse.addProperty("isRegistered", isRegistered);
                    System.out.println("Caso de isregistered jsp" + isRegistered);
                    switch (isRegistered){
                        case 1:
                            actionInt = 1;
                            appRegistered = accountDAO.updateApplicant(appId, 1);
                            System.out.println(appRegistered);
                            if(appRegistered == 1){
                                jsonResponse.addProperty("gamerId", newGid);
                                jsonResponse.addProperty("message", "Candidato APROBADO Y REGISTRADO correctamente - GID ASIGNADO (" + newGid + ")");
                            }else {
                                jsonResponse.addProperty("message", "ERROR Candidato probablemente registrado, sin actualizar, contacte a Chayomix Studios");
                            }
                            break;
                        case 2:
                            jsonResponse.addProperty("message", "ERROR El candidato ha sido aprobado anteriormente");
                            jsonResponse.remove("error");
                            jsonResponse.addProperty("error", 1);
                            break;
                        case 3:
                            jsonResponse.addProperty("message", "ERROR Tu registro ha fallado, Te olvidaste de llenar algún campo.");
                            jsonResponse.remove("error");
                            jsonResponse.addProperty("error", 1);
                            break;
                        default:
                            jsonResponse.addProperty("message", "ERROR FATAL");
                            jsonResponse.remove("error");
                            jsonResponse.addProperty("error", 1);
                            break;
                    }
                    break;
                case "dAasViewed":
                    actionInt = 2;
                    appRegistered = accountDAO.updateApplicant(appId, actionInt);
                    if(appRegistered == 1){
                        jsonResponse.addProperty("message", "Candidato REVISADO con exito");
                    }else {
                        jsonResponse.addProperty("message", "ERROR no update");
                    }
                    break;
                case "dAReject":
                    actionInt = 3;
                    appRegistered = accountDAO.updateApplicant(appId, actionInt);
                    if(appRegistered == 1){
                        jsonResponse.addProperty("message", "Candidato RECHAZADO con exito");
                    }else {
                        jsonResponse.addProperty("message", "ERROR no update");
                    }
                    break;
            }
            System.out.println("good");
            out.print(gson.toJson(jsonResponse));
        } else {
            System.out.println("bads");
            out.print(gson.toJson(jsonResponse));
        }
    }
}
