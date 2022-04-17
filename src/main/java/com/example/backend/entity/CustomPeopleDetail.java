//package com.example.backend.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.transaction.Transactional;
//import java.util.Collection;
//import java.util.stream.Collectors;
//
//@Data
//@AllArgsConstructor
//public class CustomPeopleDetail implements UserDetails {
////    Authentication
////    UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter = new UsernamePasswordAuthenticationFilter();
//    private People people;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return people.getAuthorities()
//                .parallelStream().map(au -> new SimpleGrantedAuthority(au.getName()))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public String getPassword() {
//        return people.getPassWord();
//    }
//
//    @Override
//    public String getUsername() {
//        return people.getFirstName();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return people.getIsActived() == 1;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
