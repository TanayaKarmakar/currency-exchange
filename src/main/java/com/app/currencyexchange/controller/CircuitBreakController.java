package com.app.currencyexchange.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author t0k02w6 on 04/10/21
 * @project currency-exchange
 */
@RestController
public class CircuitBreakController {
    private Logger logger = LoggerFactory.getLogger(CircuitBreakController.class);

    @GetMapping("/sample-api")
    //@CircuitBreaker(name = "sample-api", fallbackMethod = "hardcodedResponse")
    @RateLimiter(name = "default")
    public String sampleApi() {
        logger.info("Sample API call received");
//        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:9091/some-dummy-url", String.class);
//        return forEntity.getBody();
        return "sample-api";
    }

    private String hardcodedResponse(Exception ex) {
        return "fallback response";
    }
}
