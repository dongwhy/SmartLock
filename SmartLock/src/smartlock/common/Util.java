package smartlock.common;

import org.apache.commons.codec.binary.Base64;

public class Util {
	// ��ȣȭ
	public static String encrypt(String value) {
		return new String(Base64.encodeBase64(value.getBytes()));
	}
}
