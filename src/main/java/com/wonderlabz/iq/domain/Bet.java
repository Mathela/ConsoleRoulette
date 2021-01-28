
package com.wonderlabz.iq.domain;

import java.math.BigDecimal;

/**
 *
 * @author Nkosinathi Mathela
 * 
 */
public class Bet {
  private  Player player;
  private BetType type;
  private int selectedPosition;
  private int selectedParity;
  private Double amount;
  private Double reward;
  private boolean isWin;
  
  
  public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public BetType getType() {
        return type;
    }

    public void setType(BetType type) {
        this.type = type;
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }

    public int getSelectedParity() {
        return selectedParity;
    }

    public void setSelectedParity(int selectedParity) {
        this.selectedParity = selectedParity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getReward() {
        if (isWin) {
            if (this.type==BetType.Parity) {
                return this.amount * 2.00;
            }else{
              return this.amount * 36.00;
            }
            
        } else{
        return 0.00;
        }
    }

    public void setReward(Double reward) {
        this.reward = reward;
    }

    public boolean isIsWin() {
        return isWin;
    }

    public void setIsWin(boolean isWin) {
        this.isWin = isWin;
    }
  
  
}
