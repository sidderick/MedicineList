package com.nhsbsa.medicinelist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Controller



//@WebServlet(value = "/control")
public class CrudController extends HttpServlet  {
    @Autowired
    private MedService medService;

        @RequestMapping(value="/control")
        protected void doPost(HttpServletRequest request,
                              HttpServletResponse response) throws ServletException, IOException {

            // read form fields
            String medName = request.getParameter("Medicine");

            // do some processing here...

            // get response writer
            PrintWriter writer = response.getWriter();

            // build HTML code
            String htmlResponse = "<html>";
            htmlResponse += "<form name=\"Adding med\" method=\"post\" action=\"control\">";
            htmlResponse += "medName <input type=\"text\" name=\"Medicine\"/> <br/>";
            htmlResponse += "<input type=\"submit\" value=\"Add\"/>";
            htmlResponse += "</form>";
            htmlResponse += "<h2> " + medName +" is added to the system<br/>";
            htmlResponse += "</html>";

            // return response
            writer.println(htmlResponse);




        }

    @RequestMapping(value = "/medicines", method = RequestMethod.POST)
    public void addMedicine(@RequestBody Medicines medName) {
        medService.addMedicine(medName);
    }


}
