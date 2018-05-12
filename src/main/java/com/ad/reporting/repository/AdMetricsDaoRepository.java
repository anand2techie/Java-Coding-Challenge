package com.ad.reporting.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ad.reporting.domain.AdMetrics;
import com.ad.reporting.domain.SiteVersion;

public interface AdMetricsDaoRepository extends CrudRepository<AdMetrics, Integer>{
	
	public List<AdMetrics> getAdMetricsByMonthAndSiteVersion(int month, Optional<SiteVersion> siteBySiteId);

}
