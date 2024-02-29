package in.kunal.config;

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

import in.kunal.bindings.Order;
import in.kunal.constents.Appcontenst;

@Configuration
public class ProducerConfigclass {
	
	@Bean
	public ProducerFactory<String, Order> factory (){
		Map<String, Object> procofig = new HashMap<>();
             procofig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,Appcontenst.Host);
             procofig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
             procofig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
             
             return new DefaultKafkaProducerFactory<>(procofig);
	}
	
	@Bean
	public KafkaTemplate<String, Order> kafkaTemplate (){
		return new KafkaTemplate<>(factory());
	}

}
