package com.zeus.utils;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

import static com.zeus.constant.Constants.EFFECTIVE_TIME;
import static com.zeus.constant.Constants.TOKEN_ISSUER;


public class TokenUtil {
	private static Logger LOG = LoggerFactory.getLogger(TokenUtil.class);

	/**
	 * 创建TOKEN
	 *
	 * @param id, issuer, subject, ttlMillis
	 * @return java.lang.String
	 * @methodName createJWT
	 * @author fusheng
	 * @date 2019/1/10
	 */
	public static String createJWT(String id, String issuer, String subject, long ttlMillis) {

		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("englishlearningwebsite");
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		JwtBuilder builder = Jwts.builder().setId(id)
				.setIssuedAt(now)
				.setSubject(subject)
				.setIssuer(issuer)
				.signWith(signatureAlgorithm, signingKey);

		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}
		return builder.compact();
	}

	/**
	 * 解密TOKEN
	 *
	 * @param jwt
	 * @return io.jsonwebtoken.Claims
	 * @methodName parseJWT
	 * @author fusheng
	 * @date 2019/1/10
	 */
	public static Claims parseJWT(String jwt) {
		Claims claims = Jwts.parser()
				.setSigningKey(DatatypeConverter.parseBase64Binary("englishlearningwebsite"))
				.parseClaimsJws(jwt).getBody();
		return claims;
	}


	public static void main(String[] args) {
		JSON tokenJson = JSONUtil.createObj();
		((JSONObject) tokenJson).put("phoneNo", "13074149273");
		String token = TokenUtil.createJWT(String.valueOf("1"), TOKEN_ISSUER, JSONUtil.toJsonStr(tokenJson), EFFECTIVE_TIME);
		LOG.info("token:{}", token);
	}
}
