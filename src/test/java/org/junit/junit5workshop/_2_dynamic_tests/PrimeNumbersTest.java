package org.junit.junit5workshop._2_dynamic_tests;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.LongStream;

public class PrimeNumbersTest {

    /*
     * (1)
     * Write dynamic tests that check {@link PrimeNumbers#isPrime(long)}
     * for the first 1000 numbers from txt file.
     */

    private LongStream primes() throws Exception {
        return Files.lines(Paths.get(getClass().getResource("/primes-1000.txt").toURI()))
                .mapToLong(Long::parseLong);
    }
}
