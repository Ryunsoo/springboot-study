package com.kh.toy.common.code;

public enum Config {

	//DOMAIN("http://pclass.ga"),
	DOMAIN("http://localhost:9090"),
	COMPANY_EMAIL("medibook90@gmail.com"),
	SMTP_AUTHENTICATION_ID("medibook90@gmail.com"),
	SMTP_AUTHENTICATION_PASSWORD("Qwer1234qwer"),
	UPLOAD_PATH("C:\\CODE\\upload\\");
	
	public final String DESC;
	
	Config(String desc) {
		this.DESC = desc;
	}
	
}
