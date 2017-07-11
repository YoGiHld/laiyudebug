package cn.laiyu.WebSocket;

import cn.laiyu.Message.BaseMessage;
import cn.laiyu.Message.Message;

import cn.laiyu.Message.ReponseMessage.ResponseCampiagnMessage;
import cn.laiyu.Message.RequestMessage.*;
import cn.laiyu.PoJo.Room.Room;
import cn.laiyu.PoJo.Vote.VoteSubject;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static cn.laiyu.WebSocket.RoomWebSocket.GameBroadCast;
import static cn.laiyu.WebSocket.RoomWebSocket.getHomeStructure;



/**
 * Created by humac on 2017/7/5.
 */
public class MessageHandler {
    public static void MessageControl(BaseMessage message,Room room) throws IOException, InterruptedException {
        System.out.println(message);
        String classType=message.getClass().toString();
        BaseMessage messageTemp=null;
        switch (message.statusCode){
            case "211" :
                MessageHandle((JoinGameMessage)message,room);
                break;
            case "212" :
                MessageHandle((RestGameMessage)message,room);
                break;
            case "113" :
                MessageHandle((BeginVoteMessage)message,room);
            case "114" :
                MessageHandle((JoinVoteMessage)message,room);
        }
    }
    public static void MessageHandle(BeginVoteMessage message, Room room) throws IOException, InterruptedException {
        int limitSec=5;
        //开启竞选模式

        GameBroadCast(room,JSONObject.toJSONString(message));
        while(limitSec > 0){
               --limitSec;
                System.out.println("remain sceconds:"+limitSec);
                TimeUnit.SECONDS.sleep(1);
        }
        ResponseCampiagnMessage responseC=new ResponseCampiagnMessage();
        responseC.statusCode="103";
        responseC.windowStant="1";
        GameBroadCast(room,JSONObject.toJSONString(responseC));
    }

    public static void MessageHandle(JoinVoteMessage message, Room room){
        room.voteSubject.addCampaignObservers(message.seatId);
    }

    private static void calculateVoteResult( ) {

    }

    public static void MessageHandle(JoinGameMessage message,Room room) throws IOException {
        room.joinGame(message.getSeatId(),message.getOpenId());
        String homeStructure = getHomeStructure(room);
        GameBroadCast(room,homeStructure);
    }
    public static void MessageHandle(RestGameMessage message,Room room) throws IOException {
        room.exitGame(message.getOpenId());
        String homeStructure = getHomeStructure(room);
        GameBroadCast(room,homeStructure);
    }
}
