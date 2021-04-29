package com.tribbles.servlet;

import com.google.gson.GsonBuilder;
import com.tribbles.model.Lab;
import com.tribbles.model.Tribble;
import com.tribbles.service.LabService;
import com.tribbles.service.TribbleService;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/tribble")
public class TribbleServlet extends HttpServlet {

    TribbleService tribbleService = new TribbleService();

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
            Tribble tribble = tribbleService.read(value);
            printWriter.write(new GsonBuilder().setPrettyPrinting().create().toJson(tribble));
            resp.setStatus(200);
            return;
        }catch (Exception e){
            printWriter.write("Incorrect id");
            printWriter.flush();
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Tribble tribble = null;
        StringBuilder json = new StringBuilder();
        try{
            BufferedReader bufferedReader = req.getReader();
            String nextLine = null;
            while((nextLine = bufferedReader.readLine()) != null){
                json.append(nextLine);
            }
        }catch(Exception e){
            PrintWriter printWriter = resp.getWriter();
            printWriter.write("Couldn't read body");
            printWriter.flush();
        }

        try{
            JSONObject jsonObject = new JSONObject(json);
            int id = Integer.parseInt(jsonObject.getJSONObject("tribble").getString("id"));
            String name = jsonObject.getJSONObject("tribble").getString("name");
            String color = jsonObject.getJSONObject("tribble").getString("color");
            String labId = jsonObject.getJSONObject("tribble").getString("lab_id");
            tribble = new Tribble(id, name, color, new LabService().read(id));
            tribbleService.save(tribble);
            resp.setStatus(200);
        }catch(Exception e){
            PrintWriter printWriter = resp.getWriter();
            printWriter.write("Couldn't save");
            printWriter.flush();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            tribbleService.delete(value);
            resp.setStatus(200);
            return;
        }catch (Exception e){
            printWriter.write("Incorrect id");
            printWriter.flush();
            return;
        }
    }
}
