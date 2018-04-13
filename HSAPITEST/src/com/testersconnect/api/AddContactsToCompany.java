package com.testersconnect.api;

import org.testng.annotations.Test;

import com.testersconnect.reusables.*;
public class AddContactsToCompany {

	ContactReusables contactRes=new ContactReusables();
	CompanyReusables companyRes=new CompanyReusables();
	CommonEntities comE=new CommonEntities();
	//Commment - Delete this
	String CONTACT_EMAIL="hr23@testinghub.com";
	String CONTACT_FIRST_NAME="John23";
	String CONTACT_LAST_NAME="Blake23";
	
	String COMPANY_NAME="Testers Connect1";
	String COMPANY_DESC="The Place for QA & DevOps";
	@Test
	public void verifyAddContactsToCompany() {
	
		//Arrange
		//Create a Contact
		contactRes.addContact(CONTACT_EMAIL, CONTACT_FIRST_NAME, CONTACT_LAST_NAME);
		
		//Create a Company
		companyRes.addCompany(COMPANY_NAME, COMPANY_DESC);
		
		//ACT
		String contactID=contactRes.getContactID(CONTACT_EMAIL);
		//ADD Contact to Company
		comE.addContactToCompany(contactID, 761230925);

		//ASSERT
		//Get Contacts of the Company

		//CLEAN UP
		//Delete Contact
		//contactRes.deleteContact(contactID);
		
		//Delete Company
		//companyRes.deleteCompany("761230925");
	
	
	
	}
	
	
	
	
}
