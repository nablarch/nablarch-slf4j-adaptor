package nablarch.integration.log.slf4j;

import nablarch.core.log.app.FailureLogUtil;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.SimpleLogger;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;

public class Slf4JLoggerWithLogUtilTest {

    private static MockedStatic<LoggerFactory> mocked;
    private static final SimpleLogger mockLogger = mock(SimpleLogger.class);

    @BeforeClass
    public static void beforeClass() {
        mocked = Mockito.mockStatic(LoggerFactory.class);
        mocked.when(() -> LoggerFactory.getLogger(anyString())).thenReturn(mockLogger);
    }

    @Before
    public void setUp() {
        reset(mockLogger);
    }

    @AfterClass
    public static void afterClass() {
        mocked.close();
    }

    @Test
    public void fromFailureLogUtil() throws Exception {
        FailureLogUtil.logFatal(new Object(), "failure.code");

        verify(mockLogger, atLeastOnce()).error("fail_code = [failure.code] 想定外のエラー", new Object[0]);
    }

    @Test
    public void fromFailureLogUtilWithThrowable() throws Exception {
        final IllegalArgumentException exception = new IllegalArgumentException("ダメ");
        FailureLogUtil.logFatal(exception, new Object(), "failure.code");

        verify(mockLogger, atLeastOnce()).error("fail_code = [failure.code] 想定外のエラー", new Object[] {exception});
    }

    @Test
    public void fromFailureLogUtilWithMessageOptions() throws Exception {
        FailureLogUtil.logFatal(new Object(), "failure.code2", "メッセージ");

        verify(mockLogger, atLeastOnce()).error("fail_code = [failure.code2] message->メッセージ", new Object[0]);
    }
    
    @Test
    public void fromFailureLogUtilWithLogOptions() throws Exception {
        final IllegalArgumentException exception = new IllegalArgumentException("ng");
        FailureLogUtil.logFatal(exception, new Object(), "failure.code3", new Object[] {"message option"}, new Object[] {"log option"});

        verify(mockLogger, atLeastOnce()).error("fail_code = [failure.code3] message->message option-{}", new Object[] {"log option", exception});
    }
}

