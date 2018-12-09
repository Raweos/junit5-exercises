package org.junit.junit5workshop._3_extensions;

import org.junit.junit5workshop.extensions.BenchmarkExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static java.lang.Thread.sleep;

@ExtendWith(BenchmarkExtension.class)
class _4_Benchmark {

	/*
	 * create another benchmark extension that implements the contract defined in
	 * src/main/java/org.junit.junit5workshop.extensions.BenchmarkExtension, including another
	 */

	@Test
	@ExtendWith(BenchmarkExtension.class)
	void benchmark1() throws InterruptedException {
		sleep(20);
	}

	@Test

	void benchmark2() throws InterruptedException {
		sleep(20);
	}

}
