package com.itheima.test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * Description:
 * date: 2018/12/3 22:03
 * author: loveLy
 */
public class ParseJwtTest {

    //Token解析
    public static void main(String[] args) {

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlsI_nmb0iLCJpYXQiOjE1NjQ4Mzg2ODUsImV4cCI6MTU2NDgzODc0NSwicm9sZXMiOiJhZG1pbiIsImxvZ28iOiJsb2dvLnBuZyJ9.xS5g4mX4pWc5klJCetBW2FnBgQgC44ZLq2qOxtbXmnA";
        //获取token对象
        Claims claims = Jwts.parser().setSigningKey("itcast").parseClaimsJws(token).getBody();
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(claims.getIssuedAt());
        System.out.println(claims.getExpiration());
        System.out.println(claims.get("roles"));
        System.out.println(claims.get("logo"));
    }
}
