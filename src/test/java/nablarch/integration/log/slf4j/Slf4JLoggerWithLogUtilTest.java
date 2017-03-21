package nablarch.integration.log.slf4j;

import org.slf4j.impl.SimpleLogger;

import nablarch.core.log.app.FailureLogUtil;

import org.junit.Test;

import mockit.Mocked;
import mockit.Verifications;

public class Slf4JLoggerWithLogUtilTest {

    @Test
    public void fromFailureLogUtil(@Mocked final SimpleLogger mockLogger) throws Exception {
        FailureLogUtil.logFatal(new Object(), "failure.code");

        new Verifications() {{
            mockLogger.error("fail_code = [failure.code] 想定外のエラー", new Object[0]);
        }};
    }

    @Test
    public void fromFailureLogUtilWithThrowable(@Mocked final SimpleLogger mockLogger) throws Exception {
        final IllegalArgumentException exception = new IllegalArgumentException("ダメ");
        FailureLogUtil.logFatal(exception, new Object(), "failure.code");

        new Verifications() {{
            mockLogger.error("fail_code = [failure.code] 想定外のエラー", new Object[] {exception});
        }};
    }

    @Test
    public void fromFailureLogUtilWithMessageOptions(@Mocked final SimpleLogger mockLogger) throws Exception {
        FailureLogUtil.logFatal(new Object(), "failure.code2", "メッセージ");
        
        new Verifications() {{
            mockLogger.error("fail_code = [failure.code2] message->メッセージ", new Object[0]);
        }};
    }
    
    @Test
    public void fromFailureLogUtilWithLogOptions(@Mocked final SimpleLogger mockLogger) throws Exception {
        final IllegalArgumentException exception = new IllegalArgumentException("ng");
        FailureLogUtil.logFatal(exception, new Object(), "failure.code3", new Object[] {"message option"}, new Object[] {"log option"});

        new Verifications() {{
            mockLogger.error("fail_code = [failure.code3] message->message option-{}", new Object[] {"log option", exception});
        }};
    }
}

