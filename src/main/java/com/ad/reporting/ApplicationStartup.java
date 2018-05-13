package com.ad.reporting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.ad.reporting.domain.AdMetrics;
import com.ad.reporting.repository.AdMetricsDaoRepository;
import com.ad.reporting.util.CSVReaderUtil;

@Configuration
@Transactional
public class ApplicationStartup {

	@Autowired
	ResourceLoader resourceLoader;

	@Autowired
	CSVReaderUtil csvReaderUtil;

	@Autowired
	AdMetricsDaoRepository adMetricsDaoRepository;

	@PostConstruct
	void saveCSVFile() throws FileNotFoundException, IOException {
		Resource resource = resourceLoader.getResource("classpath:csvs");
		File[] files = resource.getFile().listFiles();
		for (File file : files) {
			List<AdMetrics> csvToBean = csvReaderUtil.readCSVFiles(file);
			adMetricsDaoRepository.saveAll(csvToBean);
		}

	}

}
