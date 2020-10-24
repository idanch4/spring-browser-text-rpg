package com.idanch.controllers;

import com.idanch.representations.HeroClass;
import com.idanch.services.interfaces.HeroClassesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GameController {
    public static final Logger log = LoggerFactory.getLogger(GameController.class);

    private final HeroClassesService heroClassesService;

    @Autowired
    public GameController(HeroClassesService heroClassesService) {
        this.heroClassesService = heroClassesService;
    }

    @GetMapping("/classes")
    public String getClasses(Model model) {
        log.info("Get request to /classes");
        List<HeroClass> heroClasses = heroClassesService.getAllHeroClasses();
        model.addAttribute("heroClassList", heroClasses);
        return "hero_classes";
    }
}
