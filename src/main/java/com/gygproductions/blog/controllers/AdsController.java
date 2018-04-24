package com.gygproductions.blog.controllers;

import com.gygproductions.blog.models.Ad;
import com.gygproductions.blog.repositories.AdRepository;
import com.gygproductions.blog.services.AdService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AdsController {

    private final AdRepository adDao;

    public AdsController(AdRepository adDao) {
        this.adDao = adDao;
    }

    @GetMapping("/ads")
    public String index(Model model) {
        model.addAttribute("ads", adDao.findAll());
        return "/ads/index";
    }

    @GetMapping("/ads/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("ad", adDao.findOne(id));
        return "/ads/show";
    }

    @GetMapping("/ads/create")
    public String showCreateForm(Model viewModel) {
        viewModel.addAttribute("newAd", new Ad());
        return "/ads/create";
    }

    @PostMapping("/ads/create")
    public String create(@Valid Ad ad, Errors errors, Model model) {
        if (errors.hasErrors()){
            model.addAttribute("ad", ad);
            return "ads/created_ad";
        }
        adDao.save(ad);
        return "redirect:/ads";
    }

    @GetMapping("/ads/{id}/edit")
    public String edit(@PathVariable long id, Model viewModel){
        viewModel.addAttribute("ad", adDao.findOne(id));
        return "/ads/edit";
    }

    @PostMapping("/ads/edit")
    public String handleEdit(@ModelAttribute Ad ad){
        adDao.save(ad);
        return "redirect:/ads";
    }

    @PostMapping("/ads/delete")
    public String deleteAd(@ModelAttribute Ad ad){
        adDao.delete(ad);
        return "redirect:/ads";
    }
}