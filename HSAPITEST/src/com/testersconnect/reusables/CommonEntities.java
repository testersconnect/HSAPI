package com.testersconnect.reusables;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CommonEntities {

	String HS_API_KEY = "247b80b4-8a77-4c64-9b94-0650f549e9c0";

	public String addContactToCompany(String contactID, int i) {

		HttpClient client = new DefaultHttpClient();
		HttpResponse response = null;
		try {

			HttpPut httpaddConToCompany = new HttpPut("https://api.hubapi.com/companies/v2/companies/" + i
					+ "/contacts/" + contactID + "?hapikey=" + HS_API_KEY);
			response = client.execute(httpaddConToCompany);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response.getStatusLine().toString();
	}

	public String getContactOfCompany(String companyID) {

		HttpClient hc = new DefaultHttpClient();
		HttpResponse response = null;
		
		String id=null;
		JsonObject json=null;
		try {
			HttpGet httpGetContactOfCompany = new HttpGet(
					"https://api.hubapi.com/companies/v2/companies/"+companyID+"/contacts?hapikey="+HS_API_KEY);
			response=hc.execute(httpGetContactOfCompany);
			String result=EntityUtils.toString(response.getEntity());
			JsonParser parser = new JsonParser();
			json = (JsonObject) parser.parse(result);
			System.out.println(json.toString());
     		//id=json.get("vid").toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//return response.getStatusLine().toString();
		return json.toString();
	}

}
