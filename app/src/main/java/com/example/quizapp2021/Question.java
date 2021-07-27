package com.example.quizapp2021;

public class Question {

    //1st Fields, Instance Variables,

    private String questionText;
    private boolean correctAnswer;

    //2nd Constructors

    public Question(String questionText, boolean correctAnswer) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    //3rd Constructors

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    //4th User defined methods

    @Override
    public String toString() {
        return "Question{" +
                "questionText='" + questionText + '\'' +
                ", correctAnswer=" + correctAnswer +
                '}';
    }
}
