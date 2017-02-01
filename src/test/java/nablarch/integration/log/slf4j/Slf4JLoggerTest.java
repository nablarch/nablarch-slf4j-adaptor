package nablarch.integration.log.slf4j;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import nablarch.core.log.Logger;
import org.junit.Test;
import org.slf4j.impl.SimpleLogger;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * {@link Slf4JLogger}のテストクラス
 */
public class Slf4JLoggerTest {

    @Test
    public void isFatalEnabled(@Mocked final SimpleLogger mockLogger) throws Exception {

        new Expectations() {{
            mockLogger.isErrorEnabled();
            returns(false, true, true, false);
        }};

        final Logger sut = new Slf4JLoggerFactory().get("test");
        assertThat(sut.isFatalEnabled(), is(false));
        assertThat(sut.isFatalEnabled(), is(true));
        assertThat(sut.isFatalEnabled(), is(true));
        assertThat(sut.isFatalEnabled(), is(false));
    }

    @Test
    public void logFatal_messageAndOptions(@Mocked final SimpleLogger mockLogger) throws Exception {
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logFatal("fatal-{}:{}", "a", "b");

        new Verifications() {{
            mockLogger.error("fatal-{}:{}", new Object[] {"a", "b"});
        }};
    }

    @Test
    public void logFatal_messageAndThrowableAndOptions(@Mocked final SimpleLogger mockLogger) throws Exception {
        final IllegalArgumentException exception = new IllegalArgumentException("test");
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logFatal("fatal exception", exception, "a");

        new Verifications() {{
            mockLogger.error("fatal exception", new Object[] {"a", exception});
        }};
    }

    @Test
    public void isErrorEnabled(@Mocked final SimpleLogger mockLogger) throws Exception {
        new Expectations() {{
            mockLogger.isErrorEnabled();
            returns(false, true, true, false);
        }};

        final Logger sut = new Slf4JLoggerFactory().get("test");
        assertThat(sut.isErrorEnabled(), is(false));
        assertThat(sut.isErrorEnabled(), is(true));
        assertThat(sut.isErrorEnabled(), is(true));
        assertThat(sut.isErrorEnabled(), is(false));
    }

    @Test
    public void logError_messageAndOptions(@Mocked final SimpleLogger mockLogger) throws Exception {
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logError("error-{}:{}", "a", "b");

        new Verifications() {{
            mockLogger.error("error-{}:{}", new Object[] {"a", "b"});
        }};
    }

    @Test
    public void logError_messageAndThrowableAndOptions(@Mocked final SimpleLogger mockLogger) throws Exception {
        final IllegalArgumentException exception = new IllegalArgumentException("test");
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logError("error exception", exception, "a");

        new Verifications() {{
            mockLogger.error("error exception", new Object[] {"a", exception});
        }};
    }

    @Test
    public void isWarnEnabled(@Mocked final SimpleLogger mockLogger) throws Exception {
        new Expectations() {{
            mockLogger.isWarnEnabled();
            returns(false, true, true, false);
        }};

        final Logger sut = new Slf4JLoggerFactory().get("test");
        assertThat(sut.isWarnEnabled(), is(false));
        assertThat(sut.isWarnEnabled(), is(true));
        assertThat(sut.isWarnEnabled(), is(true));
        assertThat(sut.isWarnEnabled(), is(false));
    }

    @Test
    public void logWarn_messageAndOptions(@Mocked final SimpleLogger mockLogger) throws Exception {
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logWarn("warn-{}:{}", "a", "b");

        new Verifications() {{
            mockLogger.warn("warn-{}:{}", new Object[] {"a", "b"});
        }};
    }

    @Test
    public void logWarn_messageAndThrowableAndOptions(@Mocked final SimpleLogger mockLogger) throws Exception {
        final IllegalArgumentException exception = new IllegalArgumentException("test");
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logWarn("warn exception", exception, "a");

        new Verifications() {{
            mockLogger.warn("warn exception", new Object[] {"a", exception});
        }};
    }

    @Test
    public void isInfoEnabled(@Mocked final SimpleLogger mockLogger) throws Exception {
        new Expectations() {{
            mockLogger.isInfoEnabled();
            returns(false, true, true, false);
        }};

        final Logger sut = new Slf4JLoggerFactory().get("test");
        assertThat(sut.isInfoEnabled(), is(false));
        assertThat(sut.isInfoEnabled(), is(true));
        assertThat(sut.isInfoEnabled(), is(true));
        assertThat(sut.isInfoEnabled(), is(false));
    }

