package io.qdivision.bowlingapi;

public class Frame {
    private Integer id;
    //private SingleFrame frame;
    private SingleFrame frame = new SingleFrame();

    public Frame (Integer id) {
        this.id = id;
        this.frame = frame;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        id = id;
    }

    public SingleFrame getFrame() {
        return frame;
    }

    public void setFrame(SingleFrame frame) {
        this.frame = frame;
    }
}
