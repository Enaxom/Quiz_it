package com.morgane.quizit;

/**
 * Class for true / false questions.
 */
public class TrueFalse {

    private Themes theme;
    private String question;
    private boolean answer;

    /**
     * Constructor of a true / false question
     * @param theme The theme of the question
     * @param question The question in String
     * @param answer The answer (true or false)
     */
    public TrueFalse(Themes theme, String question, boolean answer) {
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
     * @return The true or false answer
     */
    public boolean getAnswer() {
        return answer;
    }

    /**
     * Permits to know if an answer is right
     * @param answer The true or false answer
     * @return True if it's the good answer, false if not
     */
    public boolean isValid(boolean answer) {
        return this.answer == answer;
    }
}
