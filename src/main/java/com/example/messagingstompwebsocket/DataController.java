package com.example.messagingstompwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class DataController {

	private final DataProvider dataProvider = new DataProvider();

	// TODO could be used for snapshots
	@MessageMapping("/hello")
	@SendTo("/topic/prices")
	public SnapshotMsg greeting(HelloMessage message) throws Exception {

		return new SnapshotMsg(dataProvider.snapshot());
	}

}
