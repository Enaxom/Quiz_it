package com.morgane.quizit;

/**
 * Enum class for the different question themes
 */
public enum Themes {
    ALL("ALL"),
    TECH("TECH"),
    CULTURE("CULTURE"),
    ANIMALS("ANIMALS"),
    SCIENCE("SCIENCE");

    private final String text;

    Themes(final String text) {
        this.text = text;
    }

    public static Themes fromString(String value) {
        for (Themes theme : values()) {
            if (theme.text.equals(value)) {
                return theme;
            }
        }
        return null;
    }
}
