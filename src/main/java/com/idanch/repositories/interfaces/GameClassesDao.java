package com.idanch.repositories.interfaces;

import com.idanch.representations.HeroClass;

import java.util.List;

public interface GameClassesDao {
    HeroClass getHeroClass(String name);
    List<HeroClass> getAllHeroClasses();
}