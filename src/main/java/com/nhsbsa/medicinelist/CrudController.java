package com.nhsbsa.medicinelist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@Controller
class CrudControl extends HttpServlet  {
    @Autowired
    private MedService medService;

        @RequestMapping(value="/control")
        @Override
        public void doPost(HttpServletRequest request,
                              HttpServletResponse response) throws ServletException, IOException {

            String Medname = request.getParameter("Medicince");


            PrintWriter writer = response.getWriter();


            String htmlRespone = "<html>";
            htmlRespone += "<form name=\"Adding med\" method=\"post\" action=\"control\">";
            htmlRespone += "Medname <input type=\"text\" name=\"Medicince\"/> <br/>";
            htmlRespone += "<input type=\"submit\" value=\"Add\"/>";
            htmlRespone += "</form>";
            htmlRespone += "<h2> " + Medname +" is added to the system<br/>";
            htmlRespone += "</html>";


            writer.println(htmlRespone);

            SQLQ(Medname);

        }

        public void SQLQ(String Medname ) {

            String SQLQ = "SELECT (med_Name) FROM MEDICINES WHERE MED_NAME =" + "'" + Medname + "'";

            try {
                Connection con = DriverManager.getConnection(
                        "jdbc:h2:file:./medicinelist/src/main/resources/data/medicine", "Sa", "");
                Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery("SELECT (med_Name) FROM MEDICINES WHERE MED_NAME =" + "'" + Medname + "'");
                if (rs.next())
                    System.out.println(rs.getString("med_Name"));
                else if (!rs.next())
                    System.out.println("not found");
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

}