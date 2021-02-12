package jp.ken.kadai.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class StocksModel implements Serializable {
	
	private String selectRadio;

	public String getSelectRadio() {
		return selectRadio;
	}

	public void setSelectRadio(String selectRadio) {
		this.selectRadio = selectRadio;
	}

}
