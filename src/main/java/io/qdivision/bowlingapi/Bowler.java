package io.qdivision.bowlingapi;

import java.util.ArrayList;
import java.util.List;

public class Bowler {
    public Bowler() {

    }
    public Bowler (Integer id, String name){
        this.id=id;
        this.name=name;
        this.frames= bowlerFrames();


    }
    private Integer id;
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private List<Frame> frames;

    public List<Frame> getFrames() {
        return frames;
    }



    public List<Frame> bowlerFrames() {
        List<Frame> frames = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Frame frame = new Frame(i + 1);
            frames.add(frame);
        }
        return frames;

    }
}