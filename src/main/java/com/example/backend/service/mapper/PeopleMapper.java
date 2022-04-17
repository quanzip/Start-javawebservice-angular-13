package com.example.backend.service.mapper;

import com.example.backend.entity.People;
import com.example.backend.service.dto.PeopleDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface PeopleMapper extends EntityMapper<People, PeopleDTO>{
}
