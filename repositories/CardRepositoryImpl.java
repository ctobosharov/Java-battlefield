package repositories;

import models.cards.BaseCard;
import models.cards.interfaces.Card;
import repositories.interfaces.CardRepository;

import java.util.List;

public class CardRepositoryImpl implements CardRepository {
    private List<Card> cards;

    @Override
    public int getCount() {
        return cards.size();
    }

    @Override
    public List<Card> getCards() {
        return null;
    }

    @Override
    public void add(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null!");
        } else if (this.cards.contains(card)) {
            throw new IllegalArgumentException("Card " + card.getName() +" already exists!");
        }
        cards.add(card);
    }

    @Override
    public boolean remove(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null!");
        }
        return this.cards.remove(card);
    }

    @Override
    public Card find(String name) {
        Card cardToReturn = null;
        for (Card card : cards) {
            if (card.getName().equals(name)) {
                cardToReturn = card;
            }
        }
        return cardToReturn;
    }
}
