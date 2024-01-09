package DTO;

import lombok.*;

@Builder
@Getter
public class BookMarkGroupDto {
	private int id;
	private String bookmarkName;
	private String order;
	private String register_date;
	private String update_date;
}
