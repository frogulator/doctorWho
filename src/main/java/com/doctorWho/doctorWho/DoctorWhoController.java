package com.doctorWho.doctorWho;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DoctorWhoController {

    @RequestMapping("/doctor/{incarnationNumber}")
    @ResponseBody
    public ResponseEntity<String> getDoctorDetails(@PathVariable int incarnationNumber) {
        if (incarnationNumber >= 9 && incarnationNumber <= 13) {
            // Return the details about the incarnation of the corresponding Doctor in JSON format
            switch (incarnationNumber) {
                case 9:
                    return ResponseEntity.ok("{\"number\": 9, \"name\": \"Christopher Eccleston\"}");
                case 10:
                    return ResponseEntity.ok("{\"number\": 10, \"name\": \"David Tennant\"}");
                case 11:
                    return ResponseEntity.ok("{\"number\": 11, \"name\": \"Matt Smith\"}");
                case 12:
                    return ResponseEntity.ok("{\"number\": 12, \"name\": \"Peter Capaldi\"}");
                case 13:
                    return ResponseEntity.ok("{\"number\": 13, \"name\": \"Jodie Whittaker\"}");
            }
        } else if (incarnationNumber >= 1 && incarnationNumber <= 8) {
            // Return a 303 status for Doctors 1 to 8
            return new ResponseEntity<>(HttpStatus.SEE_OTHER);
        }
        // For any other number, return a 404 status with the appropriate message
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible to retrieve the incarnation " + incarnationNumber);
    }
}





