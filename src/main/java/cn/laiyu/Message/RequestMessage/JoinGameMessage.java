package cn.laiyu.Message.RequestMessage;

import cn.laiyu.Message.BaseMessage;

/**
 * Created by humac on 2017/7/4.
 */
public class JoinGameMessage extends BaseMessage {
    private Integer seatId;

    private String openId;

    public Integer getSeatId( ) {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public String getOpenId( ) {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
