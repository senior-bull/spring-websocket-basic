package com.example.messagingstompwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class DataController {

	private final DataProvider dataProvider = new DataProvider();

	@MessageMapping("/hello")
	@SendTo("/topic/prices")
	public PriceUpdatesMessage updatePricesOnSubscribers(HelloMessage message) throws Exception {

		return new PriceUpdatesMessage(dataProvider.snapshot());
	}

}
