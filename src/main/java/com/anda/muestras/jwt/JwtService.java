package com.anda.muestras.jwt;


import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.anda.muestras.model.CustomUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	private final String SECRET_KEY="76397924423F4528482B4D6251655468576D5A7134743777217A25432A46294A";
	
	public String getToken(CustomUser user) {
		
		return getToken(new HashMap<>(),user);
	}
	
	
	public String getToken(Map<String,Object> extraClaims , CustomUser user) {
		return Jwts
				.builder()
				.claims(extraClaims)
				.subject(user.getUsername())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+1000*120*24))
				.signWith(getKey())
				.compact();
	}
	
	
	public Key getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
	}
	
	 public String getUsernameFromToken(String token) {
		    return getClaim(token, Claims::getSubject);
		}

		public boolean isTokenValid(String token, UserDetails userDetails) {
		  final String username=getUsernameFromToken(token);
		  return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
		}
		    private Claims getAllClaims(String token)
		    {
		             return (Claims) Jwts.parser()
		                .verifyWith((SecretKey) getKey())
		                .build()   
		                .parse(token).getPayload(); 
		    }

		    public <T> T getClaim(String token, Function<Claims,T> claimsResolver)
		    {
		        final Claims claims=getAllClaims(token);
		        return claimsResolver.apply(claims);
		    }
		    
		      private Date getExpiration(String token)
		    {
		        return getClaim(token, Claims::getExpiration);
		    }

		    private boolean isTokenExpired(String token)
		    {
		        return getExpiration(token).before(new Date());
		    }
	

}
