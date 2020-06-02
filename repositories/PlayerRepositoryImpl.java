package repositories;

import models.players.interfaces.Player;
import repositories.interfaces.PlayerRepository;

import java.util.List;

public class PlayerRepositoryImpl implements PlayerRepository {
    private List<Player> players;

    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public List<Player> getPlayers() {
        return null;
    }

    @Override
    public void add(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        } else if (this.players.contains(player)) {
            throw new IllegalArgumentException("Player " + player.getUsername() + " already exists!");
        } else {
            this.players.add(player);
        }
    }

    @Override
    public boolean remove(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        return this.players.remove(player);
    }

    @Override
    public Player find(String name) {
        Player playerToReturn = null;
        for (Player player : players) {
            if (player.getUsername().equals(name)) {
                playerToReturn = player;
            }
        }
        return playerToReturn;
    }
}
