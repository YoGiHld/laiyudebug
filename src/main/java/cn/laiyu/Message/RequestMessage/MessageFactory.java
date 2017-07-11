package cn.laiyu.Message.RequestMessage;

import cn.laiyu.Message.BaseMessage;

/**
 * Created by humac on 2017/7/4.
 */
public class MessageFactory {
    public static BaseMessage getInstance(String className){
        BaseMessage message=null;
        try{
            message =(BaseMessage) Class.forName(className).newInstance();
        }catch (Exception e){
            System.out.println(className);
            e.printStackTrace();
        }
        return message;
    }
}
