package cn.laiyu.Util.TimeQuiz;

import cn.laiyu.Message.ReponseMessage.VoteResultResMessage;
import cn.laiyu.PoJo.Room.Room;
import cn.laiyu.PoJo.Seat.SeatState;
import cn.laiyu.PoJo.User.Vote;
import cn.laiyu.PoJo.Vote.VoteObserver;
import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

import static cn.laiyu.WebSocket.RoomWebSocket.GameBroadCast;

/**
 * Created by humac on 2017/7/11.
 */
public class CampiagnVoteQuiz implements Runnable{
    private int limitSec ;

    private Room  room;

    public ConcurrentHashMap<String,ArrayList<String>> voteResult=new ConcurrentHashMap<String,ArrayList<String>>();

    public CampiagnVoteQuiz(int limitSec,Room room){
        this.limitSec=limitSec;
        this.room=room;
    }
    @Override
    public void run( ) {
        while(limitSec > 0){
            --limitSec;
            System.out.println("vote remain sceconds:"+limitSec);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        List list=room.voteSubject.getVoteObservers();

        for (int i=0;i<list.size();i++){
           VoteObserver voteObserver=(VoteObserver)(list.get(i));
           ArrayList<String> tempArr=voteResult.get(voteObserver.tagetSeatId);
           if(tempArr==null){
               System.out.println("null login!!!!");
               tempArr=new ArrayList<String>();
               tempArr.add(String.valueOf(voteObserver.mySeatId));
               voteResult.put(voteObserver.tagetSeatId+"",tempArr);

           }else{
               System.out.println("not null!!!!");
               voteResult.get(voteObserver.tagetSeatId).add(String.valueOf(voteObserver.mySeatId));
           }

        }

        Iterator<Map.Entry<String,ArrayList<String>>> it = voteResult.entrySet().iterator();
        int flag=0;
        while(it.hasNext()){

            Map.Entry entry = (Map.Entry) it.next();
            if(entry.getKey()!=null){
            List temp=(List)entry.getValue();
            int size =temp.size();
            if(size>flag){
                flag=size;
                }
            }
        }
        Iterator<Map.Entry<String,ArrayList<String>>> it1 = voteResult.entrySet().iterator();

        CopyOnWriteArrayList<String> plaTic=new CopyOnWriteArrayList<String>();
        while(it1.hasNext()){
            Map.Entry entry = (Map.Entry) it1.next();
            List temp=(List)entry.getValue();
            int size =temp.size();
            if(size==flag){
                plaTic.add(""+entry.getKey());
            }else {
                room.voteSubject.getCampaignObservers().remove(entry.getKey());
            }
        }
        VoteResultResMessage voteResultResMessage=new VoteResultResMessage();
        voteResultResMessage.ticTag=plaTic;
        voteResultResMessage.voteResult=voteResult;
        voteResultResMessage.statusCode="105";

        System.out.println(room.voteSubject.getCampaignObservers().size());
        if(room.voteSubject.getCampaignObservers().size()==1){
            System.out.println("okokJiaRuWoDeHangLie"+room.voteSubject.getCampaignObservers().get(0));
            voteResultResMessage.campiagnSeatId=room.voteSubject.getCampaignObservers().get(0)+"";
            room.campiagnSeatId=room.voteSubject.getCampaignObservers().get(0);
            this.room.voteSubject.getCampaignObservers().clear();
        }
        String message= JSON.toJSONString(voteResultResMessage);
        try {
            GameBroadCast(room, message);
            System.out.println(room.campiagnSeatId);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static  void main(String args[]) {
        ConcurrentHashMap<String, ArrayList<String>> voteResult = new ConcurrentHashMap<String, ArrayList<String>>();
        System.out.println(voteResult.get("1"));
        ArrayList<String> tempArr = voteResult.get("1");
        if (tempArr==null) {
            tempArr=new ArrayList<String>();
            tempArr.add("2");
            voteResult.put("1",tempArr);
            System.out.println(voteResult.get("1"));
        }
    }
}
