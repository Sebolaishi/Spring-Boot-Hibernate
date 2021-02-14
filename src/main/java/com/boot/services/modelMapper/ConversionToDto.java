package com.boot.services.modelMapper;

public interface ConversionToDto<T,E> {
    T convertToDto(E object);
}
