package com.ad.reporting.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ad.reporting.domain.AdMetrics;
import com.ad.reporting.domain.SiteVersion;

public interface AdMetricsDaoRepository extends CrudRepository<AdMetrics, Integer> {

	@Query("SELECT adm FROM AdMetrics adm WHERE substring(adm.month,1,3) = :month and site_version_id=:siteVersion")
	public List<AdMetrics> getAdMetricsByMonthAndSiteVersion(@Param("month") String month,
			@Param("siteVersion") String siteId);

	@Query("SELECT adm FROM AdMetrics adm WHERE substring(adm.month,1,3) = :month")
	public List<AdMetrics> getAdMetricsByMonth(@Param("month") String month);
	
	public List<AdMetrics> getAdMetricsBySiteVersion(Optional<SiteVersion> optional);

}
