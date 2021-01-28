/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.iq.services;

import com.wonderlabz.iq.domain.Bet;
import com.wonderlabz.iq.domain.GameSession;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Component
public interface GameService {
    GameSession startGameService(List<String> playerNames);
    GameSession addBet(GameSession session,Bet bet);
    GameSession startNewRound(GameSession session);
    GameSession processResults(GameSession session);

}
