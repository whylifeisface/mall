package com.example.mall.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class JwtTokenUtil {

    private static final Logger LOGGER =  LoggerFactory.getLogger(JwtTokenUtil.class);
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    private String generateToken(Map<String,Object> claims){
        System.out.println("generateToken");
        return Jwts.builder().setClaims(claims)
                .signWith(SignatureAlgorithm.HS512,"mySerect").compact();
    }

    private Claims getClaimsFromToken(String Token){
        Claims claims = null;
        try{
            claims=Jwts.parser().setSigningKey(secret).parseClaimsJws(Token).getBody();
        }catch (Exception e){
            LOGGER.info("JWT格式验证错误:{}",Token);
        }
        return claims;
    }
    private Date generateExpirationDate(){
        System.out.println("generateExpirationDate");
        return new Date(System.currentTimeMillis() + expiration*1000);
    }
    public String getUserNameFromToken(String Token){
        String username;
        try {
            Claims claims = getClaimsFromToken(Token);
            username = claims.getSubject();
        } catch (Exception e) {
            username=null;
        }
        return username;
    }
    public boolean isTokenExpired(String Token){
        Date date = getExpiredDateFromToken(Token);
        return date.before(new Date());
    }

    public Date getExpiredDateFromToken(String token){
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    public String generateToken(String username){
        Map<String,Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_CREATED,new Date());
        claims.put(CLAIM_KEY_USERNAME,username);
        return generateToken(claims);
    }
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }


    public boolean canRefresh(String token){
        return !isTokenExpired(token);
    }
    public String refreshToken(String token){
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED,new Date());

        return generateToken(claims);
    }

}
