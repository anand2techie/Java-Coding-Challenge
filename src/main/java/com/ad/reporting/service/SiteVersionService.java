package com.ad.reporting.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ad.reporting.domain.SiteVersion;
import com.ad.reporting.repository.SiteVersionDaoRepository;

@Service
@Transactional
public class SiteVersionService {
	
	@Autowired
	SiteVersionDaoRepository siteVersionDaoRepository;
	
	public Optional<SiteVersion> getSiteBySiteId(String siteVersionId){
		return siteVersionDaoRepository.findById(siteVersionId);
	}

}
