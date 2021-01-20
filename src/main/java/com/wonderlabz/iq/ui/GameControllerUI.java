
package com.wonderlabz.iq.ui;

import com.wonderlabz.iq.domain.Bet;
import com.wonderlabz.iq.domain.GameSession;
import com.wonderlabz.iq.domain.Player;
import java.util.Scanner;

/**
 *
 * @author Nkosinathi Mathela
 */
public class GameControllerUI {
    
    
    // for each player in game session read player bets in the format
    // amount bettype 
    GameSession collectPlayerBets(GameSession session){
        
        for (Player p:session.getPlayers()) {
                 System.out.println("Enter Amount and Bet Type for "+p.getName()+":");
            //The input provided by user is stored in num
                Scanner input = new Scanner(System.in);
           String i=     input.next();
           String[] ix = i.split(" ");
           Bet b = new Bet();
        String  amountX =  ix[0];
        String betTypeX = ix[1];
        String betValueX = ix[1];
        Double amount=0.00;
        Integer position =-1;
        try   {
           amount =  Double.parseDouble(amountX);
                }catch(NumberFormatException ex){
           System.out.println("The Bet Amount Must be numeric for player "+p.getName()+"!");
        }
            if (betTypeX.equalsIgnoreCase("POSITION")) {
                    try   {
           position =  Integer.parseInt(betValueX);
           
                }catch(NumberFormatException ex){
           System.out.println("The Slot  must be numeric for player "+p.getName()+"!");
        }
                    if (position >36) {
                          System.out.println("The Slot  must be numeric for player "+p.getName()+"!");
                }
                    
            }
        

        }


    }
    
}
