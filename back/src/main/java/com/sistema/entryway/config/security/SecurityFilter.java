package com.sistema.entryway.config.security;

import com.sistema.entryway.repository.SubjectRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static java.util.Objects.*;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    final TokenService tokenService;
    final SubjectRepository subjectRepository;

    public SecurityFilter(TokenService tokenService,
                          SubjectRepository subjectRepository) {
        this.tokenService = tokenService;
        this.subjectRepository = subjectRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);

        if (nonNull(token)) {
            var username = tokenService.validateToken(token);
            var subject = subjectRepository.findByUsername(username);

            var authentication = new UsernamePasswordAuthenticationToken(
                    subject,
                    null,
                    subject.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest httpServletRequest) {
        var authHeader = httpServletRequest.getHeader("Authorization");

        if (isNull(authHeader)) {
            return null;
        }

        return authHeader.replace("Bearer ", "");
    }
}
