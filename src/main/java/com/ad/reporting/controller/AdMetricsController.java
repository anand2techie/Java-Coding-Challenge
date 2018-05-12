package com.ad.reporting.controller;

import java.time.Month;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ad.reporting.domain.AdMetrics;
import com.ad.reporting.service.AdMetricsService;

@RestController
public class AdMetricsController {

	@Autowired
	AdMetricsService adMetricsService;

	@GetMapping(path = "/reports", params = { "month", "site" })
	List<AdMetrics> getAdMetricsByMonthAndSite(String month, String site) {
		return adMetricsService.getAdMetricsByMonthAndSite(month, site);
	}

	// aggregate reports
	@GetMapping(path = "/reports", params = { "month" })
	List<AdMetrics> getAdMetricsByMonth(String month) {
		return adMetricsService.getAdMetricsByMonth(month);
	}

	// aggregate reports
	@GetMapping(path = "/reports", params = { "site" })
	List<AdMetrics> getAdMetricsBySite(String site) {
		return adMetricsService.getAdMetricsBySite(site);
	}

	/*
	 * @GetMapping(path="/reports") List<AdMetrics>
	 * getAdMetrics(@RequestParam("month") String month,@RequestParam("site")String
	 * site){ return adMetricsService.getAdMetricsByMonthAndSite(month, site); }
	 * 
	 * @GetMapping(path="/reports") List<AdMetrics>
	 * getAdMetrics(@RequestParam("month") int month,@RequestParam("site")String
	 * site){ return adMetricsService.getAdMetricsByMonthAndSite(month, site); }
	 */
}
