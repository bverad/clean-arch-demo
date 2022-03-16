package com.upayments.demo.cleanarch.card.application;

import com.upayments.demo.cleanarch.card.domain.Card;

import java.util.List;

public interface CardService {
    void createCard(Card card);

    Card getCard(Integer id);

    List<Card> getAllCards();
}
