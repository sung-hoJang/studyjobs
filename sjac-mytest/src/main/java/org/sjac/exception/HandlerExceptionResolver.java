package org.sjac.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface HandlerExceptionResolver {
	ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex);
}
