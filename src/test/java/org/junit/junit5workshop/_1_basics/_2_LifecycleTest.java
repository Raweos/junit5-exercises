package org.junit.junit5workshop._1_basics;

import org.junit.junit5workshop._2_dynamic_tests.PrimeNumbers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class _2_LifecycleTest {

	/*
	 * Write lifecycle methods that use the following annotations:
	 *
	 *  - @BeforeAll, @AfterAll
	 *  - @BeforeEach, @AfterEach
	 *
	 *  They do not have to do anything much, printing to system.out suffices.
	 *
	 *  Write at least two tests to see how the lifecycle methods are executed.
	 */

	@BeforeAll
	static void beforeAll(){
		System.out.println("All test starts");
	}

	@Test
	void twoShouldNotBePrime(){
		assertThat(PrimeNumbers.isPrime(2));
	}

	@AfterAll
	static void afterAll(){
		System.out.println("Tests finished");
	}

}
