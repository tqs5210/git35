/**
 * @filename AlipayBankNoCheck.java
 * @author lg
 * @date 2017年10月27日 上午11:26:35
 * @version 1.0
 * Copyright (C) 2017 
 */

package com.util;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.util.HttpUtils;

public class AlipayBankNoCheck {

	public static void main(String[] args) {
	    String host = "https://yunyidata.market.alicloudapi.com";
	    String path = "/bankAuthenticate4";
	    String method = "POST";
	    String appcode = "你的appcode";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    //根据API的要求，定义相对应的Content-Type
	    headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
	    Map<String, String> querys = new HashMap<String, String>();
	    Map<String, String> bodys = new HashMap<String, String>();
	    bodys.put("cardNo", "621555888555222669");
	    bodys.put("idNo", "3404251111122222255555");
	    bodys.put("name", "张三");
	    bodys.put("phoneNo", "13355558888");
	    
	    try {
	    	/**
	    	* 重要提示如下:
	    	* HttpUtils请从
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* 下载
	    	*
	    	* 相应的依赖请参照
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
	    	System.out.println(response.toString());
	    	//获取response的body
	    	System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	
}
