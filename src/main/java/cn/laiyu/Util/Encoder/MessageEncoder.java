package cn.laiyu.Util.Encoder;

import cn.laiyu.Message.Message;
import com.alibaba.fastjson.JSON;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * Created by humac on 2017/7/1.
 */
public class MessageEncoder implements Encoder.Text<Message> {
    @Override
    public String encode(Message object) throws EncodeException {
        return JSON.toJSONString(object);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        System.out.println("MessageEncoder - init method called");
    }

    @Override
    public void destroy( ) {
        System.out.println("MessageEncoder - destory method called");
    }
}
