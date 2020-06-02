package core;

import core.interfaces.ManagerController;
import models.battleFields.BattleFieldImpl;
import models.cards.MagicCard;
import models.cards.TrapCard;
import models.cards.interfaces.Card;
import models.players.Advanced;
import models.players.BasePlayer;
import models.players.Beginner;
import models.players.interfaces.Player;
import repositories.CardRepositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class ManagerControllerImpl implements ManagerController {
    private List<Player> players;
    private List<Card> cards;

    public ManagerControllerImpl() {
        players = new LinkedList<>();
        cards = new ArrayList<>();
    }

    @Override
    public String addPlayer(String type, String username) {
        for (Player player : players) {
            if (username.equals(player.getUsername())) {
                return String.format("Player %s already exists!", username);
            }
        }

        if (type.equals("Beginner")) {
            Beginner beginner = new Beginner(new CardRepositoryImpl(), username);
            players.add(beginner);
        } else {
            Advanced advanced = new Advanced(new CardRepositoryImpl(), username);
            players.add(advanced);
        }
        return String.format("Successfully added player of type %s with username: %s", type, username);
    }

    @Override
    public String addCard(String type, String name) {
        for (Card card : this.cards) {
            if (name.equals(card.getName())) {
                return String.format("Card %s already exists!", name);
            }
        }

        if (type.equals("Trap")) {
            TrapCard trapCard = new TrapCard(name);
            this.cards.add(trapCard);
        } else {
            MagicCard magicCard = new MagicCard(name);
            this.cards.add(magicCard);
        }

        return String.format("Successfully added card of type %sCard with name: %s", type, name);
    }

    @Override
    public String addPlayerCard(String username, String cardName) {
        for (Player player : players) {
            if (player.getUsername().equals(username)) {
                for (Card card : cards) {
                    if (card.getName().equals(cardName)) {
                        player.getCardRepository().add(card);
                        return String.format("Successfully added card: %s to user: %s", cardName, username);
                    }
                }
            }
        }
        return String.format("Card cannot be null!");
    }

    @Override
    public String fight(String attackUser, String enemyUser) {
        BattleFieldImpl battleField = new BattleFieldImpl();

        for (Player player : players) {
            if (player.getUsername().equals(attackUser)) {
                for (Player e : players) {
                    if (player.getUsername().equals(enemyUser)) {
                        battleField.fight(player, e);
                        return String.format("Attack user health %d - Enemy user health %d", player.getHealth(), e.getHealth());
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String report() {
        return null;
    }
}
