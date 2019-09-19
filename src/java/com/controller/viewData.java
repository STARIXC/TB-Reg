/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.database.dbConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.*;

/**
 *
 * @author starixc
 */
public class viewData extends HttpServlet {

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
        String user_id="";
        
        try { 
            
            user_id = request.getParameter("userid");
            System.out.println("User ID is: "+user_id);
           //query
            String sql = "SELECT * FROM tibu_tb_raw WHERE user_id='" + user_id + "' ORDER BY `timestamp` DESC";
            dbConn conn = new dbConn();
            conn.rs = conn.st.executeQuery(sql);
            System.out.println("got respose");
            //JSOn DATa VAriables
            JSONArray json = new JSONArray();
            ResultSetMetaData metadata = conn.rs.getMetaData();
            int numColumns = metadata.getColumnCount();

            //String data = "<table id='tb_report_table' class='table table-striped table-bordered' style='width:100%'><thead><tr><th>SubPartner ID</th><th>Registration Date</th><th>HIV Status</th> <th>MFL Code</th><th>Facility Name</th><th>Edit</th></tr></thead><tbody> ";
            while (conn.rs.next()) {
              JSONObject obj = new JSONObject();//extend HashMap
                for (int i = 0; i <= numColumns; i++) {
                   String column_name=metadata.getColumnName(i);
                   obj.put(column_name, conn.rs.getObject(column_name));
                   System.out.println("conn.rs.getObject('" + column_name + "')........." + conn.rs.getObject(column_name));
                }
              
              System.out.println("Added JSON object to JSON Array..");
            
            }
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            // data += "</tbody></table>";
            System.out.println(json);
            out.println(json);
            out.close();
        } catch (SQLException ex) {
            Logger.getLogger(getfacility.class.getName()).log(Level.SEVERE, null, ex);
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
