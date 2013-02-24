package org.ahp.commons.validator;

public class ValidatorConstants {

    public static final int EMAIL_ADDRESS_MAX_LENGTH = 100;
    public static final int EMAIL_ADDRESS_MIN_LENGTH = 7;
    public static final String EMAIL_ADDRESS_ALLOWED_REGEX = "^[A-Za-z0-9_\\.\\-]+@[A-Za-z0-9_\\.\\-]+\\.[A-Za-z]{2,4}$";
    public static final String ALPHA_NUMERIC_ALLOWED_REGEX = "[A-Za-z0-9]*";
    public static final String ALPHA_ALLOWED_REGEX = "[A-Za-z]*";
    public static final String NUMERIC_ALLOWED_REGEX = "[0-9]*";
    
}
