package com.nhsbsa.medicinelist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BasepageController {

        @RequestMapping(value="/")
        public static String MedInventory() {
            return "index";
        }
}
