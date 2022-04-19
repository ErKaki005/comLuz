package shared.comLuz.domain;

import com.github.javafaker.Faker;

public final class WordMother {


    public static String random() {
        return Faker.instance().gameOfThrones().house();
    }
	
	
}
