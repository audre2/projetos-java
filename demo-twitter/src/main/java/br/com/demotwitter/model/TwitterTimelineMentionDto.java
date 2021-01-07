package br.com.demotwitter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TwitterTimelineMentionDto {
	
	@JsonProperty("start")
	private Integer start;
	@JsonProperty("end")
	private Integer end;
	@JsonProperty("username")
	private String username;

}
