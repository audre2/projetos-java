package br.com.demotwitter.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TwitterTimelineResponseDto {

	@JsonProperty("data")
	private List<TwitterTimelineDataDto> data;
	@JsonProperty("meta")
	private TwitterMetaDto meta;
}
