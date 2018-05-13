package com.ad.reporting.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ad.reporting.constants.AdReportingConstants;
import com.ad.reporting.domain.AdMetrics;
import com.ad.reporting.domain.SiteVersion;
import com.ad.reporting.repository.SiteVersionDaoRepository;
import com.opencsv.CSVReader;

@Service
public class CSVParserUtil {

	Map<String, Integer> columnHeaderMap = new HashMap<String, Integer>();

	@Autowired
	SiteVersionDaoRepository siteVersionDaoRepository;

	CSVReader csvReader;

	File file;

	public void setReader(CSVReader reader, File file) {
		this.csvReader = reader;
		this.file = file;
	}

	List<AdMetrics> parseCSVFiles() throws IOException {
		setHeaderColumnMapping(csvReader.readNext());
		List<AdMetrics> adMetrics = new ArrayList<AdMetrics>();
		String[] record = null;
		while ((record = csvReader.readNext()) != null) {
			AdMetrics adMetric = new AdMetrics();
			adMetric.setClicks(trimAndParse(record[columnHeaderMap.get(AdReportingConstants.CLICKS)]));
			adMetric.setConversions(trimAndParse(record[columnHeaderMap.get(AdReportingConstants.CONVERSIONS)]));
			adMetric.setImpressions(trimAndParse(record[columnHeaderMap.get(AdReportingConstants.IMPRESSSIONS)]));
			adMetric.setRequests(trimAndParse(record[columnHeaderMap.get(AdReportingConstants.REQUESTS)]));
			adMetric.setRevenue(trimAndParseDouble(record[columnHeaderMap.get(AdReportingConstants.REVENUE)]));
			// revenue - D, site - D, additional metrics & month - D
			adMetric.setSiteVersion(getSite(adMetric, record[columnHeaderMap.get(AdReportingConstants.SITE)]));
			setMonthfromFileName(adMetric, file.getName());
			setAdditionalMetrics(adMetric);
			adMetrics.add(adMetric);
		}
		return adMetrics;
	}

	private void setAdditionalMetrics(AdMetrics adMetric) {
		// TODO Auto-generated method stub
		adMetric.setCtr((adMetric.getClicks() / adMetric.getImpressions()) * 100);
		adMetric.setCr((adMetric.getConversions() / adMetric.getImpressions()) * 100);
		adMetric.setFillRate((adMetric.getImpressions() / adMetric.getRequests()) * 100);
		adMetric.seteCPM((adMetric.getRevenue() * 1000) / adMetric.getImpressions());
	}

	private void setMonthfromFileName(AdMetrics adMetric, String fileName) {
		// TODO Auto-generated method stub
		String month = fileName.substring(fileName.indexOf("_") + 1, fileName.lastIndexOf("_"));
		adMetric.setMonth(Month.of(Integer.parseInt(month)).name());
	}

	private SiteVersion getSite(AdMetrics adMetric, String siteName) {
		// TODO Auto-generated method stub
		return siteVersionDaoRepository.getSiteVersionBySiteName(siteName);
	}

	int trimAndParse(String value) {
		return Integer.parseInt(value.trim());
	}

	double trimAndParseDouble(String value) {
		return Double.parseDouble(value.trim());
	}

	private void setHeaderColumnMapping(String[] columnHeaders) {
		// TODO Auto-generated method stub
		for (int i = 0; i < columnHeaders.length; i++) {
			columnHeaderMap.put(columnHeaders[i].trim(), i);
		}
	}

}
