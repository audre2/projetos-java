package br.com.demotwitter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TwitterMetaDto {
	
	@JsonProperty("oldest_id")
	private String oldestId;
	@JsonProperty("newest_id")
	private String newestId;
	@JsonProperty("result_count")
	private Integer resultCount;
	@JsonProperty("next_token")
	private String nextToken;

}
