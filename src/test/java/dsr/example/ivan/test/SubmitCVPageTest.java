package dsr.example.ivan.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import dsr.example.ivan.data.Const;
import dsr.example.ivan.data.DataHelper;
import dsr.example.ivan.page.SubmitAnApplicationPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class SubmitCVPageTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setUpSutUrl() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        Configuration.browserCapabilities = options;

        open(System.getProperty("sut.url"));
    }

    @AfterEach
    void driverQuit() {
        closeWebDriver();
    }


    @Test
    void allPageElementsShouldPresent() {
        SubmitAnApplicationPage submPage = new SubmitAnApplicationPage();
        submPage.validatePageElements();
    }

    @Test
    void allInputsShouldBeMandatory() {
        SubmitAnApplicationPage submPage = new SubmitAnApplicationPage();
        submPage
                .clickSubmitButton()
                .validateErrNotifications();
    }

    @Test
    void sendCvWithValidDataTest() {
        SubmitAnApplicationPage submPage = new SubmitAnApplicationPage();

        String[] testData = {
                DataHelper.generateFirstNameLat(),
                DataHelper.generateLastNameLat(),
                DataHelper.generateEmail(),
                DataHelper.generateValidPhoneNumber().toString(),
                "Male",
                Const.getVACANCY_TEXT()[1]
        };

        submPage
                .fillFirstName(testData[0])
                .fillLastName(testData[1])
                .fillEmail(testData[2])
                .fillPhone(testData[3])
                .selectGenderRadio(testData[4])
                .selectVacancyByValue(testData[5])
                .setCvPath(Const.getDOCX_FILE_PATH())
                .enableAgreementCheckbox()
                .clickSubmitButton()
                .validateAlertText(testData)
                .acceptAlert();
    }

    // ToDo: 1. add 'Field validation' tests
    // ToDo: 2. add 'rest-assured' tests (added to build.gradle)
}
