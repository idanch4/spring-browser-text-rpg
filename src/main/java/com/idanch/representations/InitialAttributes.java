package com.idanch.representations;

import org.springframework.lang.NonNull;

public final class InitialAttributes {
    @NonNull
    private String heroClassName;

    private Integer charisma;
    private Integer integrity;
    private Integer confidence;
    private Integer luck;

    // TODO: Consider a better way to construct objects of this class
    public InitialAttributes(String heroClassName, Integer charisma,
                             Integer integrity, Integer confidence, Integer luck) {
        this.heroClassName = heroClassName;
        this.charisma = charisma;
        this.integrity = integrity;
        this.confidence = confidence;
        this.luck = luck;
    }

    public String getHeroClassName() {
        return heroClassName;
    }

    public void setHeroClassName(String heroClassName) {
        this.heroClassName = heroClassName;
    }

    public Integer getCharisma() {
        return charisma;
    }

    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
    }

    public Integer getIntegrity() {
        return integrity;
    }

    public void setIntegrity(Integer integrity) {
        this.integrity = integrity;
    }

    public Integer getConfidence() {
        return confidence;
    }

    public void setConfidence(Integer confidence) {
        this.confidence = confidence;
    }

    public Integer getLuck() {
        return luck;
    }

    public void setLuck(Integer luck) {
        this.luck = luck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InitialAttributes that = (InitialAttributes) o;

        return heroClassName.equals(that.heroClassName);
    }

    @Override
    public int hashCode() {
        return heroClassName.hashCode();
    }

    @Override
    public String toString() {
        return "InitialAttributes{" +
                "heroClassName='" + heroClassName + '\'' +
                ", charisma=" + charisma +
                ", integrity=" + integrity +
                ", confidence=" + confidence +
                ", luck=" + luck +
                '}';
    }
}