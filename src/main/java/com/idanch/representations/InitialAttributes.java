package com.idanch.representations;

import org.springframework.lang.NonNull;

public final class InitialAttributes {
    @NonNull
    private String heroClassName;

    private Integer charisma;
    private Integer integrity;
    private Integer confidence;
    private Integer luck;

    public InitialAttributes(String heroClassName, Integer charisma, Integer integrity, Integer confidence, Integer luck) {
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

        if (!heroClassName.equals(that.heroClassName)) return false;
        if (charisma != null ? !charisma.equals(that.charisma) : that.charisma != null) return false;
        if (integrity != null ? !integrity.equals(that.integrity) : that.integrity != null) return false;
        if (confidence != null ? !confidence.equals(that.confidence) : that.confidence != null) return false;
        return luck != null ? luck.equals(that.luck) : that.luck == null;
    }

    @Override
    public int hashCode() {
        int result = heroClassName.hashCode();
        result = 31 * result + (charisma != null ? charisma.hashCode() : 0);
        result = 31 * result + (integrity != null ? integrity.hashCode() : 0);
        result = 31 * result + (confidence != null ? confidence.hashCode() : 0);
        result = 31 * result + (luck != null ? luck.hashCode() : 0);
        return result;
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