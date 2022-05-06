package coms309.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import io.restassured.response.Response;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@RunWith(SpringRunner.class)
public class SystemTest {

    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://coms-309-024.class.las.iastate.edu:8080";
    }

    //200 response code just makes sure it works.
    @Test
    public void testGetAdmin(){
        Response response = RestAssured.given().
                header("Content-Type", "text/plain").
                header("charset","utf-8").
//                body("hello").
                when().
                get("http://coms-309-024.class.las.iastate.edu:8080/admin/all");
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }

    @Test
    public void testGetDoctor(){
        Response response = RestAssured.given().
                header("Content-Type", "text/plain").
                header("charset","utf-8").
//                body("hello").
        when().
                get("http://coms-309-024.class.las.iastate.edu:8080/doctor/all");
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }

    @Test
    public void testGetPatient(){
        Response response = RestAssured.given().
                header("Content-Type", "text/plain").
                header("charset","utf-8").
//                body("hello").
        when().
                get("http://coms-309-024.class.las.iastate.edu:8080/patient/all");
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }

    @Test
    public void reverseTest() {
        // Send request and receive response
        Response response = RestAssured.given().
                header("Content-Type", "text/plain").
                header("charset","utf-8").
//                body("hello").
                when().
                get("http://coms-309-024.class.las.iastate.edu:8080/reverse");


        // Check status code
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);

        // Check response body for correct response
        String returnString = response.getBody().asString();
        try {
            JSONArray returnArr = new JSONArray(returnString);
            JSONObject returnObj = returnArr.getJSONObject(returnArr.length()-1);
            assertEquals("olleh", returnObj.get("data"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void capitalizeTest() {
        // Send request and receive response
        Response response = RestAssured.given().
                header("Content-Type", "text/plain").
                header("charset","utf-8").
                body("hello").
                when().
                post("/capitalize");


        // Check status code
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);

        // Check response body for correct response
        String returnString = response.getBody().asString();
        try {
            JSONArray returnArr = new JSONArray(returnString);
            JSONObject returnObj = returnArr.getJSONObject(returnArr.length()-1);
            assertEquals("HELLO", returnObj.get("data"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    
    @Test
    public void whenRequestGetAdmin_thenOK() {
    	RestAssured.when().request("GET", "admin/all").then().statusCode(200);
    }
    
    @Test
    public void whenRequestGetDoctor_thenOK()
    {
    	RestAssured.when().request("GET", "doctor/all").then().statusCode(200);
    }
    
    @Test
    public void whenRequestGetPatient_thenOK() {
    	RestAssured.when().request("GET", "patient/all").then().statusCode(200);
    }
    
    @Test
    public void whenRequestGetVisit_thenOK()
    {
    	RestAssured.when().request("GET", "visit/all").then().statusCode(200);
    }
}

