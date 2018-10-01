package io.qdivision.bowlingapi;


import java.util.ArrayList;
import java.util.List;

public class Frames {


    public Frames() {
        this.frames = bowlerFrames();

    }

    private List<Frame> frames;

    public List<Frame> getFrames() {
         return frames;
    }



    Frame frame = new Frame(1);

    public List<Frame> bowlerFrames() {
        List<Frame> frames = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            frames.add(frame);
        }
        return frames;

    }
}