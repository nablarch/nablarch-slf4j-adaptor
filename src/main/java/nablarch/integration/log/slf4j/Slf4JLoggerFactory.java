package nablarch.integration.log.slf4j;

import nablarch.core.log.LogSettings;
import nablarch.core.log.Logger;
import nablarch.core.log.LoggerFactory;

/**
 * {@link Slf4JLogger}を生成するクラス。
 *
 * @author Naoki Yamamoto
 */
public class Slf4JLoggerFactory implements LoggerFactory {

    /**
     * この実装では何もしない
     */
    @Override
    public void initialize(LogSettings settings) {
        // NOP
    }

    /**
     * この実装では何もしない
     */
    @Override
    public void terminate() {
        // NOP
    }

    @Override
    public Logger get(String name) {
        return new Slf4JLogger(org.slf4j.LoggerFactory.getLogger(name));
    }
}
