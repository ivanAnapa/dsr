package dsr.example.ivan.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import dsr.example.ivan.data.Const;
import org.junit.jupiter.api.Assertions;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SubmitAnApplicationPage {

    // First Name
    private final SelenideElement fNameLabelText = $x("//label[1]");
    private final SelenideElement fNameInput = $x("//input[@name='FirstName']");

    // Last Name
    private final SelenideElement lNameLabelText = $x("//label[2]");
    private final SelenideElement lNameInput = $x("//input[@name='LastName']");

    // Email
    private final SelenideElement emailLabelText = $x("//label[3]");
    private final SelenideElement emailInput = $x("//input[@name='Email']");

    // Phone Number
    private final SelenideElement phoneNumberLabelText = $x("//label[4]");
    private final SelenideElement phoneNumberInput = $x("//input[@name='PhoneNumber']");

    // Gender
    private final SelenideElement genderLabelText = $x("//label[5]");
    private final SelenideElement genderMaleLabelText = $x("//div[./input[@value='Male']]");
    private final SelenideElement genderFemaleLabelText = $x("//div[./input[@value='Female']]");
    private final SelenideElement genderMaleRadio = $x("//input[@value='Male']");
    private final SelenideElement genderFemaleRadio = $x("//input[@value='Female']");

    // Vacancy
    private final SelenideElement vacancyLabelText = $x("//label[6]");
    private final SelenideElement vacancyDropdown = $x("//select[@name='Vacancy']");
    private final SelenideElement vacancyOptionQA = $x("//option[@value='QA Engineer']");
    private final SelenideElement vacancyOptionQAA = $x("//option[@value='QAA Engineer']");
    private final SelenideElement vacancyOptionBA = $x("//option[@value='Business Analyst']");

    // Upload
    private final SelenideElement cvUploadLabelText = $x("//label[@for='myfile']");
    private final SelenideElement cvUploadInput = $x("//input[@id='myfile']");

    // Agreement
    private final SelenideElement agreementCheckboxLabelText = $x("//label[8]");
    private final SelenideElement agreementCheckbox = $x("//input[@name='Agreement']");

    // Submit btn
    private final SelenideElement submitButton = $x("//input[@name='submitbutton']");

    // Error
    private final ElementsCollection errorNotification = $$x("//p");


    public void validatePageElements() {
        String[] expected = Const.getLABEL_TEXT();

        // 'First name' visibility
        fNameLabelText.shouldBe(text(expected[0]), visible);
        fNameInput.shouldBe(visible);
        // 'Last name' visibility
        lNameLabelText.shouldBe(text(expected[1]), visible);
        lNameInput.shouldBe(visible);
        // 'Email' visibility
        emailLabelText.shouldBe(text(expected[2]), visible);
        emailInput.shouldBe(visible);
        // 'Phone number' visibility
        phoneNumberLabelText.shouldBe(text(expected[3]), visible);
        phoneNumberInput.shouldBe(visible);
        // 'Gender' visibility
        genderLabelText.shouldBe(text(expected[4]), visible);
        genderMaleLabelText.shouldBe(text(expected[5]), visible);
        genderFemaleLabelText.shouldBe(text(expected[6]), visible);
        genderMaleRadio.shouldBe(visible);
        genderFemaleRadio.shouldBe(visible);
        // 'Vacancy' visibility and options existing
        vacancyLabelText.shouldBe(text(expected[7]), visible);
        vacancyDropdown.shouldBe(visible);
        vacancyOptionQA.should(exist);
        vacancyOptionQAA.should(exist);
        vacancyOptionBA.should(exist);
        // 'CV upload' visibility
        cvUploadLabelText.shouldBe(text(expected[8]), visible);
        cvUploadInput.shouldBe(visible);
        // 'Agreement Checkbox' visibility
        agreementCheckboxLabelText.shouldBe(text(expected[9]), visible);
        agreementCheckbox.shouldBe(visible);
        // 'Submit Button' visibility
        submitButton.shouldHave(value(expected[10])).shouldBe(visible);
    }

    public void validateErrNotifications() {
        String[] expected = Const.getMISSED_MANDATORY_FIELD_ERROR_TEXT();
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i], errorNotification.get(i).getText());
        }
    }

    public SubmitAnApplicationPage fillFirstName(String firstName) {
        fNameInput.setValue(firstName);
        return this;
    }

    public SubmitAnApplicationPage fillLastName(String lastName) {
        lNameInput.setValue(lastName);
        return this;
    }

    public SubmitAnApplicationPage fillEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public SubmitAnApplicationPage fillPhone(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);
        return this;
    }

    public SubmitAnApplicationPage selectGenderRadio(String gender) {
        // available: Male or Female
        switch (gender) {
            case "Male":
                genderMaleRadio.click();
                break;
            case "Female":
                genderFemaleRadio.click();
                break;
        }
        return this;
    }

    public SubmitAnApplicationPage selectVacancyByValue(String vacancy) {
        vacancyDropdown.selectOptionByValue(vacancy);
        return this;
    }

    public SubmitAnApplicationPage setCvPath(String filePath) {
        cvUploadInput.uploadFile(new File(filePath));
        return this;
    }

    public SubmitAnApplicationPage enableAgreementCheckbox() {
        agreementCheckbox.setSelected(true);
        return this;
    }

    public SubmitAnApplicationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public SubmitAnApplicationPage validateAlertText(String[] testData) {
        String actual = Selenide.switchTo().alert().getText();
        String expected =
                "{\"FirstName\":\"" + testData[0] + "\",\"LastName\":\"" + testData[1] + "\",\"Email\":\"" + testData[2]
                        + "\",\"PhoneNumber\":\"" + testData[3] + "\",\"Gender\":\"" + testData[4]
                        + "\",\"Vacancy\":\"" + testData[5] + "\",\"CV\":{},\"Agreement\":true}";
        Assertions.assertEquals(expected, actual);
        return this;
    }

    public SubmitAnApplicationPage acceptAlert() {
        Selenide.switchTo().alert().accept();
        return this;
    }
}
