package com.jbcstore.jbcstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Controller
public class MainController{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @NotNull
    @Size(min=2)
    private String item;
    @NotNull
    @Size(min=2)
    private String Revenue;
    @Autowired
    CosmoticsRepository cosmoticsRepository;

    @Autowired
    SnacksRepository snacksRepository;


    @Autowired
    CleaningitemsRepository cleaningitemsRepository;


    @RequestMapping("/cli")
    public String listCliningitmess(Model model) {
        model.addAttribute("cleaningitems", cleaningitemsRepository.findAll());
        return "listCleaning";

    }
    @RequestMapping("/sna")
    public String listSnacks(Model model) {
        model.addAttribute("snackss", snacksRepository.findAll());
        return "listSnacks";
    }
    @RequestMapping("/cos")
    public String listCosmoticss(Model model) {
        model.addAttribute("cosmoticss", cosmoticsRepository.findAll());
        return "listCosmotics";}



    @GetMapping("/addcos")
    public String cosmoticsForm(Model model) {
        model.addAttribute("cosmotics", new Cosmotics());
        return "cosmoticsform";
    }
    @GetMapping("/addsna")
    public String snacksForm(Model model) {
        model.addAttribute("snacks", new Snacks());
        return "snacksform";
    }
    @GetMapping("/addcli")
    public String cleaningitemsForm(Model model) {
        model.addAttribute("cliningitem", new Cleaningitems());
        return "cleaningitemsform";
    }
    @PostMapping("/processcos")
    public String processForm(@Valid Cosmotics cosmotics, BindingResult result) {
        if (result.hasErrors()) {
            return "cosmoticsform";
        }
        cosmoticsRepository.save(cosmotics);
        return "redirect:/";
    }
    @PostMapping("/processsna")
    public String processForm(@Valid Snacks snacks, BindingResult result) {
        if (result.hasErrors()) {
            return "snacksform";
        }
        snacksRepository.save(snacks);
        return "redirect:/";
    }


    @PostMapping("/processcli")
    public String processForm(@Valid Cleaningitems cleaningitems, BindingResult result) {
        if (result.hasErrors()) {
            return "cleaningitemsform";
        }
        cleaningitemsRepository.save(cleaningitems);
        return "redirect:/";
    }

    @RequestMapping("/detail/cli/{id}")

    public String showCleaningitems(@PathVariable("id") long id, Model model) {

        model.addAttribute("cleaningitems", cleaningitemsRepository.findOne(id));

        return "show";

    }
    @RequestMapping("/detail/sna/{id}")

    public String showSnacks(@PathVariable("id") long id, Model model) {

        model.addAttribute("snacks", snacksRepository.findOne(id));

        return "show";
    }

        @RequestMapping("/detail/cos/{id}")

    public String showCosmotics(@PathVariable("id") long id, Model model) {

        model.addAttribute("cosmotics", cosmoticsRepository.findOne(id));

        return "show";
    }

    @RequestMapping("/update/cli/{id}")

    public String updateCleaningitems(@PathVariable("id") long id, Model model) {

        model.addAttribute("cleaningitems", cleaningitemsRepository.findOne(id));

        return "cleaningitemsform";

    }
    @RequestMapping("/update/sna/{id}")

    public String updateSnacks(@PathVariable("id") long id, Model model) {

        model.addAttribute("snacks", snacksRepository.findOne(id));

        return "snacksform";
    }
    @RequestMapping("/update/cos/{id}")

    public String updateCosmotics(@PathVariable("id") long id, Model model) {

        model.addAttribute("cosmotics", cosmoticsRepository.findOne(id));

        return "cosmoticsform";
    }


        @RequestMapping("/delete/cli/{id}")
    public String delCleaningitems(@PathVariable("id") long id) {
            cleaningitemsRepository.delete(id);
            return "redirect:/";
        }
    @RequestMapping("/delete/sna/{id}")
    public String delSnacks(@PathVariable("id") long id) {
       snacksRepository.delete(id);
        return "redirect:/";
    }
            @RequestMapping("/deletecos/cos/{id}")
            public String delCosmotics(@PathVariable("id") long id) {
                cosmoticsRepository.delete(id);
                return "redirect:/";
    }

}

