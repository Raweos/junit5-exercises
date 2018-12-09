package org.junit.junit5workshop._1_basics;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class _4_AssumptionTest {

    /*
     * Write tests that use assumptions to make sure
     * tests are only executed when preconditions are fulfilled.
     *
     *  - assumeTrue
     *  - assumeFalse
     */

    @Test
    void checkBeforeNoon() {
        assumeTrue(LocalDateTime.now().getHour() < 12);
        assertThat(messageBeforeNoon()).isNotEmpty();
    }

    @Test
    void checkAfterNoon(){
        assumeFalse(LocalDateTime.now().getHour() < 12);
        assertThat(messageAfterNoon()).isNotEmpty();
    }

    private String messageBeforeNoon() {
        if (LocalDateTime.now().getHour() < 12)
            return "Good Morning";
        else
            throw new IllegalStateException();
    }

    private String messageAfterNoon() {
        if (LocalDateTime.now().getHour() > 12)
            return "Good Evening";
        else
            throw new IllegalStateException();
    }

}
