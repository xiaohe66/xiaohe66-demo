package com.xiaohe66.demo.servlet;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 输出请求中的 header
 *
 * @author xiaohe
 * @time 2019-02-22 17:12
 */
public class PrintHeaderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Enumeration enumeration = req.getHeaderNames();
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement().toString();
			String value = req.getHeader(key);
			System.out.println(key+"\t: "+value);
		}

		System.out.println("---------------------------------------------------------------------------");

		resp.getWriter().println("ok");
	}
}
