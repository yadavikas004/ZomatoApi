package com.deliveryboy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.deliveryboy.config.AppConstants;

@Service
public class KafkaService {
	private Logger logger = LoggerFactory.getLogger(KafkaService.class);

	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	public boolean updateLocation(String location) {
		this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME,location);
		System.out.println("message produced");
		this.logger.info("message produced");
		return true;	
	}
}