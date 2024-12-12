package LecturerModule;

import java.util.*;

public class Exam {
    private ArrayList<String> questions = new ArrayList<>();
    private String duration;
    private ArrayList<String> correctAnswers = new ArrayList<>();
    private String courseName;

    public Exam(String duration,ArrayList<String> questions, ArrayList<String> correctAnswers,
                String courseName) {
        
        this.correctAnswers.addAll(correctAnswers);
        this.questions.addAll(questions);
        this.duration = duration;
        this.courseName = courseName;
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
        
return "Course name : "+this.courseName+"duration: "+getDuration()+" questions: "+getQuestions()+" correct answers: "+getCorrectAnswers();
    }
    
 
}
