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
    private List<Bet> bets;
    private Date startTime;
    private Date endTime;
    private int totalRounds;
    
}
