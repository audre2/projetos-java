package br.com.demotwitter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TwitterTimelineDataDto {
	
	@JsonProperty("entities")
	private TwitterTimelineEntitiesDto entities;
	@JsonProperty("id")
	private String id;
	@JsonProperty("text")
	private String text;

}
