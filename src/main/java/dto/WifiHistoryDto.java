package dto;

import lombok.*;

@Getter
@Builder
public class WifiHistoryDto {
	private int col;
	private String lnt;
	private String lat;
	private String view_date;
}
