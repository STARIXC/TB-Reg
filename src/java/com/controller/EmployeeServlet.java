/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.database.dbConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author starixc
 */
public class EmployeeServlet extends HttpServlet {

    PrintWriter out;
    HttpSession session;
    int status = 0;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             response.setContentType("text/html;charset=UTF-8");
        try{
            out=response.getWriter();
            session=request.getSession();
            if(request.getParameter("register")!=null)//request comming from index.jsp page, where register is button name.
            {
                System.out.println("In Registration");
                /* Getting The Value From TextBox  */
                String fname=request.getParameter("fname");
                String mname=request.getParameter("mname");
                String lname=request.getParameter("lname");
                String username=request.getParameter("username");
                String email=request.getParameter("email");
                String password=request.getParameter("password");
                //String department=request.getParameter("department");
               // String designation=request.getParameter("designation");
                
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//storing today date
                String todayDate=sdf.format(new Date());
                
                System.out.println(fname+" "+mname+" "+lname+" "+username+" "+email+" "+password+"  "+todayDate);
                /* JDBC Connection Code  */
                /* JDBC Connection Code  */
                dbConn conn = new dbConn();
                
                String sql="insert into user(fname,mname,lname,username,email,password,date_added) values('"+fname+"','"+mname+"','"+lname+"','"+username+"','"+email+"','"+password+"','"+todayDate+"')";
                //String sql="insert into employee(name,email,password,department,designation,added_date) values('"+name+"','"+email+"','"+password+"','"+department+"','"+designation+"','"+todayDate+"')";
                conn.pst = conn.conn.prepareStatement(sql);
                status = conn.pst.executeUpdate();
                if(status>0)
                {
                    session.setAttribute("username",username);
                    response.sendRedirect("home.jsp");
                }
                else
                {
                    out.println("Oops! Something went wrong...");
                }
            }
            else if(request.getParameter("login")!=null)
            {
                System.out.println("In Login");
                /* Getting The Value From TextBox  */
                String username=request.getParameter("username");
                String password=request.getParameter("password");
                System.out.println(username+" "+password);
                dbConn conn = new dbConn();
                String sql="select * from user where username='"+username+"' and password='"+password+"'";
                //String sql="select * from employee where email='"+email+"' and password='"+password+"'";
                conn.rs = conn.st.executeQuery(sql);
                
                if(conn.rs.next()){
                   String ID = conn.rs.getString("id");
                   String name = conn.rs.getString("fname");
                    session.setAttribute("name",name);   
                    session.setAttribute("ID",ID); 
                    Cookie ck = new Cookie("name",name);
                    response.addCookie(ck);
                    Cookie cks = new Cookie("ID",ID);
                    response.addCookie(cks);
                    response.sendRedirect("home.jsp");
                }
                else
                {
                    session.setAttribute("error", "Invalid Email and Password...");
                    response.sendRedirect("login.jsp");
                }
            }
            else if(request.getParameter("update")!=null)
            {
                System.out.println("In Update");
                /* Getting The Value From TextBox  */
                int id=Integer.parseInt(request.getParameter("id"));//getting value from hidden field textbox
                String name=request.getParameter("name");
                String email=request.getParameter("email");
                String password=request.getParameter("password");
                String department=request.getParameter("department");
                String designation=request.getParameter("designation");
                
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                String todayDate=sdf.format(new Date());
                
                System.out.println(name+" "+email+" "+password+" "+department+" "+designation+" "+todayDate);
                /* JDBC Connection Code  */
                dbConn conn = new dbConn();
                String sql="update employee set name='"+name+"', email='"+email+"', password='"+password+"', department='"+department+"', designation='"+designation+"' where id="+id+" " ;
                conn.pst = conn.conn.prepareStatement(sql);
                status=conn.pst.executeUpdate();
                if(status>0)
                {
                    session.setAttribute("email",email);
                    session.setAttribute("updated", "Employee has been updated Successfully..");
                    response.sendRedirect("employees.jsp");
                }
                else
                {
                    out.println("Oops! Something went wrong...");
                }
            }
           /* else if(request.getParameter("delete")!=null)
            {
                System.out.println("In Delete");
                int id=Integer.parseInt(request.getParameter("id"));
                //JDBC Connection Code // 
                dbConn conn = new dbConn();
                
                String sql="delete from employee where id="+id+" " ;
               status=conn.pst.executeUpdate(sql);
                if(status>0)
                {
                    session.setAttribute("deleted", "Employee has been reloved Successfully..");
                    response.sendRedirect("employees.jsp");
                }
                else
                {
                    out.println("Oops! Something went wrong...");
                }
            }*/
        }catch(Exception e){
            out.println(e);
        } finally {
            out.close();
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
