package cn.crawin.config;
/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.4
 *修改日期：2016-03-08
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
	// 2016120303801456    2088521386712296
	public static String partner = "2016120303801456";
	
	// 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
	public static String seller_user_id = partner;

	// 商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
	public static String private_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKjDJbRHJYqRiNeuTHcdrdbZf42mhZKSqR26KcPMo6YpNN/j6LE5Grl86KW52+d9CAY49Layf31SfqUyvGfDNz7jKZtPZR1K3/Xx8GBpOPE95q2UdIusP885JG8DsaYBdITMUgkcHRBY+yolE3XiD71+VJ3gKeuOWiFTmwUPY1jPAgMBAAECgYActu+gaAakODUPdbG/BsbAasuAP5g0o02xKC7ZCOXDbPl5Kt854FyCuRUgtaoMDkMiQ+ineWGl4jZ4R1S1Vwr8Gob/AI7W8ZmefKj1GfByPc6YZ9opkuJXAZpDWgwVSihEnBqBFIMYH3tzjVjmTvJy7nLaKIqNCQ3LBfULiSjYOQJBANbujVVyuJX7apI4PulmdYgbYXMlMuIjVuYkJ3AvHVhqSecEzIZXxgFMuc7+6vNet+da5IHsGKp/51wWi32IAuUCQQDJAjMQJoS+zClWr81/+GevcEnkmNjkSOsdC2pCC+GdjGHG/r2PdA1I+bFnFNlb6AIOf2RkoWCphWtatzMndm2jAkEAsgsg1wTWdZ+0U3X2X3/5oosT+b953CxsIu8WIG9W/tPlblLiXfM92fvF+/vdg0cWTrdTjXCXqj2T2Qvv90gBJQJAFJucHpjEXUdTKacGe4s9Hhh2CvC8s9Lh/+1OrIzJSby9vYgaaR2tywCGdpoFms2TgGcBJOwCm/6ovfkwTmhu3wJAdlrVaoSoLmksxO3PWunqDcmyAPKMNIhjzVX4uWINCFqrrLZZkL02PawCLcdJgQGVVmEthZ9DAdDNv509zNXnJA==";
	/*public static String private_key = "1mtvr2ttrv8avd3ipcoelfxc91kf0w5y";*/
	
	// 支付宝公钥,查看地址：https://b.alipay.com/order/pidAndKey.htm 
	public static String alipay_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://139.224.221.143:8080/qsvc-front/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://139.224.221.143:8080/qsvc-front/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA";
	
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path = "D:\\";
		
	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// 提供给客户端的支付宝签名参数
	public static String app_pay_method = "alipay.trade.app.pay";
		
	// 调用的接口名，无需修改
	public static String service = "refund_fastpay_by_platform_pwd";


}

