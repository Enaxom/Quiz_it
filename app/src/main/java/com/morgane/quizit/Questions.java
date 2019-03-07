package com.morgane.quizit;

import android.graphics.drawable.Drawable;
import android.os.Parcelable;

/**
 * Abstract class Questions to have a merge of the 3 types of question
 */
public abstract class Questions implements Parcelable {

    /**
     * The constructor get the constructor of the other 3 class MultipleQuestion, TrueFalse and ImageQuestion
     */
    public Questions() {
        super();
    }

    /**
     * Get the theme of the question
     * @return Themes : TECH, CULTURE, ANIMALS or SCIENCE
     */
    public abstract Themes getTheme();

    /**
     * Gives the question
     * @return String the question
     */
    public abstract String getQuestion();

    /**
     * Gives the right answer
     * @return The String right answer
     */
    public abstract String getAnswer();

    /**
     * Check the validity of the answer
     * @param answer The answer proposed by the user
     * @return True if it's the good answer, false if not
     */
    public abstract boolean isValid(String answer);

    /**
     * Get the answers of the question
     * @return String[] with the questions, null if the question is a True / False question
     */
    public abstract String[] getAnswers();

    /**
     * Get the image associated to the question
     * @return Drawable if ImageQuestion, null if not
     */
    public abstract Drawable getImage();

    /**
     * Gives the type of the question
     * @return 1 -> MultipleQuestion
     *         2 -> TrueFalse question
     *         3 -> ImageQuestion
     */
    public abstract int getType();
}
