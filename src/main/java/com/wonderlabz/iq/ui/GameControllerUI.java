
package com.wonderlabz.iq.ui;

import com.wonderlabz.iq.domain.Bet;
import com.wonderlabz.iq.domain.GameSession;
import com.wonderlabz.iq.domain.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nkosinathi Mathela
 */
public class GameControllerUI {
    
    
    // for each player in game session read player bets in the format
    // amount bettype 
    GameSession collectPlayerBets(GameSession session){
        List<Bet> bets= new ArrayList<Bet>();
       bets  =  session.getBets();
        for (Player p:session.getPlayers()) {
                 System.out.println("Enter Amount and Bet Type for "+p.getName()+":");
            //The input provided by user is stored in num
                Scanner input = new Scanner(System.in);
           String i=     input.next();
           String[] ix = i.split(" ");
           Bet bet = new Bet();
        String  amountX =  ix[0];
        String betTypeX = ix[1];
        String betValueX = ix[2];
        Double amount=0.00;
        Integer position =-1;
        Boolean dontAddCurrentBet=false;
        try   {
           amount =  Double.parseDouble(amountX);
                }catch(NumberFormatException ex){
           System.out.println("The Bet Amount Must be numeric for player "+p.getName()+"!");
               dontAddCurrentBet = true;
        }
            if (betTypeX.equalsIgnoreCase("POSITION")) {
                    try   {
                    position =  Integer.parseInt(betValueX);

                    }catch(NumberFormatException ex){
                    System.out.println("The Slot  must be numeric for player "+p.getName()+"!");
                        dontAddCurrentBet = true;
                    }
                    if (position >36 || position < 0) {
                          System.out.println("The Slot  must be between 0 and 36 for player "+p.getName()+"! This bet wont be added to current game");
                          dontAddCurrentBet = true;
                    }
            }
        
               if (betTypeX.equalsIgnoreCase("PARITY")) {
                    try   {
                    position =  Integer.parseInt(betValueX);

                    }catch(NumberFormatException ex){
                    System.out.println("The Parity  must be numeric for player "+p.getName()+"! This bet wont be added to current game");
                        dontAddCurrentBet = true;
                    }
                    if (position >1 || position < 0) {
                          System.out.println("The Parity must be either 0 (for even numbers) or 1 (for odd numbers) for player "+p.getName()+"! This bet wont be added to current game");
                              dontAddCurrentBet = true;
                    }
               }
                    bet.setAmount(amount);
                    bet.setIsWin(false);
                    bet.setPlayer(p);
                    bet.setSelectedParity(position);
                    bet.setSelectedPosition(position);
                    
                    if (!dontAddCurrentBet) {
                       bets.add(bet);
                      }
                 
               
        }   
        
        session.setBets(bets);
return session;

    }
    
}
