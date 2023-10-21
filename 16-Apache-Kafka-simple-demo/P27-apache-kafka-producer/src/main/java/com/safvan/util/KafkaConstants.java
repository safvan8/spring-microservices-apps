package com.safvan.util;

/**
 * This class is used to declare constants of this application
 */
public class KafkaConstants {

	public static final String TOPIC = "customer";
	public static final String GROUP_ID = "group_customer";
	public static final String HOST = "localhost:9092";

	private KafkaConstants() {
		throw new IllegalStateException("Constants class");
	}
}
