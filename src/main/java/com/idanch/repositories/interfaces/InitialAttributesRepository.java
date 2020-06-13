package com.idanch.repositories.interfaces;

import com.idanch.representations.InitialAttributes;

import java.util.List;

public interface InitialAttributesRepository {
    InitialAttributes getInitialAttributes(String heroClassName);
    List<InitialAttributes> getAllInitialAttributes();
}
