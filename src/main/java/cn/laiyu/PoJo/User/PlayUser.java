package cn.laiyu.PoJo.User;

/**
 * Created by humac on 2017/6/26.
 */
public class PlayUser extends User implements Vote {
    private int seatId;

    public PlayUser(int seatId, User user) {
        this.seatId = seatId;
        this.setImagePath(user.getImagePath());
        this.setNickName(user.getNickName());
        this.setOpenId(user.getOpenId());
    }

    @Override
    public void vote( ) {

    }
}
