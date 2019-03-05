package com.morgane.quizit;

import android.graphics.drawable.Drawable;

public class ImageQuestion {

    private Themes theme;
    private String question, answer;
    private Drawable image;
    private String[] wrongs;

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
        this.answer = answer;
        this.wrongs = new String[]{wrong_one, wrong_two, wrong_three};
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
        return answer;
    }

    /**
     * Permits to know if an answer is valid
     * @param answer The answer to test
     * @return True if it's the good answer, false if not
     */
    public boolean isValid(String answer) {
        return answer.equals(this.answer);
    }
}
