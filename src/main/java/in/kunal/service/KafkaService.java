package in.kunal.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import in.kunal.bindings.Order;
import in.kunal.constents.Appcontenst;

@Service
public class KafkaService {
	
	@Autowired
	private KafkaTemplate<String, Order> kafkatemplate;
	
	public String sendmsg(Order order) {
	  	kafkatemplate.send(Appcontenst.Topic, order);
	  	System.out.println(order);
	  	return " ** MSg Published to Kafka Topic ** ";
	}

}
