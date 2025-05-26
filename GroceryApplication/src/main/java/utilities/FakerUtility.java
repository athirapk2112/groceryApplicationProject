package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
	//faker class to generate fake data
	Faker faker = new Faker();
	
	
	public String generateName()
	{
		return faker.name().fullName();
	}
	
	public String generateAddress()
	{
		return faker.address().fullAddress();
	}
	public String generatePhoneNumber()
	{
		return faker.phoneNumber().phoneNumber();
	}
	public String generateCapital()
	{
		return faker.country().capital();
	}
	public String generateEmail()
	{
		return faker.internet().emailAddress();
	}
}
