package com.jalor.prize;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author liubo
 * @Date 2018/12/20 12:23
 * @Description: TODO
 */
public class test {

	/**
	 * 给转盘的每个角度赋初始值
	 *
	 * @return
	 */
	private final static List<prize> initDrawList = new ArrayList<prize>() {
		{
			add(new prize(1, "谢谢参与", 40));
			add(new prize(2, "虚拟红包10元", 10));
			add(new prize(3, "虚拟红包20元", 16));
			add(new prize(4, "加息券0.5%", 15));
			add(new prize(5, "京东购物卡", 10));
			add(new prize(6, "金士顿（Kingston）128GB U盘", 5));
			add(new prize(7, "格兰仕（Galanz）G80F23CN3L-C2K(G2)微波炉/光波炉/烤箱一体机", 3));
			add(new prize(9, "科沃斯（Ecovacs）扫地机器人", 1));
		}
	};

	/**
	 * 生成奖项
	 *
	 * @return
	 */
	public static prize generateAward() {
		List<prize> initData = initDrawList;
		long result = randomnum(1, 100);
		int line = 0;
		int temp = 0;
		prize returnobj = null;
		for (int i = 0; i < initDrawList.size(); i++) {
			prize obj2 = initDrawList.get(i);
			int c = obj2.getV();
			temp = temp + c;
			line = 100 - temp;
			if (c != 0) {
				if (result > line && result <= (line + c)) {
					returnobj = obj2;
					// 如果大于库存就从新抽奖
					// if(returnobj.getId()==20){
					// continue;
					// }
					break;
				}
			}
		}
		return returnobj;
	}

	// 获取2个值之间的随机数
	private static long randomnum(int smin, int smax) {
		int range = smax - smin;
		double rand = Math.random();
		return (smin + Math.round(rand * range));
	}

	public static void main(String[] args) {

		prize p = generateAward();
		System.out.println(p.getPrize() + new SimpleDateFormat("yyyyMMdd").format(new Date()));
	}
}
