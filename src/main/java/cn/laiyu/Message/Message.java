package cn.laiyu.Message;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by humac on 2017/7/1.
 */
public class Message {
    private String statusCode;

    public String getStatusCode( ) {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Message getBaseMessage( ) {
        return BaseMessage;
    }

    public void setBaseMessage(Message baseMessage) {
        BaseMessage = baseMessage;
    }

    private Message BaseMessage;
}
