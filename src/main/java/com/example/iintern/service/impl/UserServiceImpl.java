package com.example.iintern.service.impl;

import com.example.iintern.config.JwtUtils;
import com.example.iintern.controller.dto.UserCreateDto;
import com.example.iintern.model.User;
import com.example.iintern.repository.UserRepository;
import com.example.iintern.service.UserInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserInterface {
    private final UserRepository userRepository;

    //private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;
//    @Override
//    public User createUser(UserCreateDto createDto) throws Exception {
//        User user = new User();
//        user.setUsername(createDto.getUsername());
//        if(isValidPassword(createDto.getPassword())==true)
//        {
//            user.setPassword(createDto.getPassword());
//        }
//        else{
//
//        }
//
//        return userRepository.save(user);
//    }
//
//    @Override
//    public void updateUser(Long id, UserCreateDto createDto) throws Exception {
//    User user = userRepository.findById(id).orElseThrow();
//    user.setUsername(createDto.getUsername());
//    if(isValidPassword(createDto.getPassword())==true)
//    {
//        user.setPassword(createDto.getPassword());
//        userRepository.save(user);
//    }
//        System.out.println("Console is: " + System.console());;
//
//    }
//    private Boolean isValidPassword(String password)
//    {
//
//        // Regex to check valid password.
//        String regex = "^(?=.*[0-9])"
//                + "(?=.*[a-z])(?=.*[A-Z])"
//                + "(?=.*[@#$%^&+=])"
//                + "(?=\\S+$).{8,20}$";
//
//        // Compile the ReGex
//        Pattern p = Pattern.compile(regex);
//
//        // If the password is empty
//        // return false
//        if (password == null) {
//            return false;
//        }
//
//        // Pattern class contains matcher() method
//        // to find matching between given password
//        // and regular expression.
//        Matcher m = p.matcher(password);
//
//        // Return if the password
//        // matched the ReGex
//
//        return m.matches();
//    }
//
//    @Override
//    public List<User> getByAllUser() throws Exception {
//        return userRepository.findAll().stream().toList();
//    }
//
//    @Override
//    public void deleteUser(Long id) throws Exception {
//        userRepository.deleteById(id);
//    }

    @Override
    public User registration(UserCreateDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public String login(UserCreateDto dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getUsername());

        if (userDetails != null) {
            String token = jwtUtils.generateToken(userDetails);
            return token;
        }

        return "not auth";
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsernameIgnoreCase(username);
    }
}
