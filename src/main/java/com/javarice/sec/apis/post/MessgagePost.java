package com.javarice.sec.apis.post;

import java.io.Serializable;

/**
 * TODO TaskWait
 * @author ufenqi<Auto generate>
 * @version  2017-06-23 15:43:58
 */
public class MessgagePost implements Serializable {

	private static final long serialVersionUID = -8609703344908004551L;
	private String mobile;
	private String content;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "MessgagePost{" +
				"mobile='" + mobile + '\'' +
				", content='" + content + '\'' +
				'}';
	}
}

	
