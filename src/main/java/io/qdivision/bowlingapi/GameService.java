package io.qdivision.bowlingapi;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {
    private List<Bowler> bowlers;
    private List<Game> games;



    public GameService(List<Bowler> bowlers, List<Game> games) {
        this.bowlers = bowlers;
        this.games = games;
    }

    public List<Bowler> getAllBowlers() {
        return bowlers;
    }

    public Bowler addBowler(String name){


        Bowler newBowler = new Bowler (bowlers.size()+1, name);
        bowlers.add(newBowler);
        return newBowler;
    }

    public Game addGame(List<String> name) {
        Game newGame  = new Game(games.size()+1, name );
        games.add(newGame);
        return newGame;
    }

    public List<Bowler> getBowler(int id) {
        List<Bowler> bowlers = getAllBowlers();
        return bowlers.stream().filter(bowler ->bowler.getId()==id).collect(Collectors.toList());
    }


    public List<Bowler> getBowler(int gameId, int bowlerId) {
        List<Game> game = getGame(gameId);
        List<Bowler> bowlers = game.get(0).getBowlers();       //getAllBowlers();
        return bowlers.stream().filter(bowler ->bowler.getId()==bowlerId).collect(Collectors.toList());
    }

    

    public List<Frame> getAFrame(int bowlerId, int frameId) {
        List<Bowler> bowler = getBowler(bowlerId);
        List<Frame> frames = bowler.get(0).getFrames();
        return frames.stream().filter(frame -> frame.getId() == frameId).collect(Collectors.toList());

    }

    public List<Frame> getAFrame(int gameId, int bowlerId, int frameId) {

        List<Bowler> bowler = getBowler(gameId, bowlerId);
        List<Frame> frames = bowler.get(0).getFrames();
        return frames.stream().filter(frame -> frame.getId() == frameId).collect(Collectors.toList());

    }



    public List<Frame> updateFrameRoll(int gameId, int bowlerId, int frameId, String targetRoll, Integer rollPinsValue) {
        List<Bowler> bowler = getBowler(gameId, bowlerId);
        List<Frame> frame = bowler.get(0).getFrames();
        //List<Frame> result= frame.stream().filter(frames ->frames.getId()==frameId).collect(Collectors.toList());

        List<Frame> currentFrame= frame.stream().filter(frames ->frames.getId()==frameId).collect(Collectors.toList());
        List<Frame> priorFrame = frame.stream().filter(frames ->frames.getId()==frameId-1).collect(Collectors.toList());
        List<Frame> twoFramesAgo = frame.stream().filter(frames ->frames.getId()==frameId-2).collect(Collectors.toList());
        List<Frame> threeFramesAgo =frame.stream().filter(frames ->frames.getId()==frameId-3).collect(Collectors.toList());






        /*if(targetRoll ==  "FIRSTROLL") {
            result.get(0).getFrame().setFirstRoll(rollPinsValue);
            result.get(0).getFrame().setResult(rollPinsValue);
            if (result.get(0).getFrame().getResult() == 10) {
                result.get(0).getFrame().setStrike(true);
            }
        }
        else if (targetRoll == "SECONDROLL") {
            if(result.get(0).getFrame().isStrike() || (rollPinsValue > 10 - result.get(0).getFrame().getFirstRoll())){

            }
            else if (rollPinsValue <= 10 - result.get(0).getFrame().getFirstRoll()){
                result.get(0).getFrame().setSecondRoll(rollPinsValue);
                result.get(0).getFrame().updateResult(result.get(0).getFrame().getFirstRoll() ,result.get(0).getFrame().getSecondRoll() );
                if (result.get(0).getFrame().getResult() == 10) {
                    result.get(0).getFrame().setSpare(true);
                }
            }


        }

        return (result);*/
        if(targetRoll ==  "FIRSTROLL") {
            currentFrame.get(0).getFrame().setFirstRoll(rollPinsValue);
            currentFrame.get(0).getFrame().setResult(currentFrame.get(0).getFrame().getFirstRoll());
            if (currentFrame.get(0).getFrame().getResult()!=10&&currentFrame.get(0).getId()>1){currentFrame.get(0).getFrame().setTotalScore(priorFrame.get(0).getFrame().getTotalScore()+currentFrame.get(0).getFrame().getResult());}
            if (currentFrame.get(0).getFrame().getResult()!=10&&currentFrame.get(0).getId()==1){currentFrame.get(0).getFrame().setTotalScore(currentFrame.get(0).getFrame().getResult());}
            if (currentFrame.get(0).getFrame().getResult()==10){
                currentFrame.get(0).getFrame().setStrike(true);
                currentFrame.get(0).getFrame().setStrikePartOneFulfilled(false);
                currentFrame.get(0).getFrame().setStrikePartTwoFulfilled(false);

            }

            if(currentFrame.get(0).getId()>1){

                if(!priorFrame.get(0).getFrame().isStrikePartOneFulfilled()){
                    priorFrame.get(0).getFrame().setResult(currentFrame.get(0).getFrame().getResult()+priorFrame.get(0).getFrame().getResult());
                    priorFrame.get(0).getFrame().setStrikePartOneFulfilled(true);}{
                    if(currentFrame.get(0).getId()>2){if(!twoFramesAgo.get(0).getFrame().isStrikePartTwoFulfilled()){
                        twoFramesAgo.get(0).getFrame().setResult(currentFrame.get(0).getFrame().getResult()+twoFramesAgo.get(0).getFrame().getResult());
                        if(twoFramesAgo.get(0).getId()==1){twoFramesAgo.get(0).getFrame().setTotalScore(twoFramesAgo.get(0).getFrame().getResult());}
                        if(twoFramesAgo.get(0).getId()!=1){ twoFramesAgo.get(0).getFrame().setTotalScore(twoFramesAgo.get(0).getFrame().getResult()+threeFramesAgo.get(0).getFrame().getTotalScore());}
                        twoFramesAgo.get(0).getFrame().setStrikePartTwoFulfilled(true);

                    }}

                }
                if(!priorFrame.get(0).getFrame().isSpareFulfilled()){
                    priorFrame.get(0).getFrame().setResult(currentFrame.get(0).getFrame().getResult()+priorFrame.get(0).getFrame().getResult());
                    if(priorFrame.get(0).getId()==1){priorFrame.get(0).getFrame().setTotalScore(priorFrame.get(0).getFrame().getResult());}
                    if(priorFrame.get(0).getId()!=1){priorFrame.get(0).getFrame().setTotalScore(priorFrame.get(0).getFrame().getResult()+twoFramesAgo.get(0).getFrame().getTotalScore());}
                    priorFrame.get(0).getFrame().setSpareFulfilled(true);
                }

            }}
        else if (targetRoll == "SECONDROLL") {
            if (currentFrame.get(0).getFrame().isStrike()){}else {
                currentFrame.get(0).getFrame().setSecondRoll(rollPinsValue);
                currentFrame.get(0).getFrame().setResult(currentFrame.get(0).getFrame().getFirstRoll() + currentFrame.get(0).getFrame().getSecondRoll());
                if (currentFrame.get(0).getFrame().getResult()!=10&&currentFrame.get(0).getId()>1){currentFrame.get(0).getFrame().setTotalScore(priorFrame.get(0).getFrame().getTotalScore()+currentFrame.get(0).getFrame().getResult());}
                if (currentFrame.get(0).getFrame().getResult()!=10&&currentFrame.get(0).getId()==1){currentFrame.get(0).getFrame().setTotalScore(currentFrame.get(0).getFrame().getResult());}
                if (currentFrame.get(0).getFrame().getResult() == 10) {
                    currentFrame.get(0).getFrame().setSpare(true);
                    currentFrame.get(0).getFrame().setSpareFulfilled(false);
                }
                if(currentFrame.get(0).getId()<1){
                    if(!priorFrame.get(0).getFrame().isStrikePartTwoFulfilled()){
                        priorFrame.get(0).getFrame().setResult(currentFrame.get(0).getFrame().getResult()+priorFrame.get(0).getFrame().getResult());
                        priorFrame.get(0).getFrame().setTotalScore(priorFrame.get(0).getFrame().getResult()+twoFramesAgo.get(0).getFrame().getTotalScore());
                        priorFrame.get(0).getFrame().setStrikePartTwoFulfilled(true);

                    }
                }


            }

        }
        else if(targetRoll=="FIRSTEXTRAROLL"){
            if ((currentFrame.get(0).getId()!=10)&&((currentFrame.get(0).getFrame().isStrike())||(currentFrame.get(0).getFrame().isSpare()))){}
            else{
                currentFrame.get(0).getFrame().setFirstExtraRoll(rollPinsValue);
                currentFrame.get(0).getFrame().setResult(currentFrame.get(0).getFrame().getFirstRoll() + currentFrame.get(0).getFrame().getSecondRoll()+currentFrame.get(0).getFrame().getFirstExtraRoll());
                currentFrame.get(0).getFrame().setTotalScore(currentFrame.get(0).getFrame().getResult()+priorFrame.get(0).getFrame().getTotalScore());
                if(!priorFrame.get(0).getFrame().isStrikePartTwoFulfilled()){
                    priorFrame.get(0).getFrame().setResult(priorFrame.get(0).getFrame().getResult()+currentFrame.get(0).getFrame().getFirstExtraRoll());
                    priorFrame.get(0).getFrame().setTotalScore(priorFrame.get(0).getFrame().getResult()+twoFramesAgo.get(0).getFrame().getTotalScore());
                }
            }
        }


        else if(targetRoll=="SECONDEXTRAROLL"){
            if((currentFrame.get(0).getId()!=10)&&((currentFrame.get(0).getFrame().isStrike()))){}
            else{
                currentFrame.get(0).getFrame().setSecondExtraRoll(rollPinsValue);
                currentFrame.get(0).getFrame().setResult(currentFrame.get(0).getFrame().getFirstRoll() + currentFrame.get(0).getFrame().getSecondRoll()+currentFrame.get(0).getFrame().getFirstExtraRoll()+currentFrame.get(0).getFrame().getSecondExtraRoll());
                priorFrame.get(0).getFrame().setTotalScore(priorFrame.get(0).getFrame().getResult()+twoFramesAgo.get(0).getFrame().getTotalScore());
                currentFrame.get(0).getFrame().setTotalScore(currentFrame.get(0).getFrame().getResult()+priorFrame.get(0).getFrame().getTotalScore());
            }}


        return (currentFrame);



    }










    public List<Frame> updateFrameRoll(int gameId, int bowlerId, int frameId,Integer firstRoll, Integer secondRoll) {
        List<Bowler> bowler = getBowler(gameId, bowlerId);
        List<Frame> frame = bowler.get(0).getFrames();
        List<Frame> result= frame.stream().filter(frames ->frames.getId()==frameId).collect(Collectors.toList());
        result.get(0).getFrame().setFirstRoll(firstRoll);
        result.get(0).getFrame().setSecondRoll(secondRoll);

        return (result);
    }


    public List<Game> getAllGames() {
        return games;
    }

    public List<Game> getGame(int id) {
        List<Game> games = getAllGames();
        return games.stream().filter(bowler ->bowler.getGameId()==id).collect(Collectors.toList());}


}
