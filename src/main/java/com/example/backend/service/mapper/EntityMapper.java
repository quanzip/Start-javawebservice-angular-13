package com.example.backend.service.mapper;

import java.util.List;

public interface EntityMapper<T,D> {
    T toEntity(D d);
    D toDto(T t);

    List<T> toEntity(List<D> list);
    List<D> toDto(List<T> list);

}
