package com.jalor.prize;

/**
 * @Author liubo
 * @Date 2018/12/20 12:24
 * @Description: TODO
 */
public class prize {
	private Integer id;
	private String prize;
	// 涓鐜�
	private Integer v;

	public prize(Integer id, String prize, Integer v) {
		this.id = id;
		this.prize = prize;
		this.v = v;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public Integer getV() {
		return v;
	}

	public void setV(Integer v) {
		this.v = v;
	}
}
