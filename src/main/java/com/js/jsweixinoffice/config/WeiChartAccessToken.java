package com.js.jsweixinoffice.config;
/**
 * @author xuhaooo
 * @date Date : 2021年05月15日 15:02
 * @version V1.0
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.js.jsweixinoffice.util.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 *@description
 *微信AccessToken获取公用类
 */
@Slf4j
@Component
public class WeiChartAccessToken {

    private String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    @CreateCache(name = "token_cache", expire = 3600, cacheType = CacheType.REMOTE)
    private Cache<String,String> tokenCache;

    public String getToken(){
        String key = "accessToken";

        String tokenCache = this.tokenCache.get(key);
        if(StringUtils.isEmpty(tokenCache)){
            //缓存中没有token，重新获取并放入缓存
            String data = HttpClientUtils.doGet(url, null);
            JSONObject jsonObject = JSONObject.parseObject(data);

            Object access_token = jsonObject.get("access_token");
            if(access_token != null){
                String token = access_token.toString();

                //缓存最新的token
                this.tokenCache.put(key,token);

                return token;
            }else{
                log.error("微信AccessToken获取失败："+data);
            }
        }else{
            return tokenCache;
        }

        return null;
    }

}
