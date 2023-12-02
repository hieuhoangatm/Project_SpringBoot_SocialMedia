package com.zos.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.zos.config.SecurityContest;
import com.zos.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtTokenProvider {
	
	public JwtTokenClaims getClaimsFromToken(String token) {
		SecretKey key= Keys.hmacShaKeyFor(SecurityContest.JWT_KEY.getBytes());
		
	    Claims claims = Jwts.parser()
	            .setSigningKey(key)
	            .parseClaimsJws(token)
	            .getBody();
	    String username= String.valueOf(claims.get("username"));

	    JwtTokenClaims jwtTokenClaims = new JwtTokenClaims();
//	    jwtTokenClaims.setUsername(Long.parseLong(claims.getSubject()));
	    jwtTokenClaims.setUsername(username);

	    return jwtTokenClaims;
	}
	
	// tạo ra một chuỗi JWT (JSON Web Token) dựa trên thông tin người dùng.
	public String  generateJwtToken(User user) {
		// tạo một khóa bí mật từ chuỗi SecurityContest.JWT_KEY và sử dụng nó để ký (sign) JWT.
		SecretKey key=Keys.hmacShaKeyFor(SecurityContest.JWT_KEY.getBytes());
		
		String jwt=Jwts.builder()
				.setIssuer("Ashok Zarmariya")
				.claim("username",user.getEmail())
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime()+ 990000000))
				.signWith(key).compact();
		
		
		return jwt;
	}


}
