package com.ad.reporting.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="site_version")
public class SiteVersion {
	
	public SiteVersion(String siteVersionId, String siteName) {
		super();
		this.siteVersionId = siteVersionId;
		this.siteName = siteName;
	}
	
	public SiteVersion(){
		
	}

	@Id
	@Column(name="site_version_id")
	private String siteVersionId;
	
	@Column(name="site_name")
	private String siteName;
	
	public String getSiteVersionId() {
		return siteVersionId;
	}

	public void setSiteVersionId(String siteVersionId) {
		this.siteVersionId = siteVersionId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return siteName;
	}

}
