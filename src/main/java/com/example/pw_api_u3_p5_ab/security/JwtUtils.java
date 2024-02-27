package com.example.pw_api_u3_p5_ab.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JwtUtils {

    //semilla server security
    @Value("${app.jwt.secret}")
    private String jwtSecret;

        Logger LOG = LoggerFactory.getLogger(JwtUtils.class);
    
        public boolean validateJwtToken (String authToken){
            LOG.info("jwtUtils");
            LOG.info(authToken);
            LOG.info(jwtSecret);
            try{          
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
            }catch(Exception e){
                LOG.error("ERRRORR", e);
                return false;
            }
    
        }

        public String getUsernameFromJwtToken(String token){
            // comparten las semillas conel servidor de autorizacion
            return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
        }
}