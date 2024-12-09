package med.voll.api.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("El filtro ha sido llamado.");
        System.out.println("Ruta solicitada: " + request.getRequestURI());
        System.out.println("Método HTTP: " + request.getMethod());

        filterChain.doFilter(request, response);

        System.out.println("Respuesta enviada para: " + request.getRequestURI());
    }
}