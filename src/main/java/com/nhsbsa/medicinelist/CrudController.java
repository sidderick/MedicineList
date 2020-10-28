package com.nhsbsa.medicinelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Controller




public class CrudControl extends HttpServlet  {
    @Autowired
    private MedService medService;

        @RequestMapping(value="/control")
        public void doPost(HttpServletRequest request,
                              HttpServletResponse response) throws ServletException, IOException {

            // read form fields
            String Medname = request.getParameter("Medicince");

            // get response writer
            PrintWriter writer = response.getWriter();

            // build HTML code
            String htmlRespone = "<html>";
            htmlRespone += "<form name=\"Adding med\" method=\"post\" action=\"control\">";
            htmlRespone += "Medname <input type=\"text\" name=\"Medicince\"/> <br/>";
            htmlRespone += "<input type=\"submit\" value=\"Add\"/>";
            htmlRespone += "</form>";
            htmlRespone += "<h2> " + Medname +" is added to the system<br/>";
            htmlRespone += "</html>";

            // return response
            writer.println(htmlRespone);

        }




}