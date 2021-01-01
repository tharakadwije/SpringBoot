package com.tharakadwije.rest.restfulwebservices.user;


import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class Road {

    @GetMapping(value = "/healthcheck", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> healthcheck(@RequestParam("format") String format) {
        Date currentTime = new Date();
        if(null != format && "short".equals(format)){
            return new ResponseEntity<>(new Response("OK"), HttpStatus.OK);
        }else if(null != format && "full".equals(format)){
            return new ResponseEntity<>((new FullResponse(currentTime, "OK")), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }



    class Response{
        private String status;

        Response(){

        }
        Response(String status){
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setApplication(String status) {
            this.status = status;
        }

    }
    class FullResponse{
        private String currentTime;
        private String application;
        FullResponse(Date currentTime, String application){
            DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            this.currentTime = df1.format(currentTime);
            this.application = application;
        }
        public String getCurrentTime() {
            return currentTime;
        }

        public void setCurrentTime(String currentTime) {
            this.currentTime = currentTime;
        }

        public String getApplication() {
            return application;
        }

        public void setApplication(String application) {
            this.application = application;
        }
    }





//        Assert.assertEquals(Inverter.invert(null), "");
//        Assert.assertEquals(Inverter.invert(""), "");
//        Assert.assertEquals(Inverter.invert("S"), "S");
//        Assert.assertEquals(Inverter.invert("string"), "gnirts");
//        Assert.assertEquals(Inverter.invert(" string"), "gnirts ");
//        Assert.assertEquals(Inverter.invert("  string  "), "  gnirts  ");
}
