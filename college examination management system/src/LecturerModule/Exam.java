package LecturerModule;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        saveToFile();
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

    public String getCourseName() {
        return courseName;
    }
    private String formatExamDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append(courseName).append(" ").append(duration).append(" ");
        for (int i = 0; i < questions.size(); i++) {
            sb.append(i + 1).append(". ").append(questions.get(i)).append(" ");
        }
        
        for (int i = 0; i < correctAnswers.size(); i++) {
            sb.append(i + 1).append(". ").append(correctAnswers.get(i)).append(" ");
        }
        return sb.toString();
    }
    private void saveToFile() {
        try (PrintWriter write = new PrintWriter(new FileWriter("src\\exams.txt",true))) {
            write.println(formatExamDetails());
        } catch (IOException e) {
            System.err.println("Error saving the exam to file: " + e.getMessage());
        }
    }
    

    @Override
    public String toString() {
        return "Course name : "+this.courseName+" duration: "+getDuration()+" questions: "+getQuestions()+" correct answers: "+getCorrectAnswers();
    }
    
 
}