    @Test
    public void logInfo_messageAndOptions(@Mocked final SimpleLogger mockLogger) throws Exception {
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logInfo("info-{}:{}", "a", "b");

        new Verifications() {{
            mockLogger.info("info-{}:{}", new Object[] {"a", "b"});
        }};
    }

    @Test
    public void logInfo_messageAndThrowableAndOptions(@Mocked final SimpleLogger mockLogger) throws Exception {
        final IllegalArgumentException exception = new IllegalArgumentException("test");
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logInfo("info exception", exception, "a");

        new Verifications() {{
            mockLogger.info("info exception", new Object[] {"a", exception});
        }};
    }

    @Test
    public void isDebugEnabled(@Mocked final SimpleLogger mockLogger) throws Exception {
        new Expectations() {{
            mockLogger.isDebugEnabled();
            returns(false, true, true, false);
        }};

        final Logger sut = new Slf4JLoggerFactory().get("test");
        assertThat(sut.isDebugEnabled(), is(false));
        assertThat(sut.isDebugEnabled(), is(true));
        assertThat(sut.isDebugEnabled(), is(true));
        assertThat(sut.isDebugEnabled(), is(false));
    }

    @Test
    public void logDebug_messageAndOptions(@Mocked final SimpleLogger mockLogger) throws Exception {
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logDebug("debug-{}:{}", "a", "b");

        new Verifications() {{
            mockLogger.debug("debug-{}:{}", new Object[] {"a", "b"});
        }};
    }

    @Test
    public void logDebug_messageAndThrowableAndOptions(@Mocked final SimpleLogger mockLogger) throws Exception {
        final IllegalArgumentException exception = new IllegalArgumentException("test");
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logDebug("debug exception", exception, "a");

        new Verifications() {{
            mockLogger.debug("debug exception", new Object[] {"a", exception});
        }};
    }

    @Test
    public void isTraceEnabled(@Mocked final SimpleLogger mockLogger) throws Exception {
        new Expectations() {{
            mockLogger.isTraceEnabled();
            returns(false, true, true, false);
        }};

        final Logger sut = new Slf4JLoggerFactory().get("test");
        assertThat(sut.isTraceEnabled(), is(false));
        assertThat(sut.isTraceEnabled(), is(true));
        assertThat(sut.isTraceEnabled(), is(true));
        assertThat(sut.isTraceEnabled(), is(false));
    }

    @Test
    public void logTrace_messageAndOptions(@Mocked final SimpleLogger mockLogger) throws Exception {
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logTrace("trace-{}:{}", "a", "b");

        new Verifications() {{
            mockLogger.trace("trace-{}:{}", new Object[] {"a", "b"});
        }};
    }

    @Test
    public void logTrace_messageAndThrowableAndOptions(@Mocked final SimpleLogger mockLogger) throws Exception {
        final IllegalArgumentException exception = new IllegalArgumentException("test");
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logTrace("trace exception", exception, "a");

        new Verifications() {{
            mockLogger.trace("trace exception", new Object[] {"a", exception});
        }};
    }

    public static void main(String[] args) {
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "trace");

        final Logger logger = new Slf4JLoggerFactory().get("test");
        logger.logInfo("***** fatal *****");
        logger.logFatal("fatal-{}-{}", "a", "b");
        logger.logFatal("fatal-{}", new IllegalArgumentException("error"), "hoge");
        System.err.println("\n\n");

        logger.logInfo("***** error *****");
        logger.logError("error-{}-{}", "a", "b");
        logger.logError("error-{}", new IllegalArgumentException("error"), "hoge");
        System.err.println("\n\n");

        logger.logInfo("***** warn *****");
        logger.logWarn("warn-{}-{}", "a", "b");
        logger.logWarn("warn-{}", new IllegalArgumentException("error"), "hoge");
        System.err.println("\n\n");

        logger.logInfo("***** info *****");
        logger.logInfo("info-{}-{}", "a", "b");
        logger.logInfo("info-{}", new IllegalArgumentException("error"), "hoge");
        System.err.println("\n\n");

        logger.logInfo("***** debug *****");
        logger.logDebug("debug-{}-{}", "a", "b");
        logger.logDebug("debug-{}", new IllegalArgumentException("error"), "hoge");
        System.err.println("\n\n");

        logger.logInfo("***** trace *****");
        logger.logTrace("trace-{}-{}", "a", "b");
        logger.logTrace("trace-{}", new IllegalArgumentException("error"), "hoge");
    }
}