package com.wonderlabz.iq.roulette;

import com.wonderlabz.iq.domain.GameSession;
import com.wonderlabz.iq.ui.GameControllerUI;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Configuration
@ComponentScan({"com.wonderlabz.iq.ui","com.wonderlabz.iq.services"})
public class RouletteApplication {

    
    @Autowired 
    GameControllerUI uiService;
    
	public static void main(String[] args) {
            
                        SpringApplication.run(RouletteApplication.class, args);
                            

	}

}
