package com.stats.TopBallerStats.Player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_statistic")
public class Player {

    @Id
    @Column(name = "player_name", unique = true)
    private String name;

    private String nation;

    private String position;

    private String team_name;

    private Integer age;

    private Integer year_born;

    private Integer matches_played;

    private Integer starts;

    private Integer minutes_played;

    private Integer goals;

    private Integer assists;

    private Integer goals_assists;

    private Integer goals_assists_nopk;

    private Integer penalties_scored;

    private Integer yellow_cards;

    private Integer red_cards;

    private Double expected_goals;

    private Double expected_assists;

    public Player() {
    }

    public Player(String name, String nation, String position, String team_name, Integer age, Integer year_born, Integer matches_played, Integer starts, Integer minutes_played, Integer goals, Integer assists, Integer goals_assists, Integer goals_assists_nopk, Integer penalties_scored, Integer yellow_cards, Integer red_cards, Double expected_goals, Double expected_assists) {
        this.name = name;
        this.nation = nation;
        this.position = position;
        this.team_name = team_name;
        this.age = age;
        this.year_born = year_born;
        this.matches_played = matches_played;
        this.starts = starts;
        this.minutes_played = minutes_played;
        this.goals = goals;
        this.assists = assists;
        this.goals_assists = goals_assists;
        this.goals_assists_nopk = goals_assists_nopk;
        this.penalties_scored = penalties_scored;
        this.yellow_cards = yellow_cards;
        this.red_cards = red_cards;
        this.expected_goals = expected_goals;
        this.expected_assists = expected_assists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getYear_born() {
        return year_born;
    }

    public void setYear_born(Integer year_born) {
        this.year_born = year_born;
    }

    public Integer getMatches_played() {
        return matches_played;
    }

    public void setMatches_played(Integer matches_played) {
        this.matches_played = matches_played;
    }

    public Integer getStarts() {
        return starts;
    }

    public void setStarts(Integer starts) {
        this.starts = starts;
    }

    public Integer getMinutes_played() {
        return minutes_played;
    }

    public void setMinutes_played(Integer minutes_played) {
        this.minutes_played = minutes_played;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getGoals_assists() {
        return goals_assists;
    }

    public void setGoals_assists(Integer goals_assists) {
        this.goals_assists = goals_assists;
    }

    public Integer getGoals_assists_nopk() {
        return goals_assists_nopk;
    }

    public void setGoals_assists_nopk(Integer goals_assists_nopk) {
        this.goals_assists_nopk = goals_assists_nopk;
    }

    public Integer getPenalties_scored() {
        return penalties_scored;
    }

    public void setPenalties_scored(Integer penalties_scored) {
        this.penalties_scored = penalties_scored;
    }

    public Integer getYellow_cards() {
        return yellow_cards;
    }

    public void setYellow_cards(Integer yellow_cards) {
        this.yellow_cards = yellow_cards;
    }

    public Integer getRed_cards() {
        return red_cards;
    }

    public void setRed_cards(Integer red_cards) {
        this.red_cards = red_cards;
    }

    public Double getExpected_goals() {
        return expected_goals;
    }

    public void setExpected_goals(Double expected_goals) {
        this.expected_goals = expected_goals;
    }

    public Double getExpected_assists() {
        return expected_assists;
    }

    public void setExpected_assists(Double expected_assists) {
        this.expected_assists = expected_assists;
    }
}