package com.Demo.Infra.SecurityConfig;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

	public String getUser() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		if(name.equals("anonymousUser")) {
			return null;
		}
		return name;
	}

}