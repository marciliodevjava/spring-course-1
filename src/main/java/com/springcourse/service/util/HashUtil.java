package com.springcourse.service.util;

import org.apache.commons.codec.digest.DigestUtils;

public class HashUtil {

	/**
	 * Função que gera o Hash
	 * @param text
	 * @return
	 */
	public static String getSecureHash(String text) {
		String hash = DigestUtils.sha256Hex(text);
		return hash;
	}
}
