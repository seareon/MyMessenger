package com.seareon.jstl;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class HeadTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	private String name;
	private String href;
	private String buttonName;

	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int doStartTag() throws JspException {
		String str = "<div style=\"width=400px; hight=50px; margin: auto; margin-bottom: 50px;  background: blue;\">"+
				"<table><tr><td><a href=\"" + href + "?lang=en\">en</a>|<a href=\"" + href + 
				"?lang=ru\">ru</a><br></td></tr><tr><td>" + (String)name + 
				"</td></tr><tr><td><input type=\"button\" value=\"" + buttonName +
				"\" onclick=\"location.href='tagExit'\"></td></tr></table></div>";
		try {
			pageContext.getOut().print(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();				//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}
		return SKIP_BODY;
	}
}
