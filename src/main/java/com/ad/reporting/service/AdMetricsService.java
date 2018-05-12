package com.ad.reporting.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ad.reporting.domain.AdMetrics;
import com.ad.reporting.repository.AdMetricsDaoRepository;

@Service
@Transactional
public class AdMetricsService {

	@Autowired
	AdMetricsDaoRepository adMetricsDaoRepository;
	
	@Autowired
	SiteVersionService siteVersionService;
	
	public List<AdMetrics> getAdMetricsByMonthAndSite(int month,String siteVersionId){
		return adMetricsDaoRepository.getAdMetricsByMonthAndSiteVersion(month, siteVersionService.getSiteBySiteId(siteVersionId));
	}
	
	
	
}
