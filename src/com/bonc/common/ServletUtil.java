package com.bonc.common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class ServletUtil {
	
	/**
	 * 
	 * @param isJson
	 * @param o (JSONObject或者JSONArray)
	 */
	public static void print(boolean isJson,Object o){
		HttpServletResponse response=ServletActionContext.getResponse();
		if(isJson){
			response.setContentType("application/json; charset=utf-8");
		}else{
			response.setContentType("application/text; charset=utf-8");
		}
		PrintWriter out=null;
		try {
			out=response.getWriter();
		} catch (Exception e) {
		}
		out.print(o.toString());
	}
	
}