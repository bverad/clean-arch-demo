package com.upayments.demo.cleanarch.card.application;

import com.upayments.demo.cleanarch.card.domain.Card;
import com.upayments.demo.cleanarch.card.infra.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CardServiceImpl implements CardService{

    @Autowired
    private CardRepository cardRepository;

    @Override
    public void createCard(Card card) {
        cardRepository.createCard(card);
    }

    @Override
    public Card getCard(Integer id) {
        return cardRepository.getCard(id);
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.getAllCards();
    }
}
