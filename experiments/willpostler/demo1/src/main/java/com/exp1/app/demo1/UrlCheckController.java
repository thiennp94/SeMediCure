package com.exp1.app.demo1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * This was a demo I completed from Java Brains to check if site was either up or down. 
 * I could not get it fully working. It only read that the sites were down. I think this is 
 * I wasn't reading the urlResponseCode correctly but I am not sure how to test for that. 
 * 
 * The demo video link is: https://www.youtube.com/watch?v=uq4GjRF_860
 * 
 */
@RestController
public class UrlCheckerController {
    private final String SITE_IS_UP = "Site is up!";
    private final String SITE_IS_DOWN = "Site is down!";
    private final String INCORRECT_URL = "URL is incorrect!";


    @GetMapping("/check")
    public String getURLstatusMsg(@RequestParam String url){
        String returnMessage = "";
        try {
            URL urlObj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCodeCategory = conn.getResponseCode() / 100;
            if (responseCodeCategory!= 2 || responseCodeCategory != 3) {
                returnMessage = SITE_IS_DOWN;
            } else {
                returnMessage = SITE_IS_UP;
            }
        } catch (MalformedURLException e) {
            returnMessage = INCORRECT_URL;
        } catch (IOException e) {
            returnMessage = SITE_IS_DOWN;
        }

        return returnMessage;
    }

}

