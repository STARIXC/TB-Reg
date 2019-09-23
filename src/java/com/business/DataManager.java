/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.business;

import com.database.dbConn;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HSDSA
 */
public class DataManager {
     public String InsertData(dbConn conn, HttpServletRequest request, HttpServletResponse response) throws Exception{
       String result=null;  
            try {
             result= request.getParameter("result");
                if (result !=null && result !="" && result.length()>0) {
                    Project project = new Project();
                    result=project.InsertData(conn,request,response);
                }
             
         } catch (Exception e) {
         }
            return result;
     
     }
}
