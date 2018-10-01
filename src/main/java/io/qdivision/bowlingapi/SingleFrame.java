package io.qdivision.bowlingapi;

public class SingleFrame {


    public SingleFrame(){
        this.firstRoll=0;
        this.secondRoll=0;
        this.firstExtraRoll =0;
        this.secondExtraRoll =0;
        this.result=0;
        this.totalScore=0;
        this.isSpare = false;
        this.isStrike=false;
        //this.bonusScore=0;
        this.isSpareFulfilled =true;
        this.isStrikePartOneFulfilled =true;
        this.isStrikePartTwoFulfilled =true;


    }
    private Integer firstRoll;
    private Integer secondRoll;
    private Integer firstExtraRoll;
    private Integer secondExtraRoll;
    //private Integer totalScore;
    private Integer result;
    private Integer totalScore;


    private boolean isSpare;
    private boolean isStrike;

    private boolean isStrikePartOneFulfilled;
    private boolean isStrikePartTwoFulfilled;
    private boolean isSpareFulfilled;

    public Integer getFirstExtraRoll() {
        return firstExtraRoll;
    }

    public void setFirstExtraRoll(Integer firstExtraRoll) {
        this.firstExtraRoll = firstExtraRoll;
    }

    public Integer getSecondExtraRoll() {
        return secondExtraRoll;
    }

    public void setSecondExtraRoll(Integer secondExtraRoll) {
        this.secondExtraRoll = secondExtraRoll;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public boolean isStrikePartOneFulfilled() {
        return isStrikePartOneFulfilled;
    }

    public void setStrikePartOneFulfilled(boolean strikePartOneFulfilled) {
        isStrikePartOneFulfilled = strikePartOneFulfilled;
    }

    public boolean isStrikePartTwoFulfilled() {
        return isStrikePartTwoFulfilled;
    }

    public void setStrikePartTwoFulfilled(boolean strikePartTwoFulfilled) {
        isStrikePartTwoFulfilled = strikePartTwoFulfilled;
    }

    public boolean isSpareFulfilled() {
        return isSpareFulfilled;
    }

    public void setSpareFulfilled(boolean spareFulfilled) {
        isSpareFulfilled = spareFulfilled;
    }


    public boolean isSpare() {
        return isSpare;
    }

    public void setSpare(boolean spare) {
        isSpare = spare;
    }

    public boolean isStrike() {
        return isStrike;
    }

    public void setStrike(boolean strike) {
        isStrike = strike;
    }

    public Integer getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(Integer firstRoll) {
        this.firstRoll = firstRoll;
    }

    public Integer getSecondRoll() {
        return secondRoll;
    }

    public void setSecondRoll(Integer secondRoll) {
        this.secondRoll = secondRoll;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public void updateResult(Integer firstRoll, Integer secondRoll) {
        this.result = firstRoll + secondRoll;
    }
}
