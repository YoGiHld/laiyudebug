package cn.laiyu.Message.RequestMessage;

import cn.laiyu.Message.BaseMessage;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by humac on 2017/7/4.
 */
public class RestGameMessage extends BaseMessage{

   private String openId;

   public String getOpenId( ) {
      return openId;
   }

   public void setOpenId(String openId) {
      this.openId = openId;
   }
}
