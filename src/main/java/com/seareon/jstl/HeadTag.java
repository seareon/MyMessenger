package com.seareon.jstl;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class HeadTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	private Object name;
	private String href;

	public void setHref(String href) {
		this.href = href;
	}

	public void setName(Object name) {
		this.name = name;
	}

	public int doStartTag() throws JspException {
		String str = "<div style=\"with=400px; hight=50px; margin: auto; margin-bottom: 50px;  background: blue;\">"+
				"<table><tr><td style=\"margin: auto;\"><a href=\"" + href + "?lang=en\">en</a>|<a href=\"" + href + 
				"?lang=ru\">ru</a><br></td></tr><tr><td style=\"margin: auto;\">" + (String)name + 
				"</td></tr><tr><td style=\"margin: auto;\"><input type=\"button\" onclick=\"location.href='tagExit'\">" + 
				"<spring:message code=\"label.LastName\"/></input></td></tr></table></div>";
		try {
			pageContext.getOut().print(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();				//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}
		return SKIP_BODY;
	}
}
