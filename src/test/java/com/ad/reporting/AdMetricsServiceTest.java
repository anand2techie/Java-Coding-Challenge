package com.ad.reporting;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ad.reporting.domain.AdMetrics;
import com.ad.reporting.domain.SiteVersion;
import com.ad.reporting.repository.AdMetricsDaoRepository;
import com.ad.reporting.repository.SiteVersionDaoRepository;
import com.ad.reporting.service.AdMetricsService;
import com.ad.reporting.service.AdMetricsServiceImpl;
import com.ad.reporting.service.SiteVersionServiceImpl;
import com.ad.reporting.util.CSVParserUtil;
import com.ad.reporting.util.CSVReaderUtil;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class AdMetricsServiceTest {

	@Mock
	private AdMetricsDaoRepository adMetricsDaoRepository;
	
	@InjectMocks
	private AdMetricsServiceImpl adMetricsService;
	
	@Mock
	private SiteVersionServiceImpl siteVersionService;
	
	private List<AdMetrics> adMetrics=new ArrayList<AdMetrics>();
	
	@Before
	public void setup() throws Exception{
		MockitoAnnotations.initMocks(this);
		
		//String month, SiteVersion siteVersion, int requests, int impressions, int clicks,int conversions, double revenue
		adMetrics.add(new AdMetrics("2",new SiteVersion("iOS", "iOS"),2550165d,2419733d,6331d,1564d,4692.28d));
		adMetrics.add(new AdMetrics("2",new SiteVersion("iOS", "iOS"),2550165d,2419733d,6331d,1564d,4692.28d));
	}
	
	@Test
	public void testGetAdMetricsByMonth(){
		when(adMetricsDaoRepository.getAdMetricsByMonth(Mockito.anyString())).thenReturn(adMetrics);
		List<AdMetrics> result = adMetricsService.getAdMetricsByMonth("2");
		assertEquals(2, result.size());
	}
	
	@Test
	public void testGetAdMetricsByMonthAndSite(){
		when(adMetricsDaoRepository.getAdMetricsByMonthAndSiteVersion(Mockito.anyString(),Mockito.anyString())).thenReturn(adMetrics);
		List<AdMetrics> result = adMetricsService.getAdMetricsByMonthAndSite("2", "iOS");
		assertEquals(2, result.size());
	}
	
	@Test
	public void testGetAdMetricsBySite(){
		when(adMetricsDaoRepository.getAdMetricsBySiteVersion(Mockito.any())).thenReturn(adMetrics);
		List<AdMetrics> result = adMetricsService.getAdMetricsBySite("iOS");
		assertEquals(2, result.size());
	}
	
}
