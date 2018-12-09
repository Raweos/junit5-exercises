package org.junit.junit5workshop.extensions;

import org.junit.jupiter.api.extension.*;

import java.lang.reflect.AnnotatedElement;
import java.util.Optional;

import static java.util.Objects.isNull;

public class BenchmarkExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback, BeforeAllCallback, AfterAllCallback {
    private static String methodTimeKey = "methodTime";
    private static String allMethodTimeKey = "allMethodTime";

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        Long now = System.nanoTime();
        if (isAtMethod(extensionContext)) {
            extensionContext.getStore(ExtensionContext.Namespace.GLOBAL)
                    .put(methodTimeKey, now);
        }
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        Long now = System.nanoTime();
        if (isAtMethod(extensionContext)) {
            Long methodTime = extensionContext.getStore(ExtensionContext.Namespace.GLOBAL)
                    .get(methodTimeKey, Long.class);
            System.out.println(extensionContext.getDisplayName() + "exec time: " + (now - methodTime) / 1000000 + "ms");
        }
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        Long now = System.nanoTime();
        extensionContext.getStore(ExtensionContext.Namespace.GLOBAL)
                .put(allMethodTimeKey, now);
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        Long now = System.nanoTime();
        Long allMethodTime = extensionContext.getStore(ExtensionContext.Namespace.GLOBAL)
                .get(allMethodTimeKey, Long.class);
        System.out.println("Full exec time: " + (now - allMethodTime) / 1000000 + "ms");
    }

    private boolean isAtMethod(ExtensionContext extensionContext) {
        Optional<AnnotatedElement> element = extensionContext.getElement();
        if (element.isPresent()) {
            ExtendWith annotation = element.get().getAnnotation(ExtendWith.class);
            return !isNull(annotation) && annotation.value()[0].isAssignableFrom(BenchmarkExtension.class);
        } else {
            return false;
        }
    }

    /*
     * Requirements:
     *  - if applied to a test, it will report the run time of the individual
     *    test.
     *  - if applied to a class, it will report cumulative run time
     *    of all test
     *
     * Tips:
     *  - extend BeforeAllCallback, BeforeTestExecutionCallback,
     *           AfterTestExecutionCallback, AfterAllCallback
     *  - stateless
     *  - use context and reflection to see whether class/method is annotated
     */

}
