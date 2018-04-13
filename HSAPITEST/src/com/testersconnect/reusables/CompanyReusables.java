package com.testersconnect.reusables;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class CompanyReusables {

	String HS_API_KEY="247b80b4-8a77-4c64-9b94-0650f549e9c0";
		
	public String addCompany(String companyName, String companyDesc) {	
		
		HttpClient client=new DefaultHttpClient();
		HttpPost httpPost = new HttpPost("https://api.hubapi.com/companies/v2/companies?hapikey="+HS_API_KEY);
		String inputJson="{\"properties\": [{\"name\": \"name\", \"value\": \""+companyName+"\" }, { \"name\": \"description\", \"value\": \""+companyDesc+"\" }]}";
		
		StringEntity entity = null;
		HttpResponse response=null;
	     try {
	    	entity = new StringEntity(inputJson);
	    	httpPost.setEntity(entity);
	    	httpPost.setHeader("Accept", "application/json");
	    	httpPost.setHeader("Content-type", "application/json");
	    	response=client.execute(httpPost);
	     }catch (Exception e) {
	    	 e.printStackTrace();
	     }
		
		return response.getStatusLine().toString();
	}
	
	public String deleteCompany(String companyID) {
		HttpClient client=new DefaultHttpClient();
		HttpDelete delete=new HttpDelete("https://api.hubapi.com/companies/v2/companies/"+companyID+"?hapikey="+HS_API_KEY);
		HttpResponse res=null;
		try{
			 res = client.execute(delete);
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return res.getStatusLine().toString();
	}
	
}
