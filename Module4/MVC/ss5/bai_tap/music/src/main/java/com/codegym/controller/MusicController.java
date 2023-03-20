package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicController {
    @Autowired
    private IMusicService<Music> iMusicService;

    @RequestMapping("")
    public String goHome(Model model) {
        model.addAttribute("list", iMusicService.findAll());
        return "home";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("music",new Music() );
        model.addAttribute("link","/create");
        return "form";
    }

    @PostMapping("/create")
    public String save(Music music, RedirectAttributes redirectAttributes){
        iMusicService.save(music);
        redirectAttributes.addFlashAttribute("message", "Create New Success");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdate(Model model, @PathVariable Integer id){
        model.addAttribute("music",iMusicService.findById(id));
        model.addAttribute("link","/edit");
        return "form";
    }

    @PostMapping("/edit")
    public String update(Music music, RedirectAttributes redirectAttributes) {
        iMusicService.update(music);
        redirectAttributes.addFlashAttribute("message", "update Success");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id,RedirectAttributes attributes){
        iMusicService.removeById(id);
        attributes.addFlashAttribute("message","delete Success");
        return "redirect:/";
    }

}
