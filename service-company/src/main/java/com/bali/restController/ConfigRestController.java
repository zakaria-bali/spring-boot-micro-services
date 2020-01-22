package com.bali.restController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigRestController {
	
	@Value("${xParam}")
	private int xParam;
	@Value("${yParam}")
	private int yParam;
	@Value("${me}")
	private String me;
	
	@GetMapping("/myConfig")
	public Map<String, Object> myConfig(){
		Map<String, Object> mapConfig = new HashMap<String, Object>();
		mapConfig.put("xParam", this.xParam);
		mapConfig.put("yParam", this.yParam);
		mapConfig.put("me", this.me);
		mapConfig.put("threadName", Thread.currentThread().getName());
		
		return mapConfig;
	}

}
