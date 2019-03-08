package com.morgane.quizit;

import android.graphics.drawable.Drawable;

import java.util.Collections;
import static java.util.Arrays.asList;

public class ImageQuestion extends Questions {

    private Themes theme;
    private String question;
    private Drawable image;
    private String[] answers;
    private int idGood;

    /**
     * Constructor of a multiple question
     * @param theme The theme of the question (tech, culture, animals, history)
     * @param question The question
     * @param image The image for the question
     * @param answer The write answer
     * @param wrong_one A wrong answer
     * @param wrong_two A wrong answer
     * @param wrong_three A wrong answer
     */
    public ImageQuestion(Themes theme, String question, Drawable image, String answer, String wrong_one, String wrong_two, String wrong_three) {
        this.theme = theme;
        this.question = question;
        this.image = image;
        this.answers = new String[]{answer, wrong_one, wrong_two, wrong_three};

        // The different answers are shuffle directly here and the position of the good answer is saved
        Collections.shuffle(asList(answers));
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].equals(answer)) {
                idGood = i;
            }
        }
    }

    /**
     * Function to get the theme of the question
     * @return The theme of the question
     */
    public Themes getTheme() {
        return theme;
    }

    /**
     * Function to get the question
     * @return The String question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Function to get the image of the question
     * @return The Drawable image used for the question
     */
    public Drawable getImage() {
        return image;
    }

    /**
     * Function to get the right answer
     * @return The String answer
     */
    public String getAnswer() {
        return answers[idGood];
    }

    /**
     * Permits to know if an answer is valid
     * @param answer The answer to test
     * @return True if it's the good answer, false if not
     */
    public boolean isValid(String answer) {
        return answer.equals(answers[idGood]);
    }

    /**
     * Gives the 4 answers available for the question
     * @return String[] the array of answers
     */
    public String[] getAnswers() {
        return answers;
    }

    /**
     * Gives the type of the question
     * @return type (3), the type of the question
     */
    public int getType() {
        return 3;
    }

    public String toString() {
        String res = "";
        res += "Theme : " + theme.toString() + "\n";
        res += "Question : " + question + "\n";
        res += "Answers : " + answers[0] + " ; " + answers[1] + " ; " + answers[2] + " ; " + answers[3] + "\n";
        res += "Good answer : " + answers[idGood] + "\n";
        res += "Image name : " + image.toString() + "\n";
        return res;
    }
}
