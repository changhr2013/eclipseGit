package com.dcode.service.impl;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dcode.service.JfmpegWebService;

public class WebServiceTest {
	@Autowired
	private JfmpegWebService webService;

	public static void main(String[] args) {
		
		//JfmpegWebService webService;
		//webService.OpenConfigStream();
		//webService.CloseConfigStream();
		System.out.println("end");

	}
	
	@Test
	public void testReset() {
		webService.Reset();
	}

}
