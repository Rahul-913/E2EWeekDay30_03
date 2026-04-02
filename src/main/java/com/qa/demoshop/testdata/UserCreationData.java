package com.qa.demoshop.testdata;

import org.testng.annotations.DataProvider;

import com.qa.demoshop.utilities.FakeDataGenerator;

public class UserCreationData {

	static FakeDataGenerator dataGen = new FakeDataGenerator();

	@DataProvider(name = "userData")
	public String[][] userData() {
		String[][] data = new String[1][4];
		data[0][0] = dataGen.getFakeFirstName();
		data[0][1] = dataGen.getFakeLastName();
		data[0][2] = dataGen.getFakeEmail();
		data[0][3] = dataGen.getFakePassword();
		return data;
	}
}
