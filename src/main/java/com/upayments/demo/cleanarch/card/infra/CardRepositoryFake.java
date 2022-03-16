package com.upayments.demo.cleanarch.card.infra;

import com.upayments.demo.cleanarch.card.domain.Card;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CardRepositoryFake implements CardRepository{
    private List<Card> cardList = new ArrayList<>();


    @Bean
    @Primary
    public CardRepository getCardRepository(){
        System.out.println("Inicializando card repository fake");

        CardRepository cardRepository = new CardRepositoryFake();
        cardRepository.createCard(new Card(1,"Bruno Vera",1,"Embozada"));
        cardRepository.createCard(new Card(2,"Matias Otelo",1,"Embozada"));
        cardRepository.createCard(new Card(3,"Christian Chamblot",1,"Embozada"));
        cardRepository.createCard(new Card(4,"Francisco Javier Moreno",1,"Embozada"));
        cardRepository.createCard(new Card(5,"Gonzalo Marín",1,"Embozada"));




        return cardRepository;
    }

    @Override
    public void createCard(Card card) {
        cardList.add(card);
    }

    @Override
    public Card getCard(Integer number) {
        System.out.println(number + "   " + cardList.size());
        for(Card card : cardList){
            if(card.getNumber() == number){
                return card;
            }
        }

        return null;
    }

    @Override
    public List<Card> getAllCards() {
        return cardList;
    }
}
