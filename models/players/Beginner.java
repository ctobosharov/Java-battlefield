package models.players;

import models.players.BasePlayer;
import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;

public class Beginner extends BasePlayer {
    private static final int defaultHealthPoints = 50;

    public Beginner(CardRepository cardRepository, String username) {
        super(cardRepository, username, defaultHealthPoints);
    }

}
