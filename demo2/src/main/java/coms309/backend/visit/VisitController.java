package coms309.backend.visit;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisitController {
    @Autowired
    VisitRepository visitRepository;

    //created a new JSON object to put the user JSON data in during the login process.
   JSONObject output = new JSONObject();

    @GetMapping("visit/all")
    List<Visit> GetAllVisit(){
        return visitRepository.findAll();
    }

    //this post method uses the body of the site via a JSON to post to the database
    @PostMapping("visit/post")
    Visit PostVisitByBody(@RequestBody Visit newVisit){
        visitRepository.save(newVisit);
        return newVisit;
    }
}