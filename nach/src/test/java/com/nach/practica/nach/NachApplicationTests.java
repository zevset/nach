package com.nach.practica.nach;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.nach.practica.nach.utils.Utilities;

@SpringBootTest
class NachApplicationTests {

	
	@Test
	void isOld_test() {
		Utilities util = new Utilities();
		boolean response = util.isOld("1992-06-12");
		Assert.isTrue(response);
	}
	
	@Test
	void isdiferenteDay_Test() {
		Utilities util = new Utilities();
		boolean response = util.isOtherDay("2022-06-23");
		Assert.isTrue(response);
	}
	
	@Test
	void isdiferenteDay2_Test() {
		Utilities util = new Utilities();
		boolean response = util.isValidateDate("2022-06-22", "2022-06-23");
		Assert.isTrue(response);
	}

}
