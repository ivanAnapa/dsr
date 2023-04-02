package dsr.example.ivan.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import dsr.example.ivan.data.Const;
import dsr.example.ivan.data.DataHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static dsr.example.ivan.data.ApiHelper.sendCV;

public class ApiTest {
    /**
     * API examples
     */

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    public void sendCVRequestWithAPI() {
        String response = sendCV(
                DataHelper.generateFirstNameLat(),
                DataHelper.generateLastNameLat(),
                DataHelper.generateEmail(),
                DataHelper.generateValidPhoneNumber().toString(),
                Const.getGENDER()[0],
                Const.getVACANCY_TEXT()[1],
                "",
                true);
        System.out.println("Response: " + response);
    }
}
