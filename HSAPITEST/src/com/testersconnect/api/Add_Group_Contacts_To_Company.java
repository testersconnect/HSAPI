package com.testersconnect.api;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.testersconnect.reusables.CommonEntities;
import com.testersconnect.reusables.ContactReusables;
import com.testersconnect.reusables.*;

public class Add_Group_Contacts_To_Company {

	@Test
	public void AddGroupOfContactsToCompany() {
		
		//Arrange
		ContactReusables contact = new ContactReusables();
		CommonEntities ce = new CommonEntities();
		//HttpResponse response=null;
		//HttpClient hc=new DefaultHttpClient();
		String[] email = { "Antony.M@tester.com", "John.V@tester.com", "Dennis.B@tester.com" };
		String[] fName = { "Antony", "John", "Dennis" };
		String[] lName = { "Mathew", "Victor", "Bare" };

		for (int i = 0; i < 3; i++) {
			contact.addContact(email[i], fName[i], lName[i]);
		}
		
		
		//ACT
		for(int i=0;i<3;i++) {
			String contactID = contact.getContactID(email[i]);
			String response=ce.addContactToCompany(contactID, 761567126);
			String res=ce.getContactOfCompany("761567126");
			 Assert.assertEquals(res.contains(contactID),true);
			 //clean-up
		     contact.deleteContact(contactID);	 
					}
			
		
	}

}
