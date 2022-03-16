package com.upayments.demo.cleanarch.card.domain;

import java.util.Objects;

public class Card {
    private Integer number;
    private String denomination;
    private Integer codStatus;
    private String descriptionStatus;

    public Card(Integer number, String denomination, Integer codStatus, String descriptionStatus) {
        this.number = number;
        this.denomination = denomination;
        this.codStatus = codStatus;
        this.descriptionStatus = descriptionStatus;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denominacion) {
        this.denomination = denominacion;
    }

    public Integer getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(Integer codStatus) {
        this.codStatus = codStatus;
    }

    public String getDescriptionStatus() {
        return descriptionStatus;
    }

    public void setDescriptionStatus(String descriptionStatus) {
        this.descriptionStatus = descriptionStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(number, card.number) && Objects.equals(denomination, card.denomination) && Objects.equals(codStatus, card.codStatus) && Objects.equals(descriptionStatus, card.descriptionStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, denomination, codStatus, descriptionStatus);
    }

    @Override
    public String toString() {
        return "Card{" +
                "number='" + number + '\'' +
                ", denomination='" + denomination + '\'' +
                ", codStatus=" + codStatus +
                ", descriptionStatus='" + descriptionStatus + '\'' +
                '}';
    }
}
