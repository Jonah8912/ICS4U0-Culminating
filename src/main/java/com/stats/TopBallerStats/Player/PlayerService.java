package com.stats.TopBallerStats.Player;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Service class for managing player statistics.
 */
@Component
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    /**
     * Get a list of all players.
     * 
     * @return a list of all players
     */
    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    /**
     * Get a list of players from a specific team.
     * 
     * @param teamName the team name to filter by
     * @return a list of players from the specified team
     */
    public List<Player> getPlayersFromTeam(String teamName){
        return playerRepository.findAll().stream()
                .filter(player -> teamName.equals(player.getTeam_name()))
                .collect(Collectors.toList());
    }

    /**
     * Get a list of players by name.
     * 
     * @param searchText the name to search for
     * @return a list of players matching the name
     */
    public List<Player> getPlayersByName(String searchText){
        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Get a list of players by position.
     * 
     * @param searchText the position to search for
     * @return a list of players matching the position
     */
    public List<Player> getPlayerByPosition(String searchText){
        return playerRepository.findAll().stream()
                .filter(player -> player.getPosition().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Get a list of players by nation.
     * 
     * @param searchText the nation to search for
     * @return a list of players matching the nation
     */
    public List<Player> getPlayersByNation(String searchText){
        return playerRepository.findAll().stream()
                .filter(player -> player.getNation().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Get a list of players by team and position.
     * 
     * @param team the team name to filter by
     * @param position the position to filter by
     * @return a list of players matching the team and position
     */
    public List<Player> getPlayersByTeamAndPosition(String team, String position){
        return playerRepository.findAll().stream()
                .filter(player -> team.equals(player.getTeam_name()) && position.equals(player.getPosition()))
                .collect(Collectors.toList());
    }

}