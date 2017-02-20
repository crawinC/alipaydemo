package cn.crawin.config;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.util.DateUtil;
import org.apache.log4j.Logger;

import com.alipay.api.internal.util.AlipaySignature;

import net.sf.json.JSONObject;

public class AlipayOrderInfo {
	
	private static Logger log = Logger.getLogger( AlipayOrderInfo.class );
	
	/**
	 * 将请求参数签名并将组成参数串
	 * @param bizContent
	 * @return
	 */
	public static String createOrderInfo(String bizContent){
		log.info(String.format("Start to begin AlipayOrderInfo#createOrderInfo,bizContent[%s]", bizContent));
		
		try {
			Map<String,String> map = getAlipayParams();
			map.put("biz_content", bizContent);
		
			// 进行签名
			String rsaSign = AlipaySignature.rsaSign(map, AlipayConfig.private_key, AlipayConfig.input_charset);
			map.put("sign", rsaSign);
			
			// 将一级key的value值进行编码
			Map<String, String> order = getEncodeOrderInfo(map);
			
			// 将参数连接起来
			String orderInfo = AlipaySignature.getSignContent(order);
			
			return orderInfo;
		} catch (UnsupportedEncodingException e) {
			log.error("========>>>  AlipayOrderInfo#createOrderInfo:编码参数时出现错误");
			e.printStackTrace();
		}catch (Exception e) {
			log.error("========>>>  AlipayOrderInfo#createOrderInfo:签名时出现错误");
			e.printStackTrace();
		} 
		return null;
	}

	/**
	 * 将一级key对应的value值进行编码
	 * @param map
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private static Map<String,String> getEncodeOrderInfo(Map<String, String> map) throws UnsupportedEncodingException {
		
		for (String key : map.keySet()) {
			map.put(key, URLEncoder.encode(map.get(key), AlipayConfig.input_charset));
		}
		
		return map;
	}

	/**
	 * app支付所需参数
	 * @return
	 */
	public static Map<String,String> getAlipayParams(){
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("app_id", AlipayConfig.seller_user_id);
		map.put("charset", AlipayConfig.input_charset);
		map.put("method", AlipayConfig.app_pay_method);
		map.put("sign_type", AlipayConfig.sign_type);
		map.put("timestamp", DateUtil.formatDate(new Date(), "yyyy-MM-dd hh:mm:ss"));
		map.put("version", "1.0");
		
		return map;
	}
	
	public static void main(String[] args) {
    	
		try {
			JSONObject json = new JSONObject();
			json.put("timeout_express", "30m");
			json.put("product_code", "QUICK_MSECURITY_PAY");
			json.put("total_amount", String.valueOf(0.01f));
			json.put("subject", "测试数据");
			json.put("out_trade_no", "9829348203984");
			
			String link = createOrderInfo(json.toString());
			
			System.out.println( link );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
