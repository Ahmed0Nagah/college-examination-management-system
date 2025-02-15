package LecturerModule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Exam {
    private ArrayList<String> questions = new ArrayList<>();
    private String duration;
    private ArrayList<String> correctAnswers = new ArrayList<>();
    private String courseName;
    
    public Exam(){
        
    }
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
    public ArrayList<String> getCorrectAnswersfile(String coursename) {
        ArrayList<String> corrects = new ArrayList<>();
        try (Scanner answerReader = new Scanner(new File("src\\correctAnswers.txt"))) {
            while (answerReader.hasNextLine()) {
                String answerLine = answerReader.nextLine();
                String[] answer = answerLine.split(" "); // Split answer into parts

                // Combine parts to form the full answer
                if (answer[0].equals(coursename)) {
                    for (int i = 1; i < answer.length; i++) {
                        corrects.add(answer[i]);

                    }

                }

            }

        } catch (IOException e) {
            System.out.println("sad hahahahhaha");
        }
        return corrects;
    }

    public String getDuration() {
        return duration;
    }

    public ArrayList<String> getQuestions() {
     
        return questions ;
    }
    public ArrayList<String> getQuestionsfile(String coursename) {
        ArrayList<String> questionss = new ArrayList<>();
        try (Scanner questionReader = new Scanner(new File("src\\questions.txt"))) {
            while (questionReader.hasNextLine()) {
                String questionLine = questionReader.nextLine();
                String[] question = questionLine.split(" "); // Split question into parts

                // Combine parts to form the full question
                if (question[0].equals(coursename)) {
                    for (int i = 1; i < question.length; i++) {
                        questionss.add(question[i]);
                    }

                }
            }
        } catch (IOException e) {
            System.out.println("Error reading questions file: " + e.getMessage());
        }
        return questionss;

    }

    

    public String getCourseName() {
        return courseName;
    }
    private String formatExamDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append(courseName).append(" ").append(duration).append(" ");
        
        return sb.toString();
    }
    private String formatQuestions(){
        StringBuilder sb = new StringBuilder();
        sb.append(courseName).append(" ");
        
        for (int i = 0; i < questions.size(); i++) {
            sb.append(questions.get(i)).append(" ");
        }
        return sb.toString();
    }
    private String formatAnswers(){
        StringBuilder sb = new StringBuilder();
        sb.append(courseName).append(" ");
        
        for (int i = 0; i < correctAnswers.size(); i++) {
            sb.append(correctAnswers.get(i)).append(" ");
        }
        return sb.toString();
    }
    
        
        
    public void saveToFile() {
        
        try (PrintWriter write = new PrintWriter(new FileWriter("src\\exams.txt",true))) {
            write.println(formatExamDetails());
        } catch (IOException e) {
            System.err.println("Error saving the exam to file: " + e.getMessage());
        }
        
        try (PrintWriter write = new PrintWriter(new FileWriter("src\\questions.txt",true))) {
            write.println(formatQuestions());
        } catch (IOException e) {
            System.err.println("Error saving the exam to file: " + e.getMessage());
        }
        
        
        try (PrintWriter write = new PrintWriter(new FileWriter("src\\correctAnswers.txt",true))) {
            write.println(formatAnswers());
        } catch (IOException e) {
            System.err.println("Error saving the exam to file: " + e.getMessage());
        }
    }
    public void modifyToFile(){
        try (PrintWriter write = new PrintWriter(new FileWriter("src\\questions.txt"))) {
            write.println(formatQuestions());
        } catch (IOException e) {
            System.err.println("Error saving the exam to file: " + e.getMessage());
        }
        try (PrintWriter write = new PrintWriter(new FileWriter("src\\correctAnswers.txt"))) {
            write.println(formatAnswers());
        } catch (IOException e) {
            System.err.println("Error saving the exam to file: " + e.getMessage());
        }
    }
    public static void modifyExamInFile(String courseName, Exam updatedExam) {
        File file = new File("src\\exams.txt");
        List<String> lines = new ArrayList<>();
        boolean examModified = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // If the line contains the courseName, it is part of the exam we want to modify
                if (line.contains(courseName)) {
                    // We will add the new exam details when we find the course name
                    lines.add(updatedExam.formatExamDetails());
                    examModified = true;
                } else {
                    lines.add(line);
                }
            }

            // If the exam was found and modified, rewrite the entire file
            if (examModified) {
                try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                    for (String updatedLine : lines) {
                        writer.println(updatedLine);
                    }
                    System.out.println("Exam modified successfully.");
                }
            } else {
                System.out.println("Exam not found.");
            }
        } catch (IOException e) {
            System.err.println("Error modifying the exam in the file: " + e.getMessage());
        }
    }
    public void modifyExam(String newDuration, ArrayList<String> newQuestions, ArrayList<String> newCorrectAnswers) {
    this.duration = newDuration;
    this.questions = newQuestions;
    this.correctAnswers = newCorrectAnswers;
    }
    public String gradeExam(ArrayList<String> studentAnswers, String coursename) {
        int score = 0;
        ArrayList<String> correctes = new ArrayList<>();
        correctes = getCorrectAnswersfile(coursename);
        for (int i = 0; i < studentAnswers.size(); i++) {

            // Compare the student's answer with the correct answer
            if (studentAnswers.get(i).equals(correctes.get(i))) {
                // The answer is correct
                score+=5;

            }
        }
        return score + "";
    }
    
    public void modifyquestion(String question, int index){
        questions.set(index, question);
    }
    public void modifyanswer(String answer, int index){
        correctAnswers.set(index, answer);
    }
    @Override
    public String toString() {
        return "Course name : "+this.courseName+" duration: "+getDuration()+" questions: "+getQuestions()+" correct answers: "+getCorrectAnswers();
    }
    
// public static void main(String[] args){
//     Exam exam = new Exam();
//     ArrayList<String> studentAnswers = exam.getStudentAnswersfile("CS");
//     System.out.println(exam.gradeExam(studentAnswers, "CS"));
// }
 
// 
// private ArrayList<String> getStudentAnswersfile(String coursename) {
//        ArrayList<String> corrects = new ArrayList<>();
//        try (Scanner answerReader = new Scanner(new File("src\\studentAnswers.txt"))) {
//            while (answerReader.hasNextLine()) {
//                String answerLine = answerReader.nextLine();
//                String[] answer = answerLine.split(" "); // Split answer into parts
//
//                // Combine parts to form the full answer
//                if (answer[0].equals(coursename)) {
//                    for (int i = 1; i < answer.length; i++) {
//                        corrects.add(answer[i]);
//
//                    }
//
//                }
//
//            }
//
//        } catch (IOException e) {
//            System.out.println("sad hahahahhaha");
//        }
//        return corrects;
//    }
}
