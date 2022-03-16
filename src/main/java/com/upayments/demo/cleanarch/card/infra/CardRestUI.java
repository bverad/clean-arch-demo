package com.upayments.demo.cleanarch.card.infra;

import com.upayments.demo.cleanarch.card.domain.Card;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CardRestUI {
    @PostMapping
    void createCard(@RequestBody Card card);

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    Card getCard(@PathVariable Integer id);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<Card> getAllCards();
}
