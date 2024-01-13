package dto;

import lombok.*;

@Getter
@Setter
@Builder
public class BookMarkDto {
	private int id;
	private String bookmarkName;
	private String wifiName;
	private String register_dttm;
}
