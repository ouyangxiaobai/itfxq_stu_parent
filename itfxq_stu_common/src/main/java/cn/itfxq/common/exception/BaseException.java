package cn.itfxq.common.exception;

/**
 * 描述：
 * <p>
 */
public class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}

