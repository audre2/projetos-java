package br.com.demotwitter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TwitterTimelineAnnotationDto {
	
	@JsonProperty("start")
	private Integer start;
	@JsonProperty("end")
	private Integer end;
	@JsonProperty("probability")
	private Double probability;
	@JsonProperty("type")
	private String type;
	@JsonProperty("normalized_text")
	private String normalizedText;

}
