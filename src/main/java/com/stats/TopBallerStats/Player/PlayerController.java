package com.stats.TopBallerStats.Player;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "player")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String nation){

        if(team != null && position != null){
            return playerService.getPlayersByTeamAndPosition(team,position);
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