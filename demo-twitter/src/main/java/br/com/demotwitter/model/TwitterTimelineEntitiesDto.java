package br.com.demotwitter.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TwitterTimelineEntitiesDto {

	@JsonProperty("annotations")
	private List<TwitterTimelineAnnotationDto> annotations;
	@JsonProperty("hashtags")
	private List<TwitterTimelineHashtagDto> hashtags;
	@JsonProperty("urls")
	private List<TwitterTimelineUrlDto> urls;
	@JsonProperty("mentions")
	private List<TwitterTimelineMentionDto> mentions;
}
