package com.ad.reporting.service;

import java.time.Month;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ad.reporting.domain.AdMetrics;
import com.ad.reporting.repository.AdMetricsDaoRepository;

public interface AdMetricsService {

	public List<AdMetrics> getAdMetricsByMonthAndSite(String month, String siteVersionId);
	public List<AdMetrics> getAdMetricsByMonth(String month);
	public List<AdMetrics> getAdMetricsBySite(String site);
}
