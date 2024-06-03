package com.zzf.music.gateway.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.UUID;

/**
 * jwt工具类
 */
public class JwtUtil {

    /**
     * 有效时间
     */
    public static final Long JWT_TTL = 60 * 60 * 1000L;//1小时
    /**
     * 密钥明文
     */
    public static final String JWT_KEY = "b057bc05c7a64350b3b2d0a79a289f0d";


    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 生成jwt
     *
     * @param subject token中的有效数据（json格式）
     * @return 生成的jwt
     */
    public static String createJWT(String subject) {
        JwtBuilder builder = getJwtBuilder(subject, null, getUUID());//设置主题，唯一id
        return builder.compact();
    }

    /**
     * 生成jwt
     *
     * @param subject  token中的有效数据（json格式）
     * @param ttlMills 过期时间
     * @return 生成的jwt
     */
    public static String createJWT(String subject, Long ttlMills) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMills, getUUID());//设置主题，过期时间，唯一id
        return builder.compact();
    }

    /**
     * 获取秘钥
     *
     * @param id       秘钥id
     * @param subject  秘钥内容
     * @param ttlMills 秘钥过期时间
     * @return 生成的jwt
     */
    public static String createJwt(String id, String subject, Long ttlMills) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMills, id);//设置主题，过期时间，唯一id
        return builder.compact();
    }

    /**
     * 获取秘钥
     *
     * @param subject    秘钥内容
     * @param expiration 秘钥过期时间
     * @param uuid       秘钥id
     * @return 生成的jwt
     */
    private static JwtBuilder getJwtBuilder(String subject, Long expiration, String uuid) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Key secretkey = getSigningKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if (expiration == null) {
            expiration = JWT_TTL;
        }
        long expMillis = nowMillis + expiration;
        Date expDate = new Date(expMillis);
        return Jwts.builder()
                .setId(uuid) // 设置唯一id
                .setSubject(subject) // 设置主题 可以是json数据
                .setIssuer("zzf") // 设置签发人
                .setIssuedAt(now) // 设置签发时间
                .signWith(secretkey, SignatureAlgorithm.HS256)// 设置签名使用的算法和签名使用的秘钥
                .setExpiration(expDate);
    }

    public static Key getSigningKey() {
//        byte[] keyBytes = new byte[32]; // 256 bits
//        SecureRandom random = new SecureRandom();
//        random.nextBytes(keyBytes);
//        return new SecretKeySpec(keyBytes, "HmacSHA256");
        byte[] keyBytes = JWT_KEY.getBytes(StandardCharsets.UTF_8);
        return new SecretKeySpec(keyBytes, "HmacSHA256");
    }


    public static Claims parseJWT(String jwt) throws Exception {
        Key secretkey = getSigningKey();
        return Jwts.parser()
                .setSigningKey(secretkey)
                .parseClaimsJws(jwt)
                .getBody();
    }

    public static void main(String[] args) throws Exception {
//        Map<String,Object> map = new HashMap<>();
//        map.put("name","zzf");
//        map.put("age",18);
//        System.out.println(createJWT(JSONUtil.toJsonStr(map)));

        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJmYTFlMDk2NjY3MjE0M2I5ODM0NjNmZjQyNDI0YTdiNSIsInN1YiI6IntcIm5hbWVcIjpcInp6ZlwiLFwiYWdlXCI6MTh9IiwiaXNzIjoic2ciLCJpYXQiOjE3MTcyNTI5MzAsImV4cCI6MTcxNzI1NjUzMH0.wRc6yLYWLXn2CNi-ycTjpZLj53-uBW4-2IcD-QYqiRk";

        Claims claims = parseJWT(jwt);
        System.out.println(claims);


    }


}
