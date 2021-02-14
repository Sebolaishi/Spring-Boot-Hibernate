package com.boot.services.modelMapper;

public interface ConversionToEntity<T,E> {
    T convertToEntity(E dto);
}
