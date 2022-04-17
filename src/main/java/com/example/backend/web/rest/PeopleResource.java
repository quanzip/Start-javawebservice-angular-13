package com.example.backend.web.rest;

import com.example.backend.entity.Authority;
import com.example.backend.entity.People;
import com.example.backend.repository.AuthorityRepository;
import com.example.backend.repository.PeopleRepository;
import com.example.backend.service.dto.PeopleDTO;
import com.example.backend.service.mapper.PeopleMapper;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@Api(value = "People Apis")
@ApiModel(value = "people model")
@CrossOrigin(origins = "http://localhost:4200")
public class PeopleResource {

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PeopleMapper peopleMapper;

//    @Autowired
//    private PassWEnd

    @ApiOperation(value = "Api lấy tất cả mọi người trong bản people")
    @GetMapping(value = "/people")
    @ApiModelProperty(value = "Model lấy tất cả mọi người")
    @ApiResponse(code = 200, message = "ok", response = List.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok")
            ,@ApiResponse(code = 401, message = "Thieu quyen")
    ,@ApiResponse(code = 403, message = "Quyen khong hop le")})
    public List<PeopleDTO> getALlPeople(){
        return peopleMapper.toDto(peopleRepository.findAll());
    }

    @PostMapping(value = "/people")
    @ApiOperation(value = "Add a people to table")
//    public ResponseEntity<People> addPeopleWithAuthorities(@RequestBody PeopleDTO peopleDTO){
    public People addPeopleWithAuthorities(@RequestBody PeopleDTO peopleDTO){
        People people = peopleMapper.toEntity(peopleDTO);
        if(people.getPassWord() == null || people.getPassWord().isEmpty()){
            people.setPassWord("123456");
        }
        Set<Authority> authorities = new HashSet<Authority>(){{
            add(new Authority(null, "ROLE_ADMIN"));
            add(new Authority(null, "ROLE_USER"));
        }};
        people.setAuthorities(authorities);

//        return ResponseEntity.ok().body(peopleRepository.save(people));
        return peopleRepository.save(people);
    }

    @PostMapping(value = "/people1")
    @ApiOperation(value = "Add a people to table")
    public People addPeopleWithAuthorities1(@RequestBody PeopleDTO peopleDTO){
        People people = peopleMapper.toEntity(peopleDTO);
        Set<Authority> authorities = new HashSet<Authority>(){{
            add(new Authority(null, "ROLE_SUBADMIN"));
            add(new Authority(null, "ROLE_HOST"));
        }};
        people.setAuthorities(authorities);
        authorityRepository.saveAll(authorities);

        People result = peopleRepository.save(people);
        System.out.println(result.getAuthorities());
        return result;
    }

    @PutMapping(value = "/people")
    @ApiOperation(value = "update a people to table")
    public People updatePeopleWithAuthorities(@RequestBody PeopleDTO peopleDTO){
        People people = peopleMapper.toEntity(peopleDTO);
        People result = peopleRepository.save(people);
        System.out.println(result);
        return result;
    }

    @DeleteMapping(value = "/people/{id}")
    @ApiOperation(value = "update a people to table")
    public ResponseEntity<Boolean> deletePeopleWithAuthorities(@PathVariable Long id){
        if(Objects.isNull(id))
            throw new NullPointerException("Id must not be null");
        peopleRepository.deleteById(id);
        return  ResponseEntity.ok(true);
    }
}
