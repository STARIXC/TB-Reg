
package com.business;

//import java.util.ArrayList;

import com.database.dbConn;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Project {
  //  public ArrayList GetData()
    public String InsertData(dbConn conn, HttpServletRequest request, HttpServletResponse response) throws Exception{
      String result= null;
        try {

            // String error = "";
            System.out.println("In Inserting Records ...");
            //initialize data recieved
            String user_id=request.getParameter("user_id");
            String SerialNumber = request.getParameter("SerialNumber");
            String SubCountyRegNo = request.getParameter("SubCountyRegNo");
            String SubPartnerID = request.getParameter("SubPartnerID");
            String RegDate = request.getParameter("RegDate");
            String Sex = request.getParameter("Sex");
            String Age = request.getParameter("Age");
            String Xray = request.getParameter("Xray");
            String TreatmentDate = request.getParameter("TreatmentDate");
            String HIVStatus = request.getParameter("HIVStatus");
            String HIVTestDate = request.getParameter("HIVTestDate");
            String ArtStatus = request.getParameter("ArtStatus");
            String ArtDate = request.getParameter("ArtDate");
            String mflcode = request.getParameter("mflcode");
            String SubPartnerNom = request.getParameter("SubPartnerNom");
            String SupportType = request.getParameter("SupportType");
            String Smear0 = request.getParameter("Smear0");
            String GenExpert = request.getParameter("GenExpert");
            String WithinFacility = request.getParameter("WithinFacility");
            String HIVModality = request.getParameter("HIVModality");
            String ID = SubCountyRegNo + "_" + mflcode;
            System.out.println(
                    "ID : " + ID
                    + "Serial No: " + SerialNumber
                    + "SubCountyReg No: " + SubCountyRegNo
                    + " SubpartnerID : " + SubPartnerID
                    + " facility Name " + SubPartnerNom
                    + " MFLCODE " + mflcode
                    + "Reg Date :" + RegDate
                    + "Sex :" + Sex
                    + "Age: " + Age
                    + "Xray: " + Xray
                    + "Treatment Date :" + TreatmentDate
                    + "HIV Status :" + HIVStatus
                    + "HIV Test Date :" + HIVTestDate
                    + "Art Status :" + ArtStatus
                    + "Art Date :" + ArtDate
                    + "Support Type :" + SupportType
                    + "Smear0 :" + Smear0
                    + "GenExpert :" + GenExpert
                    + "Tested withing the Facility :" + WithinFacility
                    + "HIV Modality : " + HIVModality
            );
            // Initialize the database 
            //dbConn conn = new dbConn();
            // Create a SQL query to insert data into demo table 

            String Insert_data = "INSERT INTO `tibu_tb_raw`(`id`, `SubPartnerID`, `registrationdate`, `sex`, `age`, "
                    + "`treatmentdate`, `hivstatus`,`hivtestdate`,`artstatus`,`artdate`,`Mflcode`,`SubPartnerNom`, "
                    + "`supporttype`,`smear0`,`genexpert`, `tested_within_facility`, "
                    + "`initial_modality`,`subcounty_regno`,`serialno`,`xray`,`user_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            conn.pst = conn.conn.prepareStatement(Insert_data);

            // get the data using request object 
            // sets the data to st pointer 
            conn.pst.setString(1, ID);
            conn.pst.setString(2, SubPartnerID);
            conn.pst.setString(3, RegDate);
            conn.pst.setString(4, Sex);
            conn.pst.setString(5, Age);
            conn.pst.setString(6, TreatmentDate);
            conn.pst.setString(7, HIVStatus);
            conn.pst.setString(8, HIVTestDate);
            conn.pst.setString(9, ArtStatus);
            conn.pst.setString(10, ArtDate);
            conn.pst.setString(11, mflcode);
            conn.pst.setString(12, SubPartnerNom);
            conn.pst.setString(13, SupportType);
            conn.pst.setString(14, Smear0);
            conn.pst.setString(15, GenExpert);
            conn.pst.setString(16, WithinFacility);
            conn.pst.setString(17, HIVModality);
            conn.pst.setString(18, SubCountyRegNo);
            conn.pst.setString(19, SerialNumber);
            conn.pst.setString(20, Xray);
            conn.pst.setString(21, user_id);
            //String result = "";
            int outcome=conn.pst.executeUpdate();
            // Execute the insert command using executeUpdate() 
            // to make changes in database 
            if (outcome>0) {
                result += "Record Submited Successfully";
                   return result;
            }else{
            
                     return null;    
            }
            
            } catch (SQLException e) {
            throw e;
        } 
           
    
    }
}
