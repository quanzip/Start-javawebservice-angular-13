//package com.example.backend.service.imp;
//
//import com.example.backend.entity.CustomPeopleDetail;
//import com.example.backend.entity.People;
//import com.example.backend.repository.PeopleRepository;
//import com.example.backend.service.PeopleService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class PeopleServiceImpl implements PeopleService {
//
//    private final PeopleRepository peopleRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<People> peopleOptional = peopleRepository.findByFirstNameAndIsActived(username, 1);
//        return peopleOptional.map(people -> new CustomPeopleDetail(people))
//                .orElseThrow(() -> new UsernameNotFoundException("User name: " + username + " not found"));
//    }
//}
