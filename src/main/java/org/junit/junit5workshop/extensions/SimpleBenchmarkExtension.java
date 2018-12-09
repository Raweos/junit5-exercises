package org.junit.junit5workshop.extensions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class SimpleBenchmarkExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

	@Override
	public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
		Long now = System.nanoTime();
		Long runTime = extensionContext.getStore(ExtensionContext.Namespace.GLOBAL).get("runTime", Long.class);
		System.out.println(extensionContext.getDisplayName() + " run time is: " + (now-runTime)/1000000 + "ms");
	}

	@Override
	public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
		extensionContext.getStore(ExtensionContext.Namespace.GLOBAL).put("runTime", System.nanoTime());
	}

	/*
	 * Write a simple benchmark that prints the runtime in ms to the console.
	 *
	 * Tips:
	 *  - start by extending BeforeTestExecutionCallback and AfterTestExecutionCallback
	 *  - remember, extensions should be stateless
	 */

}
