
package com.wonderlabz.iq.ui;

import com.wonderlabz.iq.domain.Bet;
import com.wonderlabz.iq.domain.GameSession;
import com.wonderlabz.iq.domain.Player;
import com.wonderlabz.iq.services.GameService;
import com.wonderlabz.iq.utils.ReadFileUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nkosinathi Mathela
 */
@Service
public class GameControllerUI {
     
      
    //lets allow the game Session to be abean and inject it .
    // that way it can be accessed by multiple threads within the JVM
    @Bean
    GameSession getCurrentGame() throws IOException{
        if (session == null) {
            session = new GameSession();
         List<String> names =   ReadFileUtil.readPlayerNames("c:\\wonderlabz\\players.txt");
//         service.startGameService(names);
         
        }
    return session;
    }

    @Autowired
    GameService service;
    
    @Autowired
      GameSession session;
    
    // for each player in game session read player bets in the format
    // amount type value
    GameSession collectPlayerBets(GameSession session){
        List<Bet> bets= new ArrayList<Bet>();
       bets  =  session.getBets();
        if (session.getPlayers() == null) {
            //no players loaded , exit this round and wait for player file to be loaded
            return session;
        }
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
        this.session = session;
return session;

    }
    
    
    // fixedDelay: make the game spin and process results every 30 seconds.
    // this can happen even as new bets are being added.collectPlayerBets prompts for new bets.
    
    //initialDelay : lets wait at least 60 seconds before the first wheel spins.
    @Scheduled(fixedDelay= (30  * 1000), initialDelay = (60 *1000))
    GameSession play(){
       
        //start a new thread and collect user input while the wheel is spinnin for the players who have already set their bets.
        
            Thread t1 = new Thread(new Runnable() {
            public void run()
            {
                  
            }});  
            t1.start();
          collectPlayerBets(session);   
            service.processResults(this.session);
            printWinningResults(this.session);
    return session;
    }
    
    void printWinningResults(GameSession session){
        if (session.getWinningParityBets()==null && session.getWinningPositionBets()==null) {
             System.out.println("No Winners in this Round"); 
             return;
        }
         System.out.println("Player"+"       "+"Type"+"        "+"Amount" +"         "+"Winnings");
          System.out.println("------------------------------------------------------------------------------------------");
          if (session.getWinningParityBets()!=null ) {
                for(Bet bet:session.getWinningParityBets()){
             System.out.println(bet.getPlayer().getName()+"       "+bet.getType().toString()+"        "+bet.getAmount().toString() +"         "+bet.getReward().toString());
    }
        }
        if (session.getWinningPositionBets()!=null) {
             for(Bet bet:session.getWinningPositionBets()){
             System.out.println(bet.getPlayer().getName()+"       "+bet.getType().toString()+"        "+bet.getAmount().toString() +"         "+bet.getReward().toString());
    }
        }
    
      
    }

    public void start() {
       collectPlayerBets(this.session);
    }
  
}
