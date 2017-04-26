package com.xxx.opensys.test;

public enum Enum1 {

	RED,
	YELLOW,
	GREEN;
	
	private int time;

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	private Enum1() {
	}

	private Enum1(int time) {
		this.time = time;
	}
	
}
