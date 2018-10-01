package io.qdivision.bowlingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BowlingapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BowlingapiApplication.class, args);
	}

	@Bean
	public List<Bowler> bowlers(){


		List<Bowler> initialBowler=new ArrayList<>();
		initialBowler.add(
				new Bowler(1, "Tyler"));
		initialBowler.add(
				new Bowler(2, "Kingsly"));


		return initialBowler;


	}
	@Bean
    public List<Game> games() {
	    List<Game> initialGame = new ArrayList<>();
	    List<String> bowlerName  = new ArrayList<>();
	    return initialGame;
    }


}
