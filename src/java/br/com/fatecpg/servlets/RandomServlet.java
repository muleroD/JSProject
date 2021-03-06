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
@WebServlet(name = "RandomServlet", urlPatterns = {"/random.html"})
public class RandomServlet extends HttpServlet {

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
            out.println("<title>Servlets - Random</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1><a href='index.html'>Servlets</a></h1>");
            out.println("<h2>Random</h2>");
            out.println("<hr/>");

            out.println("<form>");
            out.println("<input type='number' name='n' placeholder='0'/>");
            out.println("<input type='submit' name='Enviar'/>");
            out.println("</form>");

            out.println("<hr/>");

            if (request.getParameter("Enviar") != null) {
                try {
                    int n = Integer.parseInt(request.getParameter("n"));

                    out.println("<table>");

                    for (int i = 0; i < n; i++) {
                        int random = (int) (1000 * Math.random());
                        
                        out.println("<tr>");
                        out.println("<th>" + (i + 1) + ": </th>");
                        out.println("<td>" + random + " </td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");

                } catch (Exception e) {
                    out.println("<h4 style='color: red'>Erro ao gerar </h4>");
                }

                out.println("</body>");
                out.println("</html>");
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
