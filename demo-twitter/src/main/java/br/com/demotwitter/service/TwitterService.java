package br.com.demotwitter.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.demotwitter.model.DemoTwitterResponseDto;
import br.com.demotwitter.model.TwitterTimelineDataDto;
import br.com.demotwitter.model.TwitterTimelineResponseDto;
import br.com.demotwitter.model.TwitterUserApiResponseDto;

@Service
public class TwitterService {
	
	public HttpHeaders getHeader() {
		final String token = "Bearer AAAAAAAAAAAAAAAAAAAAANuD%2FQAAAAAAIN9H37f5BzEOeWdzUcQ%2BL%2F%2F4QHs%3DpQKSUaeP92WK2vh5Cw0pCIYRDbhBk52f0DZskqEtrLcc4IDuCp";
		// create headers
	    HttpHeaders headers = new HttpHeaders();
	    headers.set("Authorization", token);
	    return headers;
	}

	public String getUsernameId(String user) {
		
		final String uri = "https://api.twitter.com/2/users/by/username/{user}";
	    RestTemplate restTemplate = new RestTemplate();
	    
	    // build the request
	    HttpEntity entity = new HttpEntity(getHeader());
	    
	    // make an HTTP GET request with headers
	    ResponseEntity<TwitterUserApiResponseDto> response = restTemplate.exchange(
	    		uri,
	            HttpMethod.GET,
	            entity,
	            TwitterUserApiResponseDto.class,
	            user
	    );
	    
	    // check response
	    if (response.getStatusCode() == HttpStatus.OK) {
	        System.out.println("Request Successful.");
	        System.out.println(response.getBody());
	    } else {
	        System.out.println("Request Failed");
	        System.out.println(response.getStatusCode());
	    }
	    
	    return response.getBody().getData().getId();
	}
	
	public DemoTwitterResponseDto getTopHashtagFromUser(String user) {
		
		final String uri = "https://api.twitter.com/2/users/{user}/tweets?max_results=100&tweet.fields=entities";
	    RestTemplate restTemplate = new RestTemplate();
	    
	    // build the request
	    HttpEntity entity = new HttpEntity(getHeader());
	    
	    // make an HTTP GET request with headers
	    ResponseEntity<TwitterTimelineResponseDto> response = restTemplate.exchange(
	    		uri,
	            HttpMethod.GET,
	            entity,
	            TwitterTimelineResponseDto.class,
	            user
	    );
	    
	    // check response
	    if (response.getStatusCode() == HttpStatus.OK) {
	        System.out.println("Request Successful.");
	        System.out.println(response.getBody());
	    } else {
	        System.out.println("Request Failed");
	        System.out.println(response.getStatusCode());
	    }
	    
	    List<TwitterTimelineDataDto> data = response.getBody().getData();
	    List<String> hashtags = new ArrayList<String>();
	    List<String> hashtags2 = new ArrayList<String>();
	    data.stream()
	    	.filter(v-> Objects.nonNull(v.getEntities()))
	    	.filter(v -> Objects.nonNull(v.getEntities().getHashtags()))
	    	.forEach(c-> c.getEntities().getHashtags().stream()
	    			.forEach(c2-> hashtags.add(c2.getTag().toUpperCase())));
	    
	    //Pegar os 5 mais frequentes
	    Map<String, Long> map = hashtags.stream()
	            .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

	    List<Map.Entry<String, Long>> result = map.entrySet().stream()
	            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
	            .limit(5)
	            .collect(Collectors.toList());
	    //fim
	    
	    result.stream().forEach(c-> hashtags2.add(c.getKey()));
	    DemoTwitterResponseDto finalResponse = new DemoTwitterResponseDto();
	    finalResponse.setHashtags(hashtags2);
	    
	    return finalResponse;
	}
}
