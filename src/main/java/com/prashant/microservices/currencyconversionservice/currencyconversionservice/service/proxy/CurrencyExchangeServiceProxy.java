package com.prashant.microservices.currencyconversionservice.currencyconversionservice.service.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.prashant.microservices.currencyconversionservice.currencyconversionservice.pojo.CurrencyConversionBean;

//@FeignClient(name="currency-exchange-service")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	/**
	* from map to USD
	* and to map to INR
	*/
	//@GetMapping("/currency-exchange/from/{from}/to/{to}") // where {from} and {to} are path variable
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}") // where {from} and {to} are path variable
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
