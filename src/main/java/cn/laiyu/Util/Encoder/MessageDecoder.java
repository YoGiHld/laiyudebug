package cn.laiyu.Util.Encoder;

import cn.laiyu.Message.BaseMessage;
import cn.laiyu.Message.Message;

import cn.laiyu.Message.RequestMessage.BeginVoteMessage;
import cn.laiyu.Message.RequestMessage.JoinGameMessage;
import cn.laiyu.Message.RequestMessage.RestGameMessage;
import com.alibaba.fastjson.JSON;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;



/**
 * Created by humac on 2017/7/1.
 */
public class MessageDecoder implements Decoder.Text<BaseMessage> {

    @Override
    public BaseMessage decode(String s) throws DecodeException {
        System.out.println(s);
        Message message=JSON.parseObject(s,Message.class);
        BaseMessage baseMessage=new BaseMessage();
        String statusCode=message.getStatusCode();
        switch (statusCode){
            case "211" :
                baseMessage=new JoinGameMessage();
                break;
            case "212" :
                baseMessage=new RestGameMessage();
                break;
            case "113" :
                baseMessage=new BeginVoteMessage();
                break;
        }
        baseMessage= JSON.parseObject(s,baseMessage.getClass());
        return baseMessage;
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy( ) {

    }
}
