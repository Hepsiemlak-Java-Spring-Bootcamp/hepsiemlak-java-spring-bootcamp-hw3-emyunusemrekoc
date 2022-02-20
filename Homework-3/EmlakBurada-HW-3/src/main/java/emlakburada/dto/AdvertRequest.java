package main.java.emlakburada.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data

public class AdvertRequest {

	private int userId;
	private String baslik;
	private BigDecimal fiyat;
	private int suresi;
	private boolean oneCikarilsinMi = false;
	private boolean incelendiMi = false;
	private boolean aktifMi;

}
