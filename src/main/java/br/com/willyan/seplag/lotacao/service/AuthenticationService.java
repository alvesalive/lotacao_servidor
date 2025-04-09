package br.com.willyan.seplag.lotacao.service;

import br.com.willyan.seplag.lotacao.dto.AuthRequestDTO;
import br.com.willyan.seplag.lotacao.dto.AuthResponseDTO;
import br.com.willyan.seplag.lotacao.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authManager;
    private final UsuarioRepository usuarioRepo;
    private final JwtService jwtService;

    public AuthResponseDTO login(AuthRequestDTO request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        var user = usuarioRepo.findByUsername(request.getUsername())
                .orElseThrow();

        String token = jwtService.generateToken(user);
        String refresh = jwtService.generateRefreshToken(user);
        return new AuthResponseDTO(token, refresh);
    }

    public AuthResponseDTO refreshToken(String refreshToken) {
        String username = jwtService.extractUsername(refreshToken);
        var user = usuarioRepo.findByUsername(username).orElseThrow();
        if (!jwtService.isTokenValid(refreshToken, user)) throw new RuntimeException("Token inválido");

        return new AuthResponseDTO(jwtService.generateToken(user), refreshToken);
    }
}
