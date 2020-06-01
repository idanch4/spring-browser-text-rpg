package com.idanch.representations;

import org.springframework.lang.NonNull;

public final class HeroClass {
    @NonNull
    private String name;
    @NonNull
    private String description;

    public HeroClass(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HeroClass heroClass = (HeroClass) o;

        if (!name.equals(heroClass.name)) return false;
        return description.equals(heroClass.description);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "HeroClass{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}