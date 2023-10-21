package com.safvan.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.safvan.model.Customer;
import com.safvan.util.KafkaConstants;

/**
 * 
 * @author Ashok
 *
 */
@Configuration
public class KafkaProduceConfig {

	/**
	 * This method is used to Kafka Producer Config details
	 * 
	 * @return
	 */

	@Bean
	public ProducerFactory<String, Customer> producerFactory() {
		Map<String, Object> configProps = new HashMap<String, Object>();

		// Configure the Kafka broker host. KafkaConstants.HOST holds the address.
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.HOST);

		// Set the key serializer for the producer. In this case, it's StringSerializer.
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		// Set the value serializer for the producer. JsonSerializer is used to serialize the message.
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		return new DefaultKafkaProducerFactory(configProps);
	}

	/**
	 * This method is used to create KafkaTemplate bean obj
	 * 
	 * @return
	 */
	@Bean(name = "kafkaTemplate")
	public KafkaTemplate<String, Customer> kafkaTemplate() {
		// Creating KafkaTemplate using the customized producer factory
		return new KafkaTemplate<>(producerFactory());
	}
}
