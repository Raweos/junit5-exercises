package org.junit.junit5workshop._1_basics;

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

	private boolean truism() {
		return true;
	}

	private void throwing() throws Exception {
		throw new RuntimeException("Because I can!");
	}

}
