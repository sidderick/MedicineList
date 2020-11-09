package com.nhsbsa.medicinelist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Controller
public class MedController {

    @Autowired
    private MedService medService;

    //returns addmedicines form where user can add in new entries
    @GetMapping("/addmedicines")
    public String addMedForm(Model model) {
        model.addAttribute("addmedicines", new Medicine());
        return "addmedicines";
    }

    //once new entry received, confirms that and provides an option of where to go next
    @PostMapping("/addmedicines")
    public String addMedSubmit(@ModelAttribute Medicine medicine, Model model) {
        model.addAttribute("addmedicines", medicine);
        medService.addMedicine(medicine);
        return "addresult";

    }

    // next block works to show list of meds on /medicines
    @RequestMapping(value = "/medicines", method = RequestMethod.GET)
    public String getAllMeds(Model model) {
        model.addAttribute("medicines", medService.getAllMeds());
        return "medicines";
    }

    @RequestMapping(value = "/medicines/update/{id}")
    public String updateMedicine(@ModelAttribute Medicine medicine, @PathVariable("id") long id, Model model) {
        model.addAttribute("updatemedicine", medicine);
        medService.updateMedicine(id, medicine);
        return "updatemedicine";
    }


    /*


        @RequestMapping(value = "/medicines/{id}", method = RequestMethod.DELETE)
        public void deleteMedicine(@PathVariable long id) {
            medService.deleteMedicine(id);
        }
    */
    @GetMapping(value="/medicines/search/{medName}")
    public Model findMedicines(@PathVariable String name, Model model) throws ServletException, IOException {
        model.addAttribute("medicineResults", medService.listMedicineByName(name));

        return model;
    }


}
