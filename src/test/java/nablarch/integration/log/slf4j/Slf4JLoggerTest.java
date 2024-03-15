package nablarch.integration.log.slf4j;

import nablarch.core.log.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.slf4j.LoggerFactory;
import org.slf4j.simple.SimpleLogger;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * {@link Slf4JLogger}のテストクラス
 */
public class Slf4JLoggerTest {
    private final SimpleLogger mockLogger = mock(SimpleLogger.class);
    private MockedStatic<LoggerFactory> loggerFactoryMockStatic;

    @Before
    public void setUp() {
        loggerFactoryMockStatic = mockStatic(LoggerFactory.class);
        loggerFactoryMockStatic.when(() -> LoggerFactory.getLogger(anyString())).thenReturn(mockLogger);
    }

    @After
    public void tearDown() {
        loggerFactoryMockStatic.close();
    }

    @Test
    public void isFatalEnabled() throws Exception {
        when(mockLogger.isErrorEnabled()).thenReturn(false, true, true, false);
        
        final Logger sut = new Slf4JLoggerFactory().get("test");
        assertThat(sut.isFatalEnabled(), is(false));
        assertThat(sut.isFatalEnabled(), is(true));
        assertThat(sut.isFatalEnabled(), is(true));
        assertThat(sut.isFatalEnabled(), is(false));
    }

    @Test
    public void logFatal_messageAndOptions() throws Exception {
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logFatal("fatal-{}:{}", "a", "b");

        verify(mockLogger, atLeastOnce()).error("fatal-{}:{}", new Object[] {"a", "b"});
    }

    @Test
    public void logFatal_messageAndThrowableAndOptions() throws Exception {
        final IllegalArgumentException exception = new IllegalArgumentException("test");
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logFatal("fatal exception", exception, "a");

        verify(mockLogger, atLeastOnce()).error("fatal exception", new Object[] {"a", exception});
    }

    @Test
    public void isErrorEnabled() throws Exception {
        when(mockLogger.isErrorEnabled()).thenReturn(false, true, true, false);

        final Logger sut = new Slf4JLoggerFactory().get("test");
        assertThat(sut.isErrorEnabled(), is(false));
        assertThat(sut.isErrorEnabled(), is(true));
        assertThat(sut.isErrorEnabled(), is(true));
        assertThat(sut.isErrorEnabled(), is(false));
    }

    @Test
    public void logError_messageAndOptions() throws Exception {
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logError("error-{}:{}", "a", "b");

        verify(mockLogger, atLeastOnce()).error("error-{}:{}", new Object[] {"a", "b"});
    }

    @Test
    public void logError_messageAndThrowableAndOptions() throws Exception {
        final IllegalArgumentException exception = new IllegalArgumentException("test");
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logError("error exception", exception, "a");

        verify(mockLogger, atLeastOnce()).error("error exception", new Object[] {"a", exception});
    }

    @Test
    public void isWarnEnabled() throws Exception {
        when(mockLogger.isWarnEnabled()).thenReturn(false, true, true, false);

        final Logger sut = new Slf4JLoggerFactory().get("test");
        assertThat(sut.isWarnEnabled(), is(false));
        assertThat(sut.isWarnEnabled(), is(true));
        assertThat(sut.isWarnEnabled(), is(true));
        assertThat(sut.isWarnEnabled(), is(false));
    }

    @Test
    public void logWarn_messageAndOptions() throws Exception {
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logWarn("warn-{}:{}", "a", "b");

        verify(mockLogger, atLeastOnce()).warn("warn-{}:{}", new Object[] {"a", "b"});
    }

    @Test
    public void logWarn_messageAndThrowableAndOptions() throws Exception {
        final IllegalArgumentException exception = new IllegalArgumentException("test");
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logWarn("warn exception", exception, "a");

        verify(mockLogger, atLeastOnce()).warn("warn exception", new Object[] {"a", exception});
    }

    @Test
    public void isInfoEnabled() throws Exception {
        when(mockLogger.isInfoEnabled()).thenReturn(false, true, true, false);

        final Logger sut = new Slf4JLoggerFactory().get("test");
        assertThat(sut.isInfoEnabled(), is(false));
        assertThat(sut.isInfoEnabled(), is(true));
        assertThat(sut.isInfoEnabled(), is(true));
        assertThat(sut.isInfoEnabled(), is(false));
    }

    @Test
    public void logInfo_messageAndOptions() throws Exception {
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logInfo("info-{}:{}", "a", "b");

        verify(mockLogger, atLeastOnce()).info("info-{}:{}", new Object[] {"a", "b"});
    }

    @Test
    public void logInfo_messageAndThrowableAndOptions() throws Exception {
        final IllegalArgumentException exception = new IllegalArgumentException("test");
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logInfo("info exception", exception, "a");

        verify(mockLogger, atLeastOnce()).info("info exception", new Object[] {"a", exception});
    }

    @Test
    public void isDebugEnabled() throws Exception {
        when(mockLogger.isDebugEnabled()).thenReturn(false, true, true, false);

        final Logger sut = new Slf4JLoggerFactory().get("test");
        assertThat(sut.isDebugEnabled(), is(false));
        assertThat(sut.isDebugEnabled(), is(true));
        assertThat(sut.isDebugEnabled(), is(true));
        assertThat(sut.isDebugEnabled(), is(false));
    }

    @Test
    public void logDebug_messageAndOptions() throws Exception {
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logDebug("debug-{}:{}", "a", "b");

        verify(mockLogger, atLeastOnce()).debug("debug-{}:{}", new Object[] {"a", "b"});
    }

    @Test
    public void logDebug_messageAndThrowableAndOptions() throws Exception {
        final IllegalArgumentException exception = new IllegalArgumentException("test");
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logDebug("debug exception", exception, "a");

        verify(mockLogger, atLeastOnce()).debug("debug exception", new Object[] {"a", exception});
    }

    @Test
    public void isTraceEnabled() throws Exception {
        when(mockLogger.isTraceEnabled()).thenReturn(false, true, true, false);

        final Logger sut = new Slf4JLoggerFactory().get("test");
        assertThat(sut.isTraceEnabled(), is(false));
        assertThat(sut.isTraceEnabled(), is(true));
        assertThat(sut.isTraceEnabled(), is(true));
        assertThat(sut.isTraceEnabled(), is(false));
    }

    @Test
    public void logTrace_messageAndOptions() throws Exception {
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logTrace("trace-{}:{}", "a", "b");

        verify(mockLogger, atLeastOnce()).trace("trace-{}:{}", new Object[] {"a", "b"});
    }

    @Test
    public void logTrace_messageAndThrowableAndOptions() throws Exception {
        final IllegalArgumentException exception = new IllegalArgumentException("test");
        final Logger sut = new Slf4JLoggerFactory().get("test");
        sut.logTrace("trace exception", exception, "a");

        verify(mockLogger, atLeastOnce()).trace("trace exception", new Object[] {"a", exception});
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