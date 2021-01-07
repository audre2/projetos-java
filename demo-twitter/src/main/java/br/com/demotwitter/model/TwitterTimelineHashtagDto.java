package br.com.demotwitter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TwitterTimelineHashtagDto {

	@JsonProperty("start")
	private Integer start;
	@JsonProperty("end")
	private Integer end;
	@JsonProperty("tag")
	private String tag;
}
