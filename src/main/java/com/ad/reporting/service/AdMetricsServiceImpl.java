package com.ad.reporting.service;

import java.time.Month;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ad.reporting.domain.AdMetrics;
import com.ad.reporting.repository.AdMetricsDaoRepository;

@Service("adMetricsService")
@Transactional
public class AdMetricsServiceImpl implements AdMetricsService{



	@Autowired
	AdMetricsDaoRepository adMetricsDaoRepository;

	@Autowired
	SiteVersionService siteVersionService;

	public List<AdMetrics> getAdMetricsByMonthAndSite(String month, String siteVersionId) {
		if (StringUtils.isNumeric(month)) {
			month = Month.of(Integer.parseInt(month)).name();
		}
		return adMetricsDaoRepository.getAdMetricsByMonthAndSiteVersion(month.toUpperCase().substring(0, 3),
				siteVersionId);
	}

	public List<AdMetrics> getAdMetricsByMonth(String month) {
		// TODO Auto-generated method stub
		if (StringUtils.isNumeric(month)) {
			month = Month.of(Integer.parseInt(month)).name();
		}
		return adMetricsDaoRepository.getAdMetricsByMonth(month.toUpperCase().substring(0, 3));
	}

	public List<AdMetrics> getAdMetricsBySite(String site) {
		// TODO Auto-generated method stub
		return adMetricsDaoRepository.getAdMetricsBySiteVersion(siteVersionService.getSiteBySiteId(site));
	}


}
