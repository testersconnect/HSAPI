package com.testersconnect.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testersconnect.reusables.*;

public class Add_Group_Contacts {

	@Test
	public void AddMultipleContacts() {
		// Arrange
		ContactReusables contact = new ContactReusables();
		String[] email = { "Antony.M@tester.com", "John.V@tester.com", "Dennis.B@tester.com" };
		String[] fName = { "Antony", "John", "Dennis" };
		String[] lName = { "Mathew", "Victor", "Bare" };

		// ACT - Execute method to add contact
		for (int i = 0; i < 3; i++) {
			contact.addContact(email[i], fName[i], lName[i]);
		}

		// Assert - Verify if Contacts are created
		for (int i = 0; i < 3; i++) {
			String id = contact.getContactID(email[i]);
			Assert.assertNotNull(id);
		}

		// Clean-UP delete the contacts created
		for (int i = 0; i < 3; i++) {
			String id = contact.getContactID(email[i]);
			contact.deleteContact(id);
		}
	}
}
