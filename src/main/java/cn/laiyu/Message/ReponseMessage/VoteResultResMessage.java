package cn.laiyu.Message.ReponseMessage;

import cn.laiyu.Message.BaseMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by humac on 2017/7/12.
 */
public class VoteResultResMessage extends BaseMessage{
    public ConcurrentHashMap<String,ArrayList<String>> voteResult=new ConcurrentHashMap<String,ArrayList<String>>();

    public CopyOnWriteArrayList<String> ticTag=new CopyOnWriteArrayList<String>();

    public String campiagnSeatId;
}
