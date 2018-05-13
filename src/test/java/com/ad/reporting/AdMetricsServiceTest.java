package com.ad.reporting;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ad.reporting.repository.AdMetricsDaoRepository;
import com.ad.reporting.service.AdMetricsService;

@RunWith(SpringJUnit4ClassRunner.class)
public class AdMetricsServiceTest {

	@Mock
	private AdMetricsDaoRepository toDoRepository;
	
	@InjectMocks
	private AdMetricsService toDoService;
	
	@Before(value = "")
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAdMetricsBySite(){
		
	}
	
}
