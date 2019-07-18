package com.cafe24.jgmall.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class JgmallUtils {
	
	@Autowired
	private MessageSource messageSource;
	
	public String getMessage(String code, String defaultMsg) {
		String resultMessage =
				messageSource.getMessage(code, null, defaultMsg, LocaleContextHolder.getLocale());
		return resultMessage;
	}
}