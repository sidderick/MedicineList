package com.nhsbsa.medicinelist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class MedController {

    @Autowired
    private MedService medService;

    @RequestMapping(value="/medicines", method = RequestMethod.GET)
    public String getAllMeds(Model model){
        List<Medicines> medicines = medService.getAllMeds();
        model.addAttribute("medicines", medicines);
        return "medicines";
    }
/*                                      next method works with @RestController to show raw db data
    @RequestMapping(value="/medicines", method = RequestMethod.GET)
    public List<Medicines> getAllMeds(){
        return medService.getAllMeds();
    } */

    @RequestMapping(value = "/medicines/{id}")
    public Optional<Medicines> getMedicine(@PathVariable long id) {
        return medService.getMedicine(id);
    }

    @RequestMapping(value = "/medicines", method = RequestMethod.POST)
    public void addMedicine(@RequestBody Medicines medicines) {
        medService.addMedicine(medicines);
    }

    @RequestMapping(value = "/medicines/{id}", method = RequestMethod.PUT)
    public void updateMedicine(@RequestBody Medicines medicines, @PathVariable long id) {
        medService.updateMedicine(id,medicines);
    }

    @RequestMapping(value = "/medicines/{id}", method = RequestMethod.DELETE)
    public void deleteMedicine(@PathVariable long id) {
        medService.deleteMedicine(id);
    }



}
