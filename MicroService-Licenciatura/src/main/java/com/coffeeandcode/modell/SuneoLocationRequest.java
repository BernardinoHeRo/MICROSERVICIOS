package com.coffeeandcode.modell;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SuneoLocationRequest {
	private LocationModell locationModell;
	private SuneoModell suneoModell;

	public SuneoLocationRequest() {
	}

	public SuneoLocationRequest(LocationModell locationModell, SuneoModell suneoModell) {
		this.locationModell = locationModell;
		this.suneoModell = suneoModell;
	}
}
