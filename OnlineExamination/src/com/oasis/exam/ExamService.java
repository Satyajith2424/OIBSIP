package com.oasis.exam;

import java.util.ArrayList;

public class ExamService {

    private User user;
    private ArrayList<Question> questions;

    public ExamService() {

        user = new User("USER001", "1234");

        questions = new ArrayList<>();

        questions.add(
                new Question(
                        "Which language is used for Android Development?",
                        new String[] {
                                "Python",
                                "Java",
                                "C",
                                "HTML"
                        },
                        2));

        questions.add(
                new Question(
                        "Which keyword is used to create an object?",
                        new String[] {
                                "new",
                                "class",
                                "void",
                                "this"
                        },
                        1));

        questions.add(
                new Question(
                        "Java is a ______ language.",
                        new String[] {
                                "Procedural",
                                "Machine",
                                "Object Oriented",
                                "Assembly"
                        },
                        3));
    }
	    public boolean login(String userId,
	            String password) {
	
		return user.getUserId().equals(userId)
		   && user.getPassword().equals(password);
		}
	    public void updatePassword(String newPassword) {
	        user.setPassword(newPassword);
	        System.out.println("Password updated successfully!");
	    }
	    public ArrayList<Question> getQuestions() {
	        return questions;
	    }
	    public int startExam(java.util.Scanner sc) {

	        int score = 0;

	        TimerService timer = new TimerService();
	        timer.startTimer(30);

	        System.out.println("\nYou have 30 seconds to complete the exam.");
	        System.out.println("The exam will auto-submit when the time is over.");

	        for (Question q : questions) {

	            if (timer.isTimeUp()) {
	                System.out.println("\nTime is up!");
	                System.out.println("Exam Submitted Automatically!");
	                break;
	            }

	            System.out.println("\n" + q.getQuestion());

	            String[] options = q.getOptions();

	            for (int i = 0; i < options.length; i++) {
	                System.out.println((i + 1) + ". " + options[i]);
	            }

	            System.out.print("Enter answer: ");
	            int answer = sc.nextInt();

	            if (answer == q.getCorrectAnswer()) {
	                score++;
	            }
	        }

	        return score;
	    }
}