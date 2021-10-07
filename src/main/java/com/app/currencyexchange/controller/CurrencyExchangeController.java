package com.app.currencyexchange.controller;

import com.app.currencyexchange.models.CurrencyExchange;
import com.app.currencyexchange.repository.CurrencyExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author t0k02w6 on 25/09/21
 * @project currency-exchange
 */
@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {
    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    private Environment environment;

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        //CurrencyExchange currencyExchange = new CurrencyExchange(10001l, from, to, BigDecimal.valueOf(50));
        logger.info("retrieveExchangeValue called with {}, {}", from, to);
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
        if(currencyExchange == null)
            throw new RuntimeException("Unable to find data for " + from + " to " + to);
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }
}
