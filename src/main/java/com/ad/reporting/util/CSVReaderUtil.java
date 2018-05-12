package com.ad.reporting.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ad.reporting.constants.AdReportingConstants;
import com.ad.reporting.domain.AdMetrics;
import com.ad.reporting.domain.SiteVersion;
import com.ad.reporting.repository.SiteVersionDaoRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Service
public class CSVReaderUtil {

	Map<String, Integer> columnHeaderMap = new HashMap<String, Integer>();

	@Autowired
	SiteVersionDaoRepository siteVersionDaoRepository;
	
	@Autowired
	CSVParserUtil csvParserUtil;

	public List readCSVFiles(File file) throws IOException {
		CSVReader reader = new CSVReaderBuilder(new FileReader(file)).build();
		csvParserUtil.setReader(reader, file);
		List<AdMetrics> adMetrics = csvParserUtil.parseCSVFiles();
		reader.close();
		return adMetrics;

	}
}
