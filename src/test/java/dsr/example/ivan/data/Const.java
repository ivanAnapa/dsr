package dsr.example.ivan.data;

public class Const {

    private static final String[] LABEL_TEXT = {
            "First name",
            "Last name",
            "Email",
            "Phone number",
            "Gender",
            "M",
            "F",
            "Vacancy",
            "Your CV:",
            "I agree to the processing of personal data",
            "submit"
    };

    public static String[] getLABEL_TEXT() {
        return LABEL_TEXT;
    }


    private static final String[] MISSED_MANDATORY_FIELD_ERROR_TEXT = {
            "Valid first name is required.",
            "Valid last name is required.",
            "Valid email is required.",
            "Valid phone number is required.",
            "Choose your gender.",
            "Attach your CV file.",
            "You must agree to the processing of personal data."
    };

    public static String[] getMISSED_MANDATORY_FIELD_ERROR_TEXT() {
        return MISSED_MANDATORY_FIELD_ERROR_TEXT;
    }

    private static final String[] VACANCY_TEXT = {
            "QA Engineer",
            "QAA Engineer",
            "Business Analyst"
    };

    public static String[] getVACANCY_TEXT() {
        return VACANCY_TEXT;
    }


    private static final String DOCX_FILE_PATH = "src/test/resources/testCV.docx";
    private static final String JPG_FILE_PATH = "src/test/resources/picForUpl.jpg";

    public static String getDOCX_FILE_PATH() {
        return DOCX_FILE_PATH;
    }

    public static String getJPG_FILE_PATH() {
        return JPG_FILE_PATH;
    }

    private static final String[] GENDER = {"Male", "Female"};

    public static String[] getGENDER() {
        return GENDER;
    }

}
