package models.battleFields;

import models.battleFields.interfaces.Battlefield;
import models.cards.interfaces.Card;
import models.players.interfaces.Player;

public class BattleFieldImpl implements Battlefield {

    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {
        if (attackPlayer.isDead() || enemyPlayer.isDead()) {
            throw new IllegalArgumentException("Player is dead!");
        }
        if (attackPlayer.getHealth() == 50) {
            attackPlayer.setHealth(attackPlayer.getHealth() + 40);
            for (Card c : attackPlayer.getCardRepository().getCards()) {
                c.setDamagePoints(c.getDamagePoints() + 30);
            }
        }

        for (Card c : attackPlayer.getCardRepository().getCards()) {
            attackPlayer.setHealth(attackPlayer.getHealth() + c.getHealthPoints());
        }

        for (Card c : enemyPlayer.getCardRepository().getCards()) {
            enemyPlayer.setHealth(enemyPlayer.getHealth() + c.getHealthPoints());
        }

        for (Card c : attackPlayer.getCardRepository().getCards()) {
            enemyPlayer.takeDamage(c.getDamagePoints());
        }

        for (Card c : enemyPlayer.getCardRepository().getCards()) {
            attackPlayer.takeDamage(c.getDamagePoints());
        }

        if (attackPlayer.isDead() || enemyPlayer.isDead()) {
            return;
        }
    }
}
