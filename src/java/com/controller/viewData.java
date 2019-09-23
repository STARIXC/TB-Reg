/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.database.dbConn;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.Data;
import java.util.Set;

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
     * @return
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected ArrayList processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String user_id = "";
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ArrayList data = new ArrayList();
        try {

            String user_id = request.getParameter("userid");
            System.out.println("User ID is: " + user_id);
            //query
            String sql = "SELECT * FROM tibu_tb_raw WHERE user_id='" + user_id + "' ORDER BY `timestamp` DESC";
            dbConn conn = new dbConn();
            conn.rs = conn.st.executeQuery(sql);
            System.out.println("got respose");
            while (conn.rs.next()) {
                Data dt = new Data();
                dt.setID(conn.rs.getString("id"));
                dt.setSubPartnerID(conn.rs.getString("SubPartnerID"));
                // dt.   ID = conn.rs.getString("id");
                dt.setSerialNumber(conn.rs.getString("serialno"));
                dt.setSubPartnerID(conn.rs.getString("SubPartnerID"));
                dt.setDistrictNom(conn.rs.getString("DistrictNom"));
                dt.setRegistrationDate(conn.rs.getString("registrationdate"));
                dt.setSex(conn.rs.getString("sex"));
                dt.setAge(conn.rs.getString("age"));
                dt.setXray(conn.rs.getString("xray"));
                dt.setTreatmentDate(conn.rs.getString("treatmentdate"));
                dt.setHivStatus(conn.rs.getString("hivstatus"));
                dt.setHivTestDate(conn.rs.getString("hivtestdate"));
                dt.setArtStatus(conn.rs.getString("artstatus"));
                dt.setArtDate(conn.rs.getString("artdate"));
                dt.setMflcode(conn.rs.getString("Mflcode"));
                dt.setSubPartnerNom(conn.rs.getString("SubPartnerNom"));
                dt.setCounty(conn.rs.getString("County"));
                dt.setCountyID(conn.rs.getString("CountyID"));
                //dt.setDistrict( conn.rs.getString("DistrictNom"));
                dt.setDistrictID(conn.rs.getString("DistrictID"));
                dt.setSmear0(conn.rs.getString("smear0"));
                dt.setGenExpert(conn.rs.getString("genexpert"));
                dt.setWithinFaciity(conn.rs.getString("tested_within_facility"));
                dt.setInitial_modality(conn.rs.getString("initial_modality"));
                data.add(dt);
                Gson gson = new Gson();
                String data_output = gson.toJson(data);
                out.println("{\"data\":"+data_output+"}");
                System.out.print(data_output);
            }
            return data;

        } catch (SQLException ex) {
            Logger.getLogger(getfacility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;

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
