package com.example.scholarapplicationjpa.config;//package com.example.scholar_gql_poc.config;
////
////import java.io.BufferedReader;
////import java.io.IOException;
////import java.io.InputStream;
////import java.io.InputStreamReader;
////import javax.servlet.Filter;
////import javax.servlet.FilterChain;
////import javax.servlet.ServletException;
////import javax.servlet.ServletRequest;
////import javax.servlet.ServletResponse;
////import javax.servlet.http.HttpServletRequest;
////import org.slf4j.Logger;
////import org.slf4j.LoggerFactory;
////import org.springframework.stereotype.Component;
////
////@Component
//////@Order(1)
////public class FilterDemo implements Filter {
////
////	Logger LOGGER = LoggerFactory.getLogger(FilterDemo.class);
////
////	@Override
////	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
////			throws IOException, ServletException {
////		LOGGER.info("Local Port : " + request.getLocalPort());
////		LOGGER.info("Server Name : " + request.getServerName());
////
////		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
////		LOGGER.info("Method Name : " + httpServletRequest.getMethod());
////		LOGGER.info("Request URI : " + httpServletRequest.getRequestURI());
////		LOGGER.info("Servlet Path : " + httpServletRequest.getServletPath());
////
////		String body = null;
////		StringBuilder stringBuilder = new StringBuilder();
////		BufferedReader bufferedReader = null;
////
////		try {
////			InputStream inputStream = request.getInputStream();
////			if (inputStream != null) {
////				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
////				char[] charBuffer = new char[128];
////				int bytesRead = -1;
////				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
////					stringBuilder.append(charBuffer, 0, bytesRead);
////				}
////			} else {
////				stringBuilder.append("");
////			}
////		} catch (IOException ex) {
////			throw ex;
////		} finally {
////			if (bufferedReader != null) {
////				try {
////					bufferedReader.close();
////				} catch (IOException ex) {
////					throw ex;
////				}
////			}
////		}
////		body = stringBuilder.toString();
////		LOGGER.info("body:  "+body);
////		chain.doFilter(request, response);
////	}
////
////}
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//
//import java.util.stream.Collectors;
//import javax.servlet.*;
//import org.springframework.stereotype.Component;
//
//@Component
//public class AccessLogConfig implements Filter {
//
//	private FilterConfig filterConfig = null;
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
//		if (filterConfig == null)
//			return;
//		String body = null;
//		StringBuilder stringBuilder = new StringBuilder();
//		BufferedReader bufferedReader = null;
//
//		try {
//			InputStream inputStream = request.getInputStream();
//			if (inputStream != null) {
//				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//				char[] charBuffer = new char[128];
//				int bytesRead = -1;
//				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
//					stringBuilder.append(charBuffer, 0, bytesRead);
//				}
//			} else {
//				stringBuilder.append("");
//			}
//		} catch (IOException ex) {
//			throw ex;
//		}
//		finally {
//			if (bufferedReader != null) {
//				try {
//					bufferedReader.close();
//				} catch (IOException ex) {
//					throw ex;
//				}
//			}
// }
//
//		body = stringBuilder.toString();
//		//body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
//		request.setAttribute("payload", body);
//		chain.doFilter(request, response);
//	}
//
//	public void init(FilterConfig filterConfig) throws ServletException {
//		this.filterConfig = filterConfig;
//	}
//	@Override
//	public void destroy() {
//	}
//}