package br.com.demotwitter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.demotwitter.model.DemoTwitterResponseDto;
import br.com.demotwitter.service.TwitterService;

@RestController
public class TwitterController {

	private HttpServletRequest request;
	//client id para chamar o controller
	static final String clientId = "4c0a20945ff3429ccefd66d63d310a4c";
	
	@Autowired
	TwitterService twitterService;

	@Autowired
	public TwitterController(HttpServletRequest request) {
		this.request = request;
	}

	@GetMapping("/user/{username}")
	public DemoTwitterResponseDto getTopHashtagFromUser(@PathVariable("username") String username) {
		
		String user = twitterService.getUsernameId(username);
		String userClientId = request.getHeader("client-id");
		
		if (userClientId != null && userClientId.equals(clientId)) {
			return twitterService.getTopHashtagFromUser(user);
		}
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);

	}

}
