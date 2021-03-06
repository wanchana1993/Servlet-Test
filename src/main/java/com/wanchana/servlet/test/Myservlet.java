/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wanchana.servlet.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author neng
 */
public class Myservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String greeting = req.getParameter("name");
//        resp.getWriter().append("Hello " + greeting);
        String fileName = req.getParameter("name");
        String filePath = Utils.getFilePath(System.getProperty("user.dir"), fileName);
        resp.setHeader("Content-disposition", "attachment; filename=" + fileName);
        File file = new File(filePath);
        try (OutputStream outputStream = resp.getOutputStream(); 
                FileInputStream fileInputStream = new FileInputStream(file); 
                NewClass newClass = new NewClass()) {
            byte[] buffer = new byte[1000];
            int length = 0 / 0;
            length = fileInputStream.read(buffer);
            while (length != -1) {
                outputStream.write(buffer, 0, length);
                outputStream.flush();
                length = fileInputStream.read(buffer);
            }
            //Auto closable here.
        } catch (Exception e) {
            System.out.println("An error accured!");
        } finally {
            System.out.println("finally");
        }
    }
}
