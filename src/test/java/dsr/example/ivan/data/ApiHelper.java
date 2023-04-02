package dsr.example.ivan.data;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiHelper {

    private static final String endpoint = "/web-ui-playground";

    private static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("https://vladimirwork.github.io")
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static String sendCV(String fName,
                                String lName,
                                String email,
                                String phoneNumber,
                                String gender,
                                String vacancy,
                                String cv,
                                boolean Agreement) {
        Map<String, Object> map = new HashMap<>();
        map.put("FirstName", fName);
        map.put("LastName", lName);
        map.put("Email", email);
        map.put("PhoneNumber", phoneNumber);
        map.put("Gender", gender);
        map.put("Vacancy", vacancy);
        map.put("CV", cv);
        map.put("Agreement", Agreement);

        return given()
                .spec(requestSpec)
                .body(map)
                .when()
                .post(endpoint)
                .then()
                .statusCode(405)
                .extract()
                .response()
                .asString();
    }
}
