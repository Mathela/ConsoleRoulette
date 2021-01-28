/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.iq.domain;

import java.util.Date;
import java.util.List;

/**
 *
 * @author nkosinathi mathela
 */
public class GameSession {
    // a game session has a list of players,player bets(positions),winnit bets, start time ,end time, number of rounds played.
    private List<Player> players;
    private int winningPosition;
    private int winningParity;
    private List<Bet> winningParityBets;
    private List<Bet>  winningPositionBets;
    private List<Bet> bets;
    private Date startTime;
    private Date endTime;
    private int totalRounds;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getWinningPosition() {
        return winningPosition;
    }

    public void setWinningPosition(int winningPosition) {
        this.winningPosition = winningPosition;
    }

    public int getWinningParity() {
        return winningParity;
    }

    public void setWinningParity(int winningParity) {
        this.winningParity = winningParity;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public void setTotalRounds(int totalRounds) {
        this.totalRounds = totalRounds;
    }

    public List<Bet> getWinningParityBets() {
        return winningParityBets;
    }

    public void setWinningParityBets(List<Bet> winningParityBets) {
        this.winningParityBets = winningParityBets;
    }

    public List<Bet> getWinningPositionBets() {
        return winningPositionBets;
    }

    public void setWinningPositionBets(List<Bet> winningPositionBets) {
        this.winningPositionBets = winningPositionBets;
    }


}
