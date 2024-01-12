package dto;

import lombok.*;

@Getter
@Setter
@Builder
public class WIfiInfosDto {
	private double distance;
	private String mgr_no; 		// 관리번호
	private String wrdofc; 		// 자치구
	private String main_nm; 	// 와이파이명
	private String adres1; 		// 도로명주소
	private String adres2; 		// 상세주소
	private String instl_floor; // 설치위치(층)
	private String instl_ty; 	// 설치유형
	private String instl_mby; 	// 설치기관
	private String svc_se; 		// 서비스구분
	private String cmcwr; 		// 망종류
	private String cnstc_year; 	// 설치년도
	private String inout_door; 	// 실내외구분
	private String remars3; 	// wifi접속환경
	private String lnt; 	// x좌표
	private String lat; 	// y좌표
	private String work_dttm; 	// 작업일자
}
