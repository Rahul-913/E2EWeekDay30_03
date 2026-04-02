package com.qa.demoshop.utilities;

import com.github.javafaker.Faker;

public class FakeDataGenerator {
	static Faker fake = new Faker();

	public String getFakeFirstName() {
		return fake.name().firstName();
	}

	public String getFakeLastName() {
		return fake.name().lastName();
	}

	public String getFakeEmail() {
		return fake.internet().emailAddress();
	}

	public String getFakePassword() {
		return fake.internet().password(8, 16, true, true, true);
	}
}
