package com.js.jsweixinoffice.common;
/**
 * @author xuhaooo
 * @date Date : 2021年05月15日 14:06
 * @version V1.0
 */

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *@description
 *通用消息类
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class CommonMsg {
    /*

     文字
    <xml>
      <ToUserName><![CDATA[toUser]]></ToUserName>
      <FromUserName><![CDATA[fromUser]]></FromUserName>
      <CreateTime>1348831860</CreateTime>
      <MsgType><![CDATA[text]]></MsgType>
      <Content><![CDATA[this is a test]]></Content>
      <MsgId>1234567890123456</MsgId>
    </xml>

    图片
    <xml>
      <ToUserName><![CDATA[toUser]]></ToUserName>
      <FromUserName><![CDATA[fromUser]]></FromUserName>
      <CreateTime>1348831860</CreateTime>
      <MsgType><![CDATA[image]]></MsgType>
      <PicUrl><![CDATA[this is a url]]></PicUrl>
      <MediaId><![CDATA[media_id]]></MediaId>
      <MsgId>1234567890123456</MsgId>
    </xml>

     */

    /**
    开发者微信号
     */
    @XmlElement(name = "ToUserName")
    private String toUserName;
    /**
发送方帐号（一个OpenID）
     */
    @XmlElement(name = "FromUserName")
    private String fromUserName;
    /**
消息创建时间 （整型）
     */
    @XmlElement(name = "CreateTime")
    private Integer createTime;
    /**
     消息类型，文本为text、图片为image
     */
    @XmlElement(name = "MsgType")
    private String msgType;

    @XmlElement(name = "MsgId")
    private Integer msgId;

    /**
文本消息内容
     */
    @XmlElement(name = "Content")
    private String content;

    /**
图片链接（由系统生成）
     */
    @XmlElement(name = "PicUrl")
    private String picUrl;
    /**
图片消息媒体id，可以调用获取临时素材接口拉取数据。
     */
    @XmlElement(name = "MediaId")
    private String mediaId;

}
