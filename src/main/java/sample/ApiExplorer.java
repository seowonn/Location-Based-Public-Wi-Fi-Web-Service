package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ApiExplorer {
	
	static final String fileType = "json";
	
	public ApiExplorer(){}
	
	
	static String buildURL(int requestStartPage, int requestEndPage) {
		final String key = "4b7049626574726138344354657357";
		String openApiUrl = "http://openapi.seoul.go.kr:8088/";
		
		StringBuilder urlBuilder = new StringBuilder(openApiUrl);
		urlBuilder.append(key + "/" + fileType + "/TbPublicWifiInfo");
		
		try {
			
			urlBuilder.append("/" + URLEncoder.encode(Integer.toString(requestStartPage),"UTF-8"));
			urlBuilder.append("/" + URLEncoder.encode(Integer.toString(requestEndPage),"UTF-8"));
			Exception e = new Exception("인코딩 할 수 없는 url이 입력되었습니다.");			
			throw e;
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		return urlBuilder.toString();
	}
	
	
	private static String getOpenApiData(String openApiUrl) throws IOException{
		
		URL url = new URL(openApiUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/" + fileType);
		System.out.println("Response code: " + conn.getResponseCode());
		System.out.println();
		
		BufferedReader rd;
		
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		
		StringBuilder wifiDatas = new StringBuilder();
		String line;
		
		while((line = rd.readLine()) != null) {
			wifiDatas.append(line);
		}
		
		rd.close();
		conn.disconnect();
		
		return wifiDatas.toString();
	}
	
	
	public static void main(String[] args) throws IOException {
		
		int requestStartPage = 1;
		int requestEndPage = 1;
		
		String openApiUrl = buildURL(requestStartPage, requestEndPage);
		
		String wifiDatas = getOpenApiData(openApiUrl);
		
		JSONObject result = null;
		
		try {
			result = (JSONObject) new JSONParser().parse(wifiDatas);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		JSONObject oneData = (JSONObject) result.get("TbPublicWifiInfo");
		requestEndPage = Integer.parseInt(oneData.get("list_total_count").toString());
		System.out.println(requestEndPage);
		
		String builtUrl = null;
		for(int i = requestStartPage; i <= requestEndPage; i += 1000) {	// 한 번에 1000개씩만 가져올 수 있어서.		
			builtUrl = buildURL(i, Math.min(requestEndPage, i + 999));
			wifiDatas = getOpenApiData(builtUrl);
			
			try {
				result = (JSONObject) new JSONParser().parse(wifiDatas);
			} catch(ParseException e) {
				e.printStackTrace();
			}
			
			JSONObject wholeDatas = (JSONObject) result.get("TbPublicWifiInfo");
			JSONArray array = (JSONArray) wholeDatas.get("row");
			
			JSONObject tmp;
			for(int j = 0; j < array.size(); j++) {
				System.out.printf("< %d번째 와이파이 정보 >\n", (i + j));
				tmp = (JSONObject)array.get(j);
				String jsonString = tmp.toString();
				
				Gson gson = new GsonBuilder().create();
				PublicWifiInfo wifiInfo = gson.fromJson(jsonString, PublicWifiInfo.class);
				
				wifiInfo.getInfo();
				System.out.println();
			}
		}
		
	}
}