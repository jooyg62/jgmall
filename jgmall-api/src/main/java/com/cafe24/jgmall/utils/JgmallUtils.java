package com.cafe24.jgmall.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class JgmallUtils {
	
	@Autowired
	private MessageSource messageSource;
	
	public String getmessage(String code) {
		String resultMessage =
				messageSource.getMessage(code, null, JgmallMsg.UNDEFINED_MSG.getMessage(), LocaleContextHolder.getLocale());
		return resultMessage;
	}
}