package org.junit.junit5workshop._2_dynamic_tests;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PrimeNumbersTest {

    /*
     * (1)
     * Write dynamic tests that check {@link PrimeNumbers#isPrime(long)}
     * for the first 1000 numbers from txt file.
     */

    @TestFactory
    Stream<DynamicTest> checkFirst1000Primes() throws Exception {
        return primes()
                .mapToObj(number ->
                        DynamicTest.dynamicTest("is" + number + "prime", ()
                                -> assertThat(PrimeNumbers.isPrime(number)).isTrue())
                )
                .limit(1000);
    }

    private LongStream primes() throws Exception {
        return Files.lines(Paths.get(getClass().getResource("/primes-1000.txt").toURI()))
                .mapToLong(Long::parseLong);
    }
}
