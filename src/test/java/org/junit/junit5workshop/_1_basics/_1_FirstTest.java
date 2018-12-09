package org.junit.junit5workshop._1_basics;

import org.junit.junit5workshop._2_dynamic_tests.PrimeNumbers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class _1_FirstTest {

	/*
	 * Write some tests with @Test and disable one of them with @Disabled
	 */
	@Test
	void oneShouldBePrime(){
		assertThat(PrimeNumbers.isPrime(1L)).isTrue();
	}

	@Disabled
	void disabledTest(){
		assertThat(PrimeNumbers.isPrime(2L)).isTrue();
	}

}
