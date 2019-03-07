package com.morgane.quizit;

import android.graphics.drawable.Drawable;
import android.os.Parcel;

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

    protected TrueFalse(Parcel in) {
        theme = Themes.valueOf(in.readString());
        question = in.readString();
        answer = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }

    public static final Creator<TrueFalse> CREATOR = new Creator<TrueFalse>() {
        @Override
        public TrueFalse createFromParcel(Parcel in) {
            return new TrueFalse(in);
        }

        @Override
        public TrueFalse[] newArray(int size) {
            return new TrueFalse[size];
        }
    };
}
