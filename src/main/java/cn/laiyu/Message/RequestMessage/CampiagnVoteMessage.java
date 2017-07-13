package cn.laiyu.Message.RequestMessage;

import cn.laiyu.Message.BaseMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by humac on 2017/7/6.
 */
public class CampiagnVoteMessage extends BaseMessage {
   private Integer seatId;

   private Integer targetId;

   public Integer getSeatId( ) {
      return seatId;
   }

   public void setSeatId(Integer seatId) {
      this.seatId = seatId;
   }

   public Integer getTargetId( ) {
      return targetId;
   }

   public void setTargetId(Integer targetId) {
      this.targetId = targetId;
   }
}
