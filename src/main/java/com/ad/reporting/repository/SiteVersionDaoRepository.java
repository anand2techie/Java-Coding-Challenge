package com.ad.reporting.repository;

import org.springframework.data.repository.CrudRepository;

import com.ad.reporting.domain.SiteVersion;

public interface SiteVersionDaoRepository extends CrudRepository<SiteVersion, String>{
	
	SiteVersion getSiteVersionBySiteName(String siteName);

}
