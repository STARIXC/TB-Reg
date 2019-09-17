/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.database.dbConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author starixc
 */
public class VerifyRegisteredEmailHash extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String username = request.getParameter("username");
        String hash = request.getParameter("hash");
        //String  scope = request.getParameter("scope");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             //Create messageDigest instance of md5
             System.out.println(username + " " + hash);
                dbConn conn = new dbConn();
                String sql = "select * from user where username='" + username + "' and email_verification_hash='" + hash + "'";
                //String sql="select * from employee where email='"+email+"' and password='"+password+"'";
                conn.rs = conn.st.executeQuery(sql);
                if (conn.rs.next()) {
                    updateStatus(username,"active",null);
                       response.sendRedirect("activated.jsp");
                
                }         
        }
    }
    public void updateStatus(String username, String status, String verification_hash) throws SQLException{
    
                dbConn conn = new dbConn();
                String sql = "UPDATE user SET status=?,email_verification_hash=? WHERE username =?";
                conn.pst.setString(1, status);
                conn.pst.setString(2, verification_hash);
                conn.pst.setString(2, username);
                conn.pst = conn.conn.prepareStatement(sql);
                conn.pst.executeUpdate();
                
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(VerifyRegisteredEmailHash.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(VerifyRegisteredEmailHash.class.getName()).log(Level.SEVERE, null, ex);
        }
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
