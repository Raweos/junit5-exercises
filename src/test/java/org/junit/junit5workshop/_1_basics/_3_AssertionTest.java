package org.junit.junit5workshop._1_basics;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;

import static java.lang.Thread.sleep;
import static java.time.Duration.ofMillis;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class _3_AssertionTest {

    /*
     * Write tests using some of the more advanced assertions:
     *
     *  - assertThrows
     *  - assertTimeout, assertTimeoutPreemptively
     *  - assertAll
     *
     * Tests can be failed manually with `fail`.
     */

    @Test
    void shouldThrowException() {
        assertThrows(RuntimeException.class, this::throwing);
    }

    @Test
    void shouldTimeout(){
        assertTimeout(Duration.ofMillis(3), () -> sleep(5));
    }

    @Test
    void shouldTimeoutAndBeKilled() {
        assertTimeoutPreemptively(ofMillis(1), () -> sleep(5), () -> "Killed within 1 ms.");
    }

    @Test
    void multipleFails(){
        assertAll(
                () -> assertThat(BigDecimal.ONE).isNull(),
                () -> assertThat(BigDecimal.ZERO).isNegative()
        );
    }

    private boolean truism() {
        return true;
    }

    private void throwing() throws Exception {
        throw new RuntimeException("Because I can!");
    }
}
