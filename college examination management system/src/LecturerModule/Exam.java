package LecturerModule;

import java.util.*;

public class Exam {
    private ArrayList<String> questions;
    private String duration;
    private ArrayList<String> correctAnswers;

    public Exam(String duration,ArrayList<String> questions, ArrayList<String> correctAnswers ) {
           this.duration=duration ;
         this.correctAnswers.addAll(correctAnswers);
           this.questions.addAll(questions);
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

    @Override
    public String toString() {
        
return "duration: "+getDuration()+"question"+getQuestions()+"correct"+getCorrectAnswers();
    }
    
 
}
