package com.devau.travel.controller;

import com.devau.travel.entity.Traveller;
import com.devau.travel.entity.TravellerFilter;
import com.devau.travel.service.TravelService;
import javassist.expr.Cast;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/traveller")
public class TravelController {
    private TravelService travelService;

    public TravelController(TravelService theTravelService) {
        travelService = theTravelService;
    }

    @GetMapping("/list")
    public String listTraveller(Model theModel) {

        // get employees from db
        List<Traveller> theTraveller = travelService.findAll();

        // add to the spring model
        theModel.addAttribute("traveller", theTraveller);

        return "traveller/list-traveller";
    }

    @PostMapping("/filter-list")
    public String listTravellerWithFilter(@ModelAttribute("travellerFilter") TravellerFilter travellerFilter, Model theModel) {

        // get employees from db
        List<Traveller> theTraveller = travelService.findByDate(travellerFilter.getStart(), travellerFilter.getEnd());

        // add to the spring model
        theModel.addAttribute("traveller", theTraveller);

        return "traveller/list-traveller";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Traveller traveller = new Traveller();
        theModel.addAttribute("traveller", traveller);
        return "traveller/traveller-form";

    }

    @GetMapping("/goFilterPage")
    public String goFilterPage(Model theModel) {
        TravellerFilter travellerFilter = new TravellerFilter();
        theModel.addAttribute("travellerFilter", travellerFilter);
        return "traveller/traveller-filter";

    }

    @PostMapping("/save")
    public String saveTraveller(@ModelAttribute("traveller") Traveller traveller,Model theModel) throws ParseException {
        Date d1 = new SimpleDateFormat("yy-MM-dd").parse(traveller.getStartDate());
        Date d2 = new SimpleDateFormat("yy-MM-dd").parse(traveller.getEndDate());


        if (d1.compareTo(d2) > 0) {
            theModel.addAttribute("error","Lütfen Bitiş tarihini Başlangıç Tarihinden sonra giriniz");
            return "traveller/error-page";
        }
        /*save Employee*/ travelService.save(traveller);


        //use a redirect to prevent dublicate submission
        return "redirect:/traveller/list";

    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int theId, Model theModel) {
        //get the  employee from the service
        Traveller theTraveller = travelService.findById(theId);
        //set  employee add model  service
        theModel.addAttribute("traveller", theTraveller);
        //send over to our form
        return "traveller/traveller-form";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int theId) {
        //delete the Employee
        travelService.deleteById(theId);
        //redirect to /employees/list
        return "redirect:/traveller/list";
    }

}
