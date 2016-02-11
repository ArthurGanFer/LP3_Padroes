/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.controller;

import com.br.lp3.teste.FuncFactory;
import com.br.lp3.teste.Funcionario;
import com.br.lp3.teste.SingObj;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31338283
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            SingObj singleton = SingObj.getInstance();
            out.println(singleton.getCor());
            out.println("<br>");

            SingObj singleton2 = SingObj.getInstance();
            out.println(singleton2.getCor());
            out.println("<br>");

            singleton.setCor("#f00");
            out.println("<hr>");
            out.println(singleton.getCor());
            out.println("<br>");
            out.println(singleton2.getCor());

            out.println("<hr>");
            Funcionario f1 = FuncFactory.getFuncionario("gerente", "Cacique", 10000.00, 123);
            out.println("<h1 style='color:" + singleton.getCor() + "'>" + f1.getNome() + "</h1>");

            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(new File("C:/Temp/teste.txt"));
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(f1);
                oos.close();
                fos.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            FileInputStream fis = null;
            try {
                fis = new FileInputStream(new File("C:/Temp/teste.txt"));
                ObjectInputStream ois = new ObjectInputStream(fis);
                Funcionario f2 = (Funcionario) ois.readObject();
                out.println("<br>");
                out.println("<h1>" + f2.getNome() + "</h1>");
                ois.close();
                fis.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
