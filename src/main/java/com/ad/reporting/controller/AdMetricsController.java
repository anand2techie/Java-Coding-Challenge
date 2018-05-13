package com.ad.reporting.controller;

import java.time.Month;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ad.reporting.domain.AdMetrics;
import com.ad.reporting.exception.AdMetricsException;
import com.ad.reporting.service.AdMetricsService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class AdMetricsController {

	@Autowired
	AdMetricsService adMetricsService;

	/*
	 * Method to return  AdMetrics report based on both month and site
	 */
	@GetMapping(path = "/reports", params = { "month", "site" })
	ResponseEntity<List<AdMetrics>> getAdMetricsByMonthAndSite(String month, String site) throws AdMetricsException {
		List<AdMetrics> adMetrics=adMetricsService.getAdMetricsByMonthAndSite(month, site);
		if (adMetrics==null || adMetrics.isEmpty()){
            throw new AdMetricsException("Ad Metrics doesn't exist for the month: "+month+" and site: "+site);
    	}
		return new ResponseEntity<List<AdMetrics>>(adMetrics, HttpStatus.OK);
	}

	/*
	 * Method to return aggregate AdMetrics report based on month
	 */
	@GetMapping(path = "/reports", params = { "month" })
	ResponseEntity<List<AdMetrics>> getAdMetricsByMonth(String month) throws AdMetricsException {
		List<AdMetrics> adMetrics=adMetricsService.getAdMetricsByMonth(month);
		if (adMetrics==null || adMetrics.isEmpty()){
            throw new AdMetricsException("Ad Metrics doesn't exist for the month: "+month);
    	}
		return new ResponseEntity<List<AdMetrics>>(adMetrics, HttpStatus.OK);
	}

	/*
	 * Method to return aggregate AdMetrics report based on site
	 */
	@GetMapping(path = "/reports", params = { "site" })
	ResponseEntity<List<AdMetrics>> getAdMetricsBySite(String site) throws AdMetricsException {
		List<AdMetrics> adMetrics=adMetricsService.getAdMetricsBySite(site);
		if (adMetrics==null || adMetrics.isEmpty()){
            throw new AdMetricsException("Ad Metrics doesn't exist for the site: "+site);
    	}
		return new ResponseEntity<List<AdMetrics>>(adMetrics, HttpStatus.OK);
	}
}
