package com.yhdx.tool.ctx.application;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author zhen.ling
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {

	private static ApplicationContext APPLICATION_CTX = null;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// APPLICATION_CTX = ContextLoader.getCurrentWebApplicationContext();
		APPLICATION_CTX = applicationContext;
	}

	public static <T> T getBean(Class<T> clazz) {
		return APPLICATION_CTX.getBean(clazz);
	}

	public static Object getBean(String name) {
		return APPLICATION_CTX.getBean(name);
	}

	public static <T> T getBean(String name, Class<T> clazz) {
		return APPLICATION_CTX.getBean(name, clazz);
	}
}
