package com.nhsbsa.medicinelist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
public class MedController {

    @Autowired
    private MedService medService;

    @RequestMapping(value="/")
    public static String MedInventory() {
        return "index";
    }

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

    @PutMapping(value = "/medicines/update/{id}")
    public String updateMedicine(@ModelAttribute Medicine medicine, @PathVariable("id") long id, Model model) {
        model.addAttribute("updatemedicine", medicine);
        medService.updateMedicine(id, medicine);
        return "updatemedicine";
    }

    @Transactional
    @GetMapping(value = "/medicines/delete/{id}")
    public String deleteMedicine(@PathVariable long id, Model model) {
        model.addAttribute("medicines", medService.getAllMeds());
        medService.deleteMedicine(id);
        return "redirect:/medicines";
    }

    @GetMapping(value="/medicines/search")
    public Object findMedicines(@RequestParam(value = "name", required=false) String name, Model model) {
        model.addAttribute("medicines", medService.listMedicineByName(name));
      return model;
    }



    @RequestMapping(value="/Listmedicine/{pagenum}", method = RequestMethod.GET)
    public String Listmedicine(@PathVariable int pagenum,  Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size ) {
        int currentPage = page.orElse(pagenum);
        int pageSize = size.orElse(5);

        Page<Medicine> medicinePage = medService.findPaginated(PageRequest.of(currentPage-1, pageSize));

        model.addAttribute("medicinePage", medicinePage);




        return "Listmedicine.html";
    }
}