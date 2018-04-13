package com.testersconnect.reusables;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ContactReusables {
	//HttpClient hc = new DefaultHttpClient();
	
	String HS_API_KEY="247b80b4-8a77-4c64-9b94-0650f549e9c0";
	String EMAIL=null;
	
	
	
	
	public String getContactID(String email) {
		HttpClient hc = new DefaultHttpClient();
		HttpGet get=new HttpGet("https://api.hubapi.com/contacts/v1/contact/email/"+email+"/profile?hapikey="+HS_API_KEY);
		HttpResponse response=null;
		String id=null;
		try {
			response=hc.execute(get);
			String result=EntityUtils.toString(response.getEntity());
			JsonParser parser = new JsonParser();
			JsonObject json = (JsonObject) parser.parse(result);
     		id=json.get("vid").toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return id;
		
	}
	
	
	public String addContact(String email, String fName, String lName) {
		HttpClient hc = new DefaultHttpClient();
	     HttpPost httpPost = new HttpPost("https://api.hubapi.com/contacts/v1/contact/?hapikey="+HS_API_KEY);
	     String json="{ \"properties\": [ { \"property\": \"email\", \"value\": \""+email+"\" }, { \"property\": \"firstname\", \"value\": \""+fName+"\" },  { \"property\": \"lastname\", \"value\": \""+lName+"\" } ] } ";
	     StringEntity entity = null;
	     HttpResponse response=null;
	     
	    try {
	    entity = new StringEntity(json);
	    	
	    httpPost.setEntity(entity);
	    httpPost.setHeader("Accept", "application/json");
	    httpPost.setHeader("Content-type", "application/json");
	    response=hc.execute(httpPost);
	   
	     }catch (Exception e) {
	    	 e.printStackTrace();
	     }
		
		return response.getStatusLine().toString();
	}
	
	
	public String deleteContact(String contactID) {
		
		HttpClient hc = new DefaultHttpClient();
	    
		HttpResponse res=null;
		try {
			
			 HttpDelete httpDelete = new HttpDelete("https://api.hubapi.com/contacts/v1/contact/vid/"+contactID+"?hapikey="+HS_API_KEY);
			 res = hc.execute(httpDelete);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res.getStatusLine().toString();
	}
	
	
	
	
}
