package cn.laiyu.Util.ParamDetermine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by humac on 2017/6/26.
 */
public class UrlDetermine {
    private UrlDetermine( ) {
    }

    private static volatile UrlDetermine instance;

    public static UrlDetermine getInstance( ) {
        if (instance == null) {
            synchronized (UrlDetermine.class) {
                if (instance == null) {
                    instance = new UrlDetermine();
                }
            }
        }
        return instance;
    }

    public Map<String, Object> DetermineUrl(String decodeStr) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        String[] params = decodeStr.split("&");
        for (String param : params
                ) {
            String[] tempResult = param.split("=");
            hashMap.put(tempResult[0], tempResult[1]);
        }

        return hashMap;
    }

    public static void main(String[] args) {
        UrlDetermine urlDetermine = UrlDetermine.getInstance();
        // Map<String,String> hashMap=urlDetermine.DetermineUrl("userName=菜心&roomId=1004");
        //   Iterator<Map.Entry<String, String>> iter=hashMap.entrySet().iterator();
//        while(iter.hasNext()){
//            Map.Entry entry=(Map.Entry) iter.next();
//            System.out.println(entry);
//        }
    }
}
