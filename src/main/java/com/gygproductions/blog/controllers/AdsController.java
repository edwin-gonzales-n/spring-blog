package com.gygproductions.blog.controllers;

import com.gygproductions.blog.models.Ad;
import com.gygproductions.blog.services.AdService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdsController {

    AdService adSvc;

    public AdsController(AdService adSvc) {
        this.adSvc = adSvc;
    }

    @GetMapping("/ads")
    public String index(Model model) {
        model.addAttribute("ads", adSvc.getAllAds());
        return "/ads/index";
    }

    @GetMapping("/ads/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("ad", adSvc.getAd(id));
        return "/ads/show";
    }

    @GetMapping("/ads/create")
    public String showCreateForm(Model viewModel) {
        viewModel.addAttribute("newAd", new Ad());
        return "/ads/create";
    }

    @PostMapping("/ads/create")
    public String insert(@ModelAttribute Ad newAd) {
        adSvc.save(newAd);
        return "redirect:/ads";
    }

}