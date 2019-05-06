package com.jalor.others;

public class StringTest {

	public static void main(String[] args) {
		String str = "<p>222222222222222222</p><p>88888888888888888</p>";
		String rep = str.replaceAll("<p>", "").replaceAll("</p>", "\n");
		// System.out.println(rep);

		String deptRoleIds = "123—456—789—012—666—888";
		String[] sourceStrArray = deptRoleIds.split("—");
		for (int i = 0; i < sourceStrArray.length; i++) {
			int ii = sourceStrArray.length - 1;
			String st01 = "888";
			String st02 = sourceStrArray[i];
			// String st03 = sourceStrArray[ii];
			// System.out.println(st01 + "\t" + st02 + "\t" + st03);
			if (st01.equals(st02) && !st01.equals(sourceStrArray[ii])) {
				System.out.println("下一位审批角色是：" + String.valueOf(sourceStrArray[i + 1]));
			} else if (i == ii) {
				System.out.println("您就是最终审批人：" + sourceStrArray[ii]);
			}
		}

		String ancestors = "0,100,102,108";
		String[] deptidsArray = ancestors.split(",");
		for (int i = deptidsArray.length - 1; i >= 0; --i) { // 逆序输出
			System.out.print(deptidsArray[i] + " ");
		}

	}

}
