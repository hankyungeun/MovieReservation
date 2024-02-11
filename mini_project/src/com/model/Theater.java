package com.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Theater {
	private int theaterNum;
	private int seat;

	public Theater(int theaterNum, int seat) {
		this.theaterNum = theaterNum;
		this.seat = seat;
	}
}
