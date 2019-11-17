package br.com.ies.candyShop.enums;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public enum FormatosDatas {
	BRASIL("dd/MM/yyyy");
	
	private String formatoData;
	
	
	private FormatosDatas(String formatoData) {
		this.formatoData = formatoData;
	}


	public String getFormatoData() {
		return formatoData;
	}


	public void setFormatoData(String formatoData) {
		this.formatoData = formatoData;
	}
	
	public static Date formatarStringToData(String data, FormatosDatas formatosDatas) {
		try {
			return new SimpleDateFormat(formatosDatas.getFormatoData()).parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String formatarDataToString(Date data, FormatosDatas formatosDatas) {
		return new SimpleDateFormat(formatosDatas.getFormatoData()).format(data);
	}
}
