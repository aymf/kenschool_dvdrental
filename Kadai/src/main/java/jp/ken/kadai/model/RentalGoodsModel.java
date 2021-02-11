package jp.ken.kadai.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class RentalGoodsModel implements Serializable {
	
	private String selectRadio;
	
	@NotEmpty(message="省略することはできません")
	private String vagueField;

	public String getSelectRadio() {
		return selectRadio;
	}

	public void setSelectRadio(String selectRadio) {
		this.selectRadio = selectRadio;
	}

	public String getVagueField() {
		return vagueField;
	}

	public void setVagueField(String vagueField) {
		this.vagueField = vagueField;
	}
	
}
