package com.wonderlabz.iq.services;

import com.wonderlabz.iq.domain.Bet;
import com.wonderlabz.iq.domain.BetType;
import com.wonderlabz.iq.domain.GameSession;
import com.wonderlabz.iq.domain.Player;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
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

    public GameSession startNewRound(GameSession session) {
        session.setWinningParity(-1);
        session.setWinningPosition(-1);
     return session;
    }

    /**
     *checks the winning position and parity against all player bets
     * @param session
     * @return
     */
    public GameSession processResults(GameSession session) {
        //lets get a random number between 0 and 36 inclusive. and then update the sessions winning position.
        int winningPosition = new Random().nextInt(36);
        session.setWinningPosition(winningPosition);
        
        //lets determine the parity of the selected number,(ie is it even or odd). and update the sessions winning parity
        if(winningPosition%2==0){
            session.setWinningParity(1);
        }else{
               session.setWinningParity(0);
           }
      
        List<Bet> winningParityBets = Collections.emptyList();
        List<Bet> winningPositionBets = Collections.emptyList();
        //step 1 check for parity bets
        if (session.getBets()== null) {
            //no bets were placed for current game.
            return session;
        }
        for(Bet b:session.getBets()){
            if (b.getType()==BetType.Parity){
                if (session.getWinningParity() == b.getSelectedParity()) {
                    b.setIsWin(true);
                    winningParityBets.add(b);
                }
            }
        }
        //step 2 check for positiion bets
        for(Bet b:session.getBets()){
            if (b.getType()==BetType.Position){
                if (session.getWinningPosition()== b.getSelectedPosition()) {
                        b.setIsWin(true);
                    winningPositionBets.add(b);
                }
            }
        }
        
            session.setWinningParityBets(winningParityBets);
            session.setWinningPositionBets(winningPositionBets);
            session.setEndTime(new Date());

    return session;

    }
    
}
