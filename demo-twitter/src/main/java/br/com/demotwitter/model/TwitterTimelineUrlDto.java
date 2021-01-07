package br.com.demotwitter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TwitterTimelineUrlDto {

	@JsonProperty("start")
	private Integer start;
	@JsonProperty("end")
	private Integer end;
	@JsonProperty("url")
	private String url;
	@JsonProperty("expanded_url")
	private String expandedUrl;
	@JsonProperty("display_url")
	private String displayUrl;
}
