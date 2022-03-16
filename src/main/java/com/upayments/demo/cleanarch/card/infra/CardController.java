package com.upayments.demo.cleanarch.card.infra;

import com.upayments.demo.cleanarch.card.domain.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardController implements CardRestUI {

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
