package com.ad.reporting.controller;

import java.util.List;

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

	@GetMapping(path="/reports")
	List<AdMetrics> getAdMetrics(@RequestParam("month") int month,@RequestParam("site")String site){
		return adMetricsService.getAdMetricsByMonthAndSite(month, site);
	}
}
