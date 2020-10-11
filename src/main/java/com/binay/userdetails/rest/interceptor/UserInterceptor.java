package com.binay.userdetails.rest.interceptor;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserInterceptor extends HandlerInterceptorAdapter {

	public static final String CORRELATION_ID_HEADER_NAME = "X-Correlation-Id";
	public static final String CORRELATION_ID_LOG_VAR_NAME = "correlationId";
	
	public static final String REQUEST_RCVD_MESSAGE = "New request received with correlation id : %s";
	public static final String REQUEST_COMPLETE_MSG = "Request completed - correlation id : %s";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String correlationId = getCorrelationIdFromHeader(request);
		MDC.put(CORRELATION_ID_LOG_VAR_NAME, correlationId);		
		
		log.info(String.format(REQUEST_RCVD_MESSAGE, correlationId));
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {

		log.info(String.format(REQUEST_COMPLETE_MSG, MDC.get(CORRELATION_ID_LOG_VAR_NAME)));
		MDC.remove(CORRELATION_ID_LOG_VAR_NAME);

	}

	private String getCorrelationIdFromHeader(HttpServletRequest request) {

		String correlationId = request.getHeader(CORRELATION_ID_HEADER_NAME);
		if (StringUtils.isAllEmpty(correlationId)) {
			correlationId = UUID.randomUUID().toString();
		}
		return correlationId;

	}
}