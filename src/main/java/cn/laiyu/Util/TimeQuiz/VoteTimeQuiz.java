package cn.laiyu.Util.TimeQuiz;

import cn.laiyu.Message.RequestMessage.VoteMessage;
import cn.laiyu.PoJo.Room.Room;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by humac on 2017/7/6.
 */
public class VoteTimeQuiz {
    private int limitSec=11;

    public static void TimeQuiz(int limitSec) throws InterruptedException{
        int sec=limitSec;
        while(sec>0){
            --sec;
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void processVoteResult(Room room){}
}
