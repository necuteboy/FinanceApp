package com.example.financeapp.service;

import com.example.financeapp.config.PasswordEncoderConfiguration;
import com.example.financeapp.dto.request.PersonRequestDto;
import com.example.financeapp.model.PersonEntity;
import com.example.financeapp.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService implements UserDetailsService {
    private final PasswordEncoderConfiguration passwordEncoder;
    private final PersonRepository personRepository;

    public Optional<PersonEntity> findByUserName(String name) {
        return personRepository.findByName(name);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        PersonEntity user = personRepository.findByName(username).orElseThrow(
                () -> new UsernameNotFoundException("Пользователь не найден"));
        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                authorities);
    }
    public PersonEntity createPerson(PersonRequestDto requestDto){
        PersonEntity person = new PersonEntity();
        person.setName(requestDto.getName());
        person.setEmail(requestDto.getEmail());
        person.setPhoneNumber(requestDto.getPhoneNumber());
        person.setPassword(passwordEncoder.passwordEncoder().encode(requestDto.getPassword()));
        return personRepository.save(person);
    }

    public PersonEntity getPersonById(Long id){
        return personRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void deleteById(Long id){
        personRepository.deleteById(id);
    }
}
