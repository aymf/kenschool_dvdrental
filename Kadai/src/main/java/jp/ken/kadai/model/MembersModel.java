package jp.ken.kadai.model;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class MembersModel implements Serializable {
	
	private String member_id;

	@NotEmpty(groups=ErrorCheckGroup1.class,
			message="名前を省略することはできません")
	private String member_name;

	@Pattern(regexp="^(070|080|090)-[0-9]{4}-[0-9]{4}$",
				groups=ErrorCheckGroup1.class,
				message="携帯番号ではありません")
	private String member_phone;

	@NotEmpty(groups=ErrorCheckGroup1.class,
					message="メールアドレスを省略することはできません")
	@Email(groups=ErrorCheckGroup1.class,
				message="メールアドレスではありません")
	private String member_email;
	
	@NotEmpty(groups=ErrorCheckGroup1.class,
			message="パスワードを省略することはできません")
	private String member_password;

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_password() {
		return member_password;
	}

	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}

}
