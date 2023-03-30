package org.gopas.springbootdemo.service;

import org.gopas.springbootdemo.data.model.Person;
import org.gopas.springbootdemo.data.model.PersonHasRole;
import org.gopas.springbootdemo.data.repository.PersonRepository;
import org.gopas.springbootdemo.rest.PersonRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service("customUserDetailsServiceImpl")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.findByEmail(username);
        UserDetails userDetails = new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<SimpleGrantedAuthority> authorities = new ArrayList<>();
                Set<PersonHasRole> personHasRoleSet = person.getPersonHasRoleSet();
                personHasRoleSet.forEach(phr -> {
                    authorities.add(new SimpleGrantedAuthority(phr.getIdRole().getName()));
                });
                return authorities;
            }

            @Override
            public String getPassword() {
                return person.getPwd();
            }

            @Override
            public String getUsername() {
                return person.getEmail();
            }

            @Override
            public boolean isAccountNonExpired() {
                return false;
            }

            @Override
            public boolean isAccountNonLocked() {
                return false;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return false;
            }

            @Override
            public boolean isEnabled() {
                return false;
            }
        };
        return userDetails;

    }


}
