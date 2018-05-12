package com.ad.reporting.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

@Entity
@Table(name = "ad_metrics")
public class AdMetrics {

	public AdMetrics() {

	}

	@Id
	@GeneratedValue
	private int adMetricsId;

	@Column(name = "month")
	private int month;

	@ManyToOne
	@JoinColumn(name = "site_version_id")
	private SiteVersion siteVersion;

	@Column(name = "requests")
	private int requests;

	@Column(name = "impressions")
	private int impressions;

	@Column(name = "clicks")
	private int clicks;

	@Column(name = "conversions")
	private int conversions;

	@Column(name = "revenue")
	private double revenue;

	@Column(name = "ctr")
	private int ctr;

	@Column(name = "cr")
	private int cr;

	@Column(name = "fill_rate")
	private int fillRate;

	@Column(name = "e_cpm")
	private int eCPM;

	public int getAdMetricsId() {
		return adMetricsId;
	}

	public void setAdMetricsId(int adMetricsId) {
		this.adMetricsId = adMetricsId;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getRequests() {
		return requests;
	}

	public void setRequests(int requests) {
		this.requests = requests;
	}

	public int getImpressions() {
		return impressions;
	}

	public void setImpressions(int impressions) {
		this.impressions = impressions;
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	public int getConversions() {
		return conversions;
	}

	public void setConversions(int conversions) {
		this.conversions = conversions;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
	}

	public int getCr() {
		return cr;
	}

	public void setCr(int cr) {
		this.cr = cr;
	}

	public int getFillRate() {
		return fillRate;
	}

	public void setFillRate(int fillRate) {
		this.fillRate = fillRate;
	}

	public int geteCPM() {
		return eCPM;
	}

	public void seteCPM(int eCPM) {
		this.eCPM = eCPM;
	}

	public SiteVersion getSiteVersion() {
		return siteVersion;
	}

	public void setSiteVersion(SiteVersion siteVersion) {
		this.siteVersion = siteVersion;
	}
	
	

}
