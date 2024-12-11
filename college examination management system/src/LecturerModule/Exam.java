package LecturerModule;

import java.util.ArrayList;

public class Exam {
    private ArrayList<String> questions;
    private String duration;
    private ArrayList<String> correctAnswers;

    public Exam() {
        
        this.questions = questions;
        this.duration = duration;
        this.correctAnswers = correctAnswers;
    }

    public void setCorrectAnswers(ArrayList<String> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setQuestions(ArrayList<String> questions) {
        this.questions = questions;
    }

    public ArrayList<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public String getDuration() {
        return duration;
    }

    public ArrayList<String> getQuestions() {
     
        return questions ;
    }
    
    
}
