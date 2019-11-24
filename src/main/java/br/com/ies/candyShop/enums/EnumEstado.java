package br.com.ies.candyShop.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;


public enum EnumEstado {
	
		AC("Acre"),
		AL("Alagoas"),
		AP("Amapá"),
		AM("Amazonas"),
		BA("Bahia"),
		CE("Ceará"),
		DF("Distrito Federal"),
		ES("Espírito Santo"),
		GO("Goiás"),
		MA("Maranhão"),
		MT("Mato Grosso"),
		MS("Mato Grosso do Sul"),
		MG("Minas Gerais"),
		PA("Pará"),
		PB("Paraíba"),
		PR("Paraná"),
		PE("Pernambuco"),
		PI("Piauí"),
		RJ("Rio de Janeiro"),
		RN("Rio Grande do Norte"),
		RS("Rio Grande do Sul"),
		RO("Rondônia"),
		RR("Roraima"),
		SC("Santa Catarina"),
		SP("São Paulo"),
		SE("Sergipe"),
		TO("Tocantins");
		
		
		private String estado;
		
		private EnumEstado(String estado) {
			this.estado = estado;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}
		
		public static List<String> getListSiglaEstados(){
			List<String> siglasEstados = new ArrayList<>();
			for(EnumEstado estado : EnumSet.allOf(EnumEstado.class)) {
				siglasEstados.add(estado.name());
			}
			return siglasEstados;
		}
		
		public static List<String> getListNomesEstados(){
			List<String> nomesEstados = new ArrayList<>();
			for(EnumEstado estado : EnumSet.allOf(EnumEstado.class)) {
				nomesEstados.add(estado.getEstado());
			}
			return nomesEstados;
	}
}
