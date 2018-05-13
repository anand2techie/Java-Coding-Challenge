package com.ad.reporting.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ad.reporting.annotations.Precision;
import com.ad.reporting.util.DoubleContextualSerializer;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "ad_metrics")
public class AdMetrics {

	public AdMetrics() {

	}

	public AdMetrics(String month, SiteVersion siteVersion, double requests, double impressions, double clicks,
			double conversions, double revenue) {
		super();
		this.month = month;
		this.siteVersion = siteVersion;
		this.requests = requests;
		this.impressions = impressions;
		this.clicks = clicks;
		this.conversions = conversions;
		this.revenue = revenue;
	}

	@Id
	@GeneratedValue
	private int adMetricsId;

	@Column(name = "month")
	private String month;

	@ManyToOne
	@JoinColumn(name = "site_version_id")
	private SiteVersion siteVersion;

	@JsonSerialize(using = DoubleContextualSerializer.class)
	@Precision(precision = 2)
	@Column(name = "requests")
	private double requests;

	@JsonSerialize(using = DoubleContextualSerializer.class)
	@Precision(precision = 2)
	@Column(name = "impressions")
	private double impressions;

	@JsonSerialize(using = DoubleContextualSerializer.class)
	@Precision(precision = 2)
	@Column(name = "clicks")
	private double clicks;

	@JsonSerialize(using = DoubleContextualSerializer.class)
	@Precision(precision = 2)
	@Column(name = "conversions")
	private double conversions;

	@JsonSerialize(using = DoubleContextualSerializer.class)
	@Precision(precision = 2)
	@Column(name = "revenue")
	private double revenue;

	@JsonSerialize(using = DoubleContextualSerializer.class)
	@Precision(precision = 2)
	@Column(name = "ctr")
	private double ctr;

	@JsonSerialize(using = DoubleContextualSerializer.class)
	@Precision(precision = 2)
	@Column(name = "cr")
	private double cr;

	@JsonSerialize(using = DoubleContextualSerializer.class)
	@Precision(precision = 2)
	@Column(name = "fill_rate")
	private double fillRate;

	@JsonSerialize(using = DoubleContextualSerializer.class)
	@Precision(precision = 2)
	@Column(name = "e_cpm")
	private double eCPM;
	
	public double getImpressions() {
		return impressions;
	}

	public void setImpressions(double impressions) {
		this.impressions = impressions;
	}

	public double getClicks() {
		return clicks;
	}

	public void setClicks(double clicks) {
		this.clicks = clicks;
	}

	public double getCtr() {
		return ctr;
	}

	public void setCtr(double ctr) {
		this.ctr = ctr;
	}

	public double getCr() {
		return cr;
	}

	public void setCr(double cr) {
		this.cr = cr;
	}

	public double getFillRate() {
		return fillRate;
	}

	public void setFillRate(double fillRate) {
		this.fillRate = fillRate;
	}

	public double geteCPM() {
		return eCPM;
	}

	public void seteCPM(double eCPM) {
		this.eCPM = eCPM;
	}

	public int getAdMetricsId() {
		return adMetricsId;
	}

	public void setAdMetricsId(int adMetricsId) {
		this.adMetricsId = adMetricsId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	public SiteVersion getSiteVersion() {
		return siteVersion;
	}

	public void setSiteVersion(SiteVersion siteVersion) {
		this.siteVersion = siteVersion;
	}

	public double getRequests() {
		return requests;
	}

	public void setRequests(double requests) {
		this.requests = requests;
	}

	public double getConversions() {
		return conversions;
	}

	public void setConversions(double conversions) {
		this.conversions = conversions;
	}
	
	

}
