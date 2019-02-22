/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mulero
 */
@WebServlet(name = "SomaServlet", urlPatterns = {"/soma.html"})
public class SomaServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlets - Soma</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1><a href='index.html'>Servlets</a></h1>");
            out.println("<h2>Soma</h2>");
            out.println("<hr/>");

            out.println("<form>");
            out.println("<input type='text' name='n1' placeholder='0'/>");
            out.println("<p> + </p>");
            out.println("<input type='text' name='n2' placeholder='0'/>");
            out.println("<br>");
            out.println("<br>");
            out.println("<input type='submit' name='somar' value=' = '/>");
            out.println("</form>");

            out.println("<hr/>");

            if (request.getParameter("somar") != null) {
                try {
                    double n1 = Double.parseDouble(request.getParameter("n1"));
                    double n2 = Double.parseDouble(request.getParameter("n2"));
                    double soma = n1 + n2;
                    out.println("<h4>Resultado: " + soma + "</h4>");
                } catch (Exception e) {
                    out.println("<h4 style='color: red'>Erro ao converter</h4>");
                }
            }

            out.println("</body>");
            out.println("</html>");
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
