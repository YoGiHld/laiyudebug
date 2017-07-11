package cn.laiyu.PoJo.Room;

/**
 * Created by humac on 2017/6/27.
 */
public class RoomDTO {
    private int id;

    private String openId;

    private int isAlive;

    public int getId( ) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenId( ) {
        return openId;
    }

    public void setUserName(String userName) {
        this.openId = userName;
    }

    public int getIsAlive( ) {
        return isAlive;
    }

    public void setIsAlive(int isAlive) {
        this.isAlive = isAlive;
    }
}
