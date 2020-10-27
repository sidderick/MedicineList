package com.nhsbsa.medicinelist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasepageController {

        @RequestMapping(value="/")
        public static String MedInventory() {
            return "index";
        }
}
