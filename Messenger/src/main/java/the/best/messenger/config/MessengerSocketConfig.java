package the.best.messenger.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;

import the.best.messenger.services.MessengerService;

@Configuration
public class MessengerSocketConfig {

	@Autowired
	private MessengerService mServ;
	
	@Bean
	public HandlerMapping handlerMapping() {
		Map<String, WebSocketHandler> map = Map.of(
				"/messenger", mServ
				);
	
		return new SimpleUrlHandlerMapping(map, -1);
	}
	
}
