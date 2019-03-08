package com.morgane.quizit;

import android.graphics.drawable.Drawable;

/**
 * Class for true / false questions.
 */
public class TrueFalse extends Questions {

    private Themes theme;
    private String question, answer;

    /**
     * Constructor of a true / false question
     * @param theme The theme of the question
     * @param question The question in String
     * @param answer The answer ("True" or "False")
     */
    public TrueFalse(Themes theme, String question, String answer) {
        this.theme = theme;
        this.question = question;
        this.answer = answer;
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
     * Function to get the right answer
     * @return The "True" or "False" answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Permits to know if an answer is right
     * @param answer The "True" or "False" answer
     * @return True if it's the good answer, false if not
     */
    public boolean isValid(String answer) {
        return this.answer.equals(answer);
    }

    /**
     * Methods to get all the answers
     * @return null, there is only one answer for this type of question
     */
    public String[] getAnswers() {
        return null;
    }

    /**
     * Gives the image associated to the question
     * @return null, there isn't an image for this type of question
     */
    public Drawable getImage() {
        return null;
    }

    /**
     * Gives the type of the question
     * @return type (2), the type of the question
     */
    public int getType() {
        return 2;
    }

    public String toString() {
        String res = "";
        res += "Theme : " + theme.toString() + "\n";
        res += "Question : " + question + "\n";
        res += "Good answer : " + getAnswer() + "\n";
        return res;
    }
}
