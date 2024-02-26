package com.example.pw_api_u3_p5_ab.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;


public class AuthTokenFilter extends OncePerRequestFilter{
    Logger LOG = LoggerFactory.getLogger(JwtUtils.class);
    @Autowired
    private JwtUtils jwtUtils;
    
    @Override
    protected void doFilterInternal(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.FilterChain filterChain)
            throws javax.servlet.ServletException, IOException {

                try{
                String jwt = this.parseJwt(request);

                if(jwt!=null && jwtUtils.validateJwtToken(jwt)){ //valido y pasa la validacion
                    //se autentica, y necesita el nombre
                    String userName = this.jwtUtils.getUsernameFromJwtToken(jwt);

                    UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                            userName,
                            null,
                            new ArrayList<>());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }   

                } catch(Exception e){
                    LOG.error("Errorr", e);
                }

                filterChain.doFilter(request, response);

                
            }

            private String parseJwt(HttpServletRequest request){
                String headerAuthValor = request.getHeader("Authorization");
                if(StringUtils.hasText(headerAuthValor) && headerAuthValor.startsWith("Bearer ")){
                    return headerAuthValor.substring(7, headerAuthValor.length());
                }
                LOG.info("headerAuthValor es un texto nullo" );
                LOG.info(headerAuthValor );
                return null;


            }
    
}