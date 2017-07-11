package cn.laiyu.PoJo.Seat;

import cn.laiyu.PoJo.User.PlayUser;

/**
 * Created by humac on 2017/6/28.
 */
public class SeatState {
    public PlayUser playUser;

    public int seatState;

    @Override
    public String toString(){
        return "playUser:"+playUser.getOpenId()+"     seateState:"+seatState;
    }
}
