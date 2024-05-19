/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.add;

import controller.BaseRequiredAuthenticationController;
import dal.CertificateDBContext;
import dal.EmployeeDBContext;
import entity.Account;
import entity.Certificate;
import entity.EmpCert;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author admin
 */
public class AddController extends BaseRequiredAuthenticationController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        String rawid = req.getParameter("id");
        String name = req.getParameter("name");
        Date dob = Date.valueOf(req.getParameter("dob")) ;
        String rawgender = req.getParameter("gender");
        Boolean gender ;
        if (rawgender.equals("male")) {
            gender=true;
        }else{
            gender=false;
        }
        ArrayList<EmpCert> lists = new ArrayList<>();
        CertificateDBContext cdb = new CertificateDBContext();
        for (Certificate cert : cdb.getCertificates()) {
            String rawcertid = req.getParameter("cert"+cert.getId());
            if (rawcertid!=null) {
                Date datecert = Date.valueOf(req.getParameter("datecert"+cert.getId()));
                EmpCert ec = new EmpCert();
                ec.setEmpid(Integer.parseInt(rawid));
                ec.setCertid(Integer.parseInt(rawcertid));
                ec.setDate(datecert);
                lists.add(ec);
            }
        }
        EmployeeDBContext edb = new EmployeeDBContext();
        edb.addEmployee(Integer.parseInt(rawid), name, gender, dob, account.getUsername());
        for (EmpCert list : lists) {
            cdb.addEmployeeCertificate(list.getEmpid(), list.getCertid(), list.getDate());
        }
        resp.getWriter().println("Add successfully!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        CertificateDBContext cdb = new CertificateDBContext();
        ArrayList<Certificate> certs = cdb.getCertificates();
        req.setAttribute("certs", certs);
        req.getRequestDispatcher("add.jsp").forward(req, resp);
    }
   
    
}
