package cn.laiyu.PoJo.Vote;

import cn.laiyu.PoJo.Room.Room;
import cn.laiyu.PoJo.User.Vote;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by humac on 2017/7/10.
 */
public class VoteSubject implements VoteThreame {
    private List<Integer> campaignObservers=new ArrayList<Integer>();

    private List<IObserver> voteObservers=new ArrayList<IObserver>();

    private Room myRoom;

    public VoteSubject(Room room){
        this.myRoom=room;
    }

    @Override
    public void addObservers(IObserver observer) {

    }

    @Override
    public void deleteObservers(IObserver observer) {

    }

    @Override
    public void notifyAllObservers(String msg) {

    }

    @Override
    public void addCampaignObservers(Integer seatId) {
        this.campaignObservers.add(seatId);
    }
}
