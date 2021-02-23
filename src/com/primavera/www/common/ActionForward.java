package com.primavera.www.common;

public class ActionForward {

	String path;
	boolean redirect;
	
	public ActionForward() {
	}

	public ActionForward(String path, boolean redirect) {
		this.path = path;
		this.redirect = redirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
}
