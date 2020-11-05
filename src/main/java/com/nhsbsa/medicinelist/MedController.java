package com.nhsbsa.medicinelist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Optional;


@Controller
public class MedController {

    @Autowired
    private MedService medService;




    @GetMapping("/addmedicines")
    public String addMedForm(Model model) {
        model.addAttribute("addmedicines", new Medicine());
        return "addmedicines";
    }

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

    @GetMapping(value = "/medicines/update/{id}")
    public String updateMedicine(@RequestBody Medicine medicine, @PathVariable("id") long id, Model model) {
        model.addAttribute("updatemedicine", medicine);
        medService.updateMedicine(medicine);
        return "updatemedicine";
    }







    @RequestMapping(value = "/medicines/{id}")
    public Optional<Medicine> getMedicine(@PathVariable long id) {
        return medService.getMedicine(id);
    }




    @RequestMapping(value = "/medicines", method = RequestMethod.POST)
    public void addMedicine(@RequestBody Medicine medicine) {
        medService.addMedicine(medicine);
    }




        @RequestMapping(value = "/medicines/{id}", method = RequestMethod.DELETE)
        public void deleteMedicine(@PathVariable long id) {
            medService.deleteMedicine(id);
        }

    @GetMapping(value="/medicines/search/{medName}")
    public Model findMedicines(@PathVariable String name, Model model) throws ServletException, IOException {
        model.addAttribute("medicineResults", medService.listMedicineByName(name));

        return model;
    }


}
