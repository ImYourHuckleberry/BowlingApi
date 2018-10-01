package io.qdivision.bowlingapi;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Integer gameId;
    //private String bowlerName;
    private List<Bowler> bowlers;

    public List<Bowler> getBowlers() {
        return bowlers;
    }

    public void setBowlers(List<Bowler> bowlers) {
        this.bowlers = bowlers;
    }

    public Game(Integer gameId, List<String> bowlerName) {
        this.gameId = gameId;
        this.bowlers = addGameBowler(bowlerName);
    }


    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }



    public List<Bowler> addGameBowler(List<String> name){
       List<Bowler> newBowlers = new ArrayList<>();
       for(int i = 0; i < name.size(); i++) {
            Bowler newBowler = new Bowler (newBowlers.size()+1, name.get(i));
            newBowlers.add(newBowler);
        }
       return newBowlers;
    }

}
