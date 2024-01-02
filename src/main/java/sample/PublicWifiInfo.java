package sample;

public class PublicWifiInfo {
    private String X_SWIFI_MGR_NO;   
    private String X_SWIFI_WRDOFC;   
    private String X_SWIFI_MAIN_NM;   
    private String X_SWIFI_ADRES1;   
    private String X_SWIFI_ADRES2;   
    private String X_SWIFI_INSTL_FLOOR;   
    private String X_SWIFI_INSTL_TY;   
    private String X_SWIFI_INSTL_MBY;   
    private String X_SWIFI_SVC_SE;   
    private String X_SWIFI_CMCWR;   
    private String X_SWIFI_CNSTC_YEAR;   
    private String X_SWIFI_INOUT_DOOR;   
    private String X_SWIFI_REMARS3;   
    private String LAT;   
    private String LNT;   
    private String WORK_DTTM;   
    
    PublicWifiInfo(){}
    
    public PublicWifiInfo(String x_SWIFI_MGR_NO, String x_SWIFI_WRDOFC, String x_SWIFI_MAIN_NM, String x_SWIFI_ADRES1,
			String x_SWIFI_ADRES2, String x_SWIFI_INSTL_FLOOR, String x_SWIFI_INSTL_TY, String x_SWIFI_INSTL_MBY,
			String x_SWIFI_SVC_SE, String x_SWIFI_CMCWR, String x_SWIFI_CNSTC_YEAR, String x_SWIFI_INOUT_DOOR,
			String x_SWIFI_REMARS3, String lAT, String lNT, String wORK_DTTM) {
		this.X_SWIFI_MGR_NO = x_SWIFI_MGR_NO;
		this.X_SWIFI_WRDOFC = x_SWIFI_WRDOFC;
		this.X_SWIFI_MAIN_NM = x_SWIFI_MAIN_NM;
		this.X_SWIFI_ADRES1 = x_SWIFI_ADRES1;
		this.X_SWIFI_ADRES2 = x_SWIFI_ADRES2;
		this.X_SWIFI_INSTL_FLOOR = x_SWIFI_INSTL_FLOOR;
		this.X_SWIFI_INSTL_TY = x_SWIFI_INSTL_TY;
		this.X_SWIFI_INSTL_MBY = x_SWIFI_INSTL_MBY;
		this.X_SWIFI_SVC_SE = x_SWIFI_SVC_SE;
		this.X_SWIFI_CMCWR = x_SWIFI_CMCWR;
		this.X_SWIFI_CNSTC_YEAR = x_SWIFI_CNSTC_YEAR;
		this.X_SWIFI_INOUT_DOOR = x_SWIFI_INOUT_DOOR;
		this.X_SWIFI_REMARS3 = x_SWIFI_REMARS3;
		this.LAT = lAT;
		this.LNT = lNT;
		this.WORK_DTTM = wORK_DTTM;
	}
          
    
    public void getInfo() {
		System.out.println("관리번호" + ":" + this.X_SWIFI_MGR_NO);
		System.out.println("자치구" + ":" + this.X_SWIFI_WRDOFC);
		System.out.println("와이파이명" + ":" + this.X_SWIFI_MAIN_NM);
		System.out.println("도로명주소" + ":" + this.X_SWIFI_ADRES1);
		System.out.println("상세주소" + ":" + this.X_SWIFI_ADRES2);
		System.out.println("설치위치(층)" + ":" + this.X_SWIFI_INSTL_FLOOR);
		System.out.println("설치유형" + ":" + this.X_SWIFI_INSTL_TY);
		System.out.println("설치기관" + ":" + this.X_SWIFI_INSTL_MBY);
		System.out.println("서비스구분" + ":" + this.X_SWIFI_SVC_SE);
		System.out.println("망종류" + ":" + this.X_SWIFI_CMCWR);
		System.out.println("설치년도" + ":" + this.X_SWIFI_CNSTC_YEAR);
		System.out.println("실내외구분" + ":" + this.X_SWIFI_INOUT_DOOR);
		System.out.println("wifi접속환경" + ":" + this.X_SWIFI_REMARS3);
		System.out.println("Y좌표" + ":" + this.LAT);
		System.out.println("X좌표" + ":" + this.LNT);
		System.out.println("작업일자" + ":" + this.WORK_DTTM);
    }
}
