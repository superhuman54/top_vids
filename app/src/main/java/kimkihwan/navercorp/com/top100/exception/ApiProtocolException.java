package kimkihwan.navercorp.com.top100.exception;

import android.annotation.SuppressLint;

/**
 * Created by jamie on 2017. 6. 12..
 */

public class ApiProtocolException extends Exception {
    private int mCode = 0;
    private String mMessage = "";

    public ApiProtocolException(int code, String msg) {
        mCode = code;
        mMessage = msg;
    }

    public ApiProtocolException(String msg) {
        mMessage = msg;
    }

    public ApiProtocolException(String detailMessage, Throwable t) {
        super(detailMessage, t);
    }

    public ApiProtocolException(Throwable t) {
        super(t);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public String getMessage() {
        if (mCode != 0) {
            String result = String.format("ApiProtocolErrorException API Failed. code : [%d], msg : [%s]", mCode,
                    mMessage);
            return result;
        } else {
            return mMessage;
        }
    }
}
