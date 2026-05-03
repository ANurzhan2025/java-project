package model;

import java.io.Serializable;

public class Mark implements Serializable {
    private double att1;
    private double att2;
    private double finalExam;

    public Mark() { this.att1 = 0; this.att2 = 0; this.finalExam = 0; }

    @Override
    public String toString() {
        return "Att1: " + att1 + ", Att2: " + att2 + ", Final: " + finalExam;
    }
}