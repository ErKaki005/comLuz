package shared.comLuz.domain;

import com.github.javafaker.Faker;

public final class IntMother {

    public static Integer random() {
        return Faker.instance().number().randomDigitNotZero();
    }
	
}
