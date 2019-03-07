package com.morgane.quizit;

import android.graphics.drawable.Drawable;
import android.os.Parcel;

import java.util.Collections;
import static java.util.Arrays.asList;

/**
 * Class for the questions with multiple choices.
 */
public class MultipleQuestion extends Questions {

    private Themes theme;
    private String question;
    private String[] answers;
    private int idGood;

    /**
     * Constructor of a multiple question, the answers are shuffled here
     * @param theme The theme of the question (tech, culture, animals, science)
     * @param question The question
     * @param answer The write answer
     * @param wrong_one A wrong answer
     * @param wrong_two A wrong answer
     * @param wrong_three A wrong answer
     */
    public MultipleQuestion(Themes theme, String question, String answer, String wrong_one, String wrong_two, String wrong_three) {
        this.theme = theme;
        this.question = question;
        this.answers = new String[]{answer, wrong_one, wrong_two, wrong_three};

        // The different answers are shuffle directly here and the position of the good answer is saved
        Collections.shuffle(asList(answers));
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].equals(answer)) {
                idGood = i;
            }
        }
    }

    protected MultipleQuestion(Parcel in) {
        theme = Themes.valueOf(in.readString());
        question = in.readString();
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
     * Gives the image associated to the question
     * @return null, there isn't an image for this type of question
     */
    public Drawable getImage() {
        return null;
    }

    /**
     * Gives the type of the question
     * @return type (1), the type of the question
     */
    public int getType() {
        return 1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }

    public static final Creator<MultipleQuestion> CREATOR = new Creator<MultipleQuestion>() {
        @Override
        public MultipleQuestion createFromParcel(Parcel in) {
            return new MultipleQuestion(in);
        }

        @Override
        public MultipleQuestion[] newArray(int size) {
            return new MultipleQuestion[size];
        }
    };
}
