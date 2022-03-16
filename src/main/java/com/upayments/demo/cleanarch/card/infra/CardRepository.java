package com.upayments.demo.cleanarch.card.infra;

import com.upayments.demo.cleanarch.card.domain.Card;

import java.util.List;

public interface CardRepository {

    void createCard(Card card);

    Card getCard(Integer number);

    List<Card> getAllCards();


}
