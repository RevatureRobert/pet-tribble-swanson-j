package com.tribbles.servlet;

import com.google.gson.GsonBuilder;
import com.tribbles.model.Lab;
import com.tribbles.service.LabService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/tribble")
public class LabServlet extends HttpServlet{

    LabService labService = new LabService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        resp.setContentType("application/json");
        int value;
        try {
            value = Integer.parseInt(req.getParameter("id"));
        }catch(Exception e){
            printWriter.write("id must be an integer");
            printWriter.flush();
            return;
        }

        try{
            Lab lab = labService.read(value);
            printWriter.write(new GsonBuilder().setPrettyPrinting().create().toJson(lab));
            return;
        }catch (Exception e){
            printWriter.write("Incorrect id");
            printWriter.flush();
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
