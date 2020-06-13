package com.idanch.repositories.interfaces;

import com.idanch.representations.HeroClass;

import java.util.List;

public interface HeroClassesRepository {
    HeroClass getHeroClass(String name);
    List<HeroClass> getAllHeroClasses();
}