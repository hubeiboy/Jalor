package com.jalor.msgProUTF8;

import java.util.HashMap;
import java.util.Map;

/**  
 * @Title: http://www.smschinese.cn/api.shtml
 * @date 2011-3-22
 * @version V1.2  
 */
public class test {
	
	//用户名
	private static String Uid = "lenian";
	
	//接口安全秘钥
	private static String Key = "d41d8cd98f00b204e980";
	
	//手机号码，多个号码如13800000000,13800000001,13800000002
	private static String smsMob = "13021102332";
	
	private static String smsText1 = "旅客同志们请注意了，由美丽间和众国开往啊幅汗的3838438次列车马上就要出发了，"
			+ "请没有上车的旅客拿好别人的行李，带上别人的老婆抓紧时间上车。有携带雷`管、炸`药、导`火`索及易`燃易爆`品的旅客，"
			+ "请您抓紧时间上车，在人多的地方点燃，为我国计`划生育工作多做贡献。列车在高速行驶时，请将您的头和手尽量的伸出窗外，"
			+ "以便于一次性解决。本次列车是文明列车，您的大小便、瓜果皮屑可以在车厢内通道中随意抛洒。他的痰可以吐在您的脸上，"
			+ "你的痰可以吐在他的嘴里，这样有便于蛋白质的充分吸收。本次列车还为第三`者插`足提供方便，为婚`外恋牵线搭桥，"
			+ "并迅速办理好离婚手续，使您的家庭彻底破裂。本次列车作为报废车，又安全行驶了30年，由于没有车闸，"
			+ "必须与其他物体相撞才能停车。如果您发现您的头在您的脚上，那就到了终点站--天`堂。列车司机滕路净二祝旅客一路平安、"
			+ "旅途愉快。祝工作顺利，生活愉快！";
	
	private static String smsText2 = "小车正穿行在落基山脉蜿蜒曲折的盘山公路上。克里斯朵夫·李维静静地望着窗外，"
			+ "发现每当车子即将行驶到无路的关头，路边都会出现一块交通指示牌：“前方转弯！”或“注意！急转弯”。而拐过每一道弯之后，"
			+ "前方照例又是一片柳暗花明、豁然开朗。山路弯弯、峰回路转，“前方转弯”几个大字一次次地冲击着他的眼球，"
			+ "也渐渐叩开了他的心扉：原来，不是路已到了尽头，而是该转弯了。路在脚下，更在心中，心随路转，心路常宽。"
			+ "学会转弯也是人生的智慧，因为挫折往往是转折，危机同时是转机。";
	
	//短信内容//%0A表示短信换行
	private static String smsText = "紧急通知：全体员工立刻下班！";
	
	
	public static void main(String[] args) {
		
		HttpClientUtil client = HttpClientUtil.getInstance();
		
		//UTF发送
		int result = client.sendMsgUtf8(Uid, Key, smsText, smsMob);
		if(result>0){
			System.out.println("UTF8成功发送条数=="+result);
		}else{
			System.out.println(client.getErrorMsg(result));
		}
	}
}
