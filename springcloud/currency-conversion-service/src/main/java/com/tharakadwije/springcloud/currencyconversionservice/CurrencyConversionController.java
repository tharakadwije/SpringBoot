package com.tharakadwije.springcloud.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
        HashMap<String, String> uriVariable = new HashMap();
        uriVariable.put("from",from);
        uriVariable.put("to",to);

        ResponseEntity<CurrencyConversion> forEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariable);

        CurrencyConversion body = forEntity.getBody();

        return new CurrencyConversion(body.getId(), from, to, quantity, body.getConversionMultiple(), quantity.multiply(body.getConversionMultiple()), body.getEnvironment());
    }

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){

        CurrencyConversion body = currencyExchangeProxy.retrieveExchangeValue(from, to);
        return new CurrencyConversion(body.getId(), from, to, quantity, body.getConversionMultiple(), quantity.multiply(body.getConversionMultiple()), body.getEnvironment() + " Feign");
    }

}
