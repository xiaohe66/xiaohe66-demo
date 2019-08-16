package com.xiaohe66.demo.poi.creator;

/**
 * @author xiaohe
 * @time 2019.08.14 16:17
 */
public class ExcelCreatorException extends RuntimeException{

    public ExcelCreatorException() {
    }

    public ExcelCreatorException(String message) {
        super(message);
    }

    public ExcelCreatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcelCreatorException(Throwable cause) {
        super(cause);
    }

    public ExcelCreatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
