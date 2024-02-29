package in.kunal.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.kunal.bindings.Order;
import in.kunal.service.KafkaService;

@RestController
public class OrderRestController {
	
	@Autowired
	private KafkaService kafkaservice;
	
	@PostMapping("/order")
	public String saveorder(@RequestBody Order order) {
		return kafkaservice.sendmsg(order);
	}

}
