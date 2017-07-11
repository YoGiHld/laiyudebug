package cn.laiyu.PoJo.Vote;

/**
 * Created by humac on 2017/7/10.
 */
public interface VoteThreame {
    public void addObservers(IObserver observer);

    public void deleteObservers(IObserver observer);

    public void notifyAllObservers(String msg);

    public void addCampaignObservers(Integer seatId);
}
