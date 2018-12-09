package org.junit.junit5workshop._3_extensions;

import org.junit.junit5workshop.extensions.SimpleBenchmarkExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static java.lang.Thread.sleep;

class _3_SimpleBenchmark {

	@Test
	@ExtendWith(SimpleBenchmarkExtension.class)
	void benchmark() throws InterruptedException {
		sleep(20);
	}

}
