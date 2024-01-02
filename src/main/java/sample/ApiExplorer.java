/* Java 1.8 샘플 코드 */
package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ApiExplorer {
	public static void main(String[] args) throws IOException, ParseException {
//	public static void api() throws IOException{
		String key = "4b7049626574726138344354657357";
		String fileType = "json";
		int requestStartPage = 1;
		int requestEndPage = 20;
		
		StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088/");
		urlBuilder.append(key + "/" + fileType + "/TbPublicWifiInfo"); /*URL*/
		urlBuilder.append("/" + URLEncoder.encode(Integer.toString(requestStartPage),"UTF-8"));
		urlBuilder.append("/" + URLEncoder.encode(Integer.toString(requestEndPage),"UTF-8"));

		System.out.println(urlBuilder.toString());
		System.out.println();
		
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/" + fileType);
		System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
		System.out.println();
		
		BufferedReader rd;

		// 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		
		StringBuilder sb = new StringBuilder();
		String line;
		
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		
		JSONObject result = null;
		result = (JSONObject) new JSONParser().parse(sb.toString());
		JSONObject data = (JSONObject) result.get("TbPublicWifiInfo");
		JSONArray array = (JSONArray) data.get("row");
		
		JSONObject tmp;
		for(int i = 0; i < array.size(); i++) {
			System.out.printf("< %d번째 와이파이 정보 >\n", (i + 1));
			tmp = (JSONObject)array.get(i);
			String jsonString = tmp.toString();
			
			Gson gson = new GsonBuilder().create();
			PublicWifiInfo wifiInfo = gson.fromJson(jsonString, PublicWifiInfo.class);

			wifiInfo.getInfo();
			System.out.println();
		}
	}
}