package dto;

import lombok.*;

@Getter
@Builder
public class SearchedWifiDto {
	private int col;
	private String lnt;
	private String lat;
	private String view_date;
}
