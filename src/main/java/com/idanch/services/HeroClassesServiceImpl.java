package com.idanch.services;

import com.idanch.repositories.interfaces.HeroClassesRepository;
import com.idanch.representations.HeroClass;
import com.idanch.services.interfaces.HeroClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroClassesServiceImpl implements HeroClassesService {

    private final HeroClassesRepository heroClassesRepository;

    @Autowired
    public HeroClassesServiceImpl(HeroClassesRepository heroClassesRepository) {
        this.heroClassesRepository = heroClassesRepository;
    }

    @Override
    public List<HeroClass> getAllHeroClasses() {
        return heroClassesRepository.getAllHeroClasses();
    }
}