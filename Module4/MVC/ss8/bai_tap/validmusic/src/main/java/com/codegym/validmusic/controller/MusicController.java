package com.codegym.validmusic.controller;

import com.codegym.validmusic.model.Music;
import com.codegym.validmusic.service.ICategoryService;
import com.codegym.validmusic.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class MusicController {
    @Autowired
    IMusicService service;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public String goHome(Model model, @RequestParam(value = "name", defaultValue = "") String name,
                         @PageableDefault(size = 5, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("list", service.findAllByName(name, pageable));
        return "/home";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("music", new Music());
        model.addAttribute("list", categoryService.findAll());
        return "/update";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id,Model model){
        model.addAttribute("music", service.findById(id));
        model.addAttribute("list", categoryService.findAll());
        return "/update";
    }

    @PostMapping("/update")
    public String updateDB(@Valid @ModelAttribute("music") Music music, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("list", categoryService.findAll());
            return "/update";
        }
        if (music.getId() == null) {
            redirectAttributes.addFlashAttribute("message", "create ok");
        } else {
            redirectAttributes.addFlashAttribute("message", "edit ok");
        }
        service.save(music);
        return "redirect:/";
    }


}
