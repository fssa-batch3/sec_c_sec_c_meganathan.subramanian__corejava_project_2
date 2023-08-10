package com.fssa.book.enums;

public enum BookCategories {

    ARTS_AND_BIOGRAPHY_BOOK("Arts and biography"),
    FICTION_BOOKS("fiction books"),
    LAW_BOOKS("Law books"),
    MEDICINE("Medicine"),
    SELFHELP_BOOKS("Self help books"),
    LIFESTYLE_BOOKS("LifeStyle Books"),
    SCIENCE_AND_MATHS("Science and maths books");

    private final String mainCategories;

    // This code for setting the value
    BookCategories(String categories) {
        this.mainCategories = categories;
    }

    // This code for get the value
    public String getValue() {
        return mainCategories;
    }

}
