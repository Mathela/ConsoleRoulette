/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.iq.services;

import com.wonderlabz.iq.domain.Bet;
import com.wonderlabz.iq.domain.GameSession;
import com.wonderlabz.iq.domain.Player;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class GameServiceImpl implements GameService {
     /**
     *creates a new game session with the given  player names 
     * @param playerNames
     * @return GameSession
     */
    public GameSession startGameService(List<String> playerNames) {
        
        GameSession game = new GameSession();
        List<Player> players  = Collections.emptyList();
        for (String name : playerNames){
                Player p = new Player();
                p.setName(name);
                players.add(p);
                }
        
        game.setPlayers(players);
        game.setStartTime(new Date());
        game.setTotalRounds(0);

                return game;
    }

    /**
     * adds a new bet to the current game.
     * @param session
     * @param bet
     * @return
     */
    public GameSession addBet(GameSession session, Bet bet) {
      List<Bet> bets = session.getBets();
      bets.add(bet);
      session.setBets(bets);
     return session;
    }

    public GameSession startNewRound(GameSession arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *checks the winning position and parity against all player bets
     * @param session
     * @return
     */
    public GameSession processResults(GameSession session) {
        //step 1 check for parity bets
        
        //step 2 check for positiion bets
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
