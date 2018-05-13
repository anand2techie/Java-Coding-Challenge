package com.ad.reporting;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ad.reporting.controller.AdMetricsController;
import com.ad.reporting.domain.AdMetrics;
import com.ad.reporting.domain.SiteVersion;
import com.ad.reporting.service.AdMetricsServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(AdMetricsController.class)
public class AdMetricsControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AdMetricsServiceImpl adMetricsService;
	
	private List<AdMetrics> adMetrics=new ArrayList<AdMetrics>();
	
	@Before
	public void setup() throws Exception{
		MockitoAnnotations.initMocks(this);
		
		//String month, SiteVersion siteVersion, int requests, int impressions, int clicks,int conversions, double revenue
		adMetrics.add(new AdMetrics("2",new SiteVersion("iOS", "iOS"),2550165d,2419733d,6331d,1564d,4692.28d));
		adMetrics.add(new AdMetrics("2",new SiteVersion("iOS", "iOS"),2550165d,2419733d,6331d,1564d,4692.28d));
	}

	@Test
	public void testGetAdMetricsByMonth() throws Exception {
		when(adMetricsService.getAdMetricsByMonth(Mockito.anyString())).thenReturn(adMetrics);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/reports?month=2")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andReturn();
	}
	
	@Test
	public void testGetAdMetricsByMonthAndSite() throws Exception {
		when(adMetricsService.getAdMetricsByMonthAndSite(Mockito.anyString(),Mockito.anyString())).thenReturn(adMetrics);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/reports?month=2&site=iOS")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andReturn();
	}
	
	@Test
	public void testGetAdMetricsBySite() throws Exception {
		when(adMetricsService.getAdMetricsBySite(Mockito.anyString())).thenReturn(adMetrics);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/reports?site=iOS")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andReturn();
	}
	
	@Test(expected=Exception.class)	
	public void testGetAdMetricsBySite_Null() throws Exception {
		when(adMetricsService.getAdMetricsBySite(Mockito.anyString())).thenReturn(null);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/reports?site=android")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request);
	}

}
