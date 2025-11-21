package br.com.fiap.GlobalSolutionJava.service;

import br.com.fiap.GlobalSolutionJava.domain.User;
import br.com.fiap.GlobalSolutionJava.domain.dto.request.UpdateUser;
import br.com.fiap.GlobalSolutionJava.exceptions.InvalidCredentialsException;
import br.com.fiap.GlobalSolutionJava.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final MessageSource messageSource;
    private final BCryptPasswordEncoder passwordEncoder;

    public User salvar(User user, LocalDate dataNascimento) {
        user.setDataNascimentoUsuario(dataNascimento);
        return userRepository.save(user);
    }

    public User obterPorId(String id, Locale locale) {
        String message = messageSource.getMessage("user.id.notfound", null, locale);
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(message));
    }

    @Transactional
    public User updateUser(String id, UpdateUser dto, Locale locale) {
        User user = obterPorId(id, locale);

        user.setNomeUsuario(dto.nomeUsuario());
        user.setSenhaUsuario(passwordEncoder.encode(dto.senhaUsuario()));

        LocalDate dataNascimento = LocalDate.of(dto.ano(), dto.mes(), dto.dia());
        user.setDataNascimentoUsuario(dataNascimento);

        return userRepository.save(user);
    }


}
