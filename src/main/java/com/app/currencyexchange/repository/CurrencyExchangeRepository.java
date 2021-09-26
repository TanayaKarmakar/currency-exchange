package com.app.currencyexchange.repository;

import com.app.currencyexchange.models.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author t0k02w6 on 26/09/21
 * @project currency-exchange
 */
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    CurrencyExchange findByFromAndTo(String from, String to);
}
