package web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.RoleWeather;
import web.model.UserWeather;
import web.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserWeather user = userRepository.findByEmail(s);

        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<RoleWeather> roles = user.getRoles();
        for (RoleWeather role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        } return new User(user.getEmail(), user.getPassword(), grantedAuthorities);

    }
}