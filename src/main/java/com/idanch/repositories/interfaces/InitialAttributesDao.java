package com.idanch.repositories.interfaces;

import com.idanch.representations.InitialAttributes;

import java.util.List;

public interface InitialAttributesDao {
    InitialAttributes getInitialAttributes(String heroClassName);
    List<InitialAttributes> getAllInitialAttributes();
}
