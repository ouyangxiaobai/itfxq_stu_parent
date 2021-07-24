package cn.itfxq.auth.config.exception;

import cn.itfxq.common.exception.BaseException;

/**
 * 描述：
 */
public class TokenException extends BaseException {

    private static final long serialVersionUID = 1L;

    public TokenException(String message) {
        super(message);
    }
}
