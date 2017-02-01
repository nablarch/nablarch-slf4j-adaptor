package nablarch.integration.log.slf4j;

import nablarch.core.log.Logger;

import java.util.Arrays;

/**
 * SLF4Jを使用してログ出力を行うクラス。
 * <p/>
 * 全てのメソッドで{@link org.slf4j.Logger}に処理を委譲する。
 * <p/>
 * SLF4JにはFATALレベルが存在しないため、
 * FATALレベルでログ出力しようとした場合は全てERRORレベルで出力する。
 *
 * @author Naoki Yamamoto
 */
public class Slf4JLogger implements Logger {

    /** 委譲先ロガー */
    private final org.slf4j.Logger logger;

    /**
     * SLF4Jに処理を委譲するロガーを生成する。
     * @param logger 委譲先のロガー
     */
    public Slf4JLogger(final org.slf4j.Logger logger) {
        this.logger = logger;
    }

    /**
     * @see org.slf4j.Logger#isErrorEnabled()
     */
    @Override
    public boolean isFatalEnabled() {
        return logger.isErrorEnabled();
    }

    /**
     * @see org.slf4j.Logger#error(String, Object...)
     */
    @Override
    public void logFatal(String message, Object... options) {
        logger.error(message, options);
    }

    /**
     * @see org.slf4j.Logger#error(String, Object...)
     */
    @Override
    public void logFatal(String message, Throwable error, Object... options) {
        logger.error(message, getOptionsWithThrowable(error, options));
    }

    /**
     * @see org.slf4j.Logger#isErrorEnabled()
     */
    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    /**
     * @see org.slf4j.Logger#error(String, Object...)
     */
    @Override
    public void logError(String message, Object... options) {
        logger.error(message, options);
    }

    /**
     * @see org.slf4j.Logger#error(String, Object...)
     */
    @Override
    public void logError(String message, Throwable error, Object... options) {
        logger.error(message, getOptionsWithThrowable(error, options));
    }

    /**
     * @see org.slf4j.Logger#isWarnEnabled()
     */
    @Override
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    /**
     * @see org.slf4j.Logger#warn(String, Object...)
     */
    @Override
    public void logWarn(String message, Object... options) {
        logger.warn(message, options);
    }

    /**
     * @see org.slf4j.Logger#warn(String, Object...)
     */
    @Override
    public void logWarn(String message, Throwable error, Object... options) {
        logger.warn(message, getOptionsWithThrowable(error, options));
    }

    /**
     * @see org.slf4j.Logger#isInfoEnabled()
     */
    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    /**
     * @see org.slf4j.Logger#info(String, Object...)
     */
    @Override
    public void logInfo(String message, Object... options) {
        logger.info(message, options);
    }

    /**
     * @see org.slf4j.Logger#info(String, Object...)
     */
    @Override
    public void logInfo(String message, Throwable error, Object... options) {
        logger.info(message, getOptionsWithThrowable(error, options));
    }

    /**
     * @see org.slf4j.Logger#isDebugEnabled()
     */
    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    /**
     * @see org.slf4j.Logger#debug(String, Object...)
     */
    @Override
    public void logDebug(String message, Object... options) {
        logger.debug(message, options);
    }

    /**
     * @see org.slf4j.Logger#debug(String, Object...)
     */
    @Override
    public void logDebug(String message, Throwable error, Object... options) {
        logger.debug(message, getOptionsWithThrowable(error, options));
    }

    /**
     * @see org.slf4j.Logger#isTraceEnabled()
     */
    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    /**
     * @see org.slf4j.Logger#trace(String, Object...)
     */
    @Override
    public void logTrace(String message, Object... options) {
        logger.trace(message, options);
    }

    /**
     * @see org.slf4j.Logger#trace(String, Object...)
     */
    @Override
    public void logTrace(String message, Throwable error, Object... options) {
        logger.trace(message, getOptionsWithThrowable(error, options));
    }

    /**
     * オプション配列の末尾に例外クラスのオブジェクトを追加した配列を返す。
     *
     * @param throwable 例外クラスのオブジェクト
     * @param options オプション配列
     * @return 例外クラスのオブジェクトを追加したオプション配列
     */
    private Object[] getOptionsWithThrowable(final Throwable throwable, final Object[] options) {
        final Object[] array = Arrays.copyOf(options, options.length + 1);
        array[array.length - 1] = throwable;
        return array;
    }
}
