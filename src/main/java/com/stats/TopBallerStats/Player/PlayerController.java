package com.stats.TopBallerStats.Player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing player statistics.
 */
@RestController
@RequestMapping(path = "player")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    /**
     * Get a list of players based on various filters.
     * 
     * @param team the team name to filter by
     * @param name the player name to filter by
     * @param position the position to filter by
     * @param nation the nation to filter by
     * @return a list of players matching the filters
     */
    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String nation){

        if(team != null && position != null){
            return playerService.getPlayersByTeamAndPosition(team, position);
        }
        else if(team != null){
            return playerService.getPlayersFromTeam(team);
        }
        else if(name != null){
            return playerService.getPlayersByName(name);
        }
        else if(nation != null){
            return playerService.getPlayersByNation(nation);
        }
        else if(position != null){
            return playerService.getPlayerByPosition(position);
        } else {
            return playerService.getPlayers();
        }
    }

}