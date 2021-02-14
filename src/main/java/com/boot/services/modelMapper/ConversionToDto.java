package com.boot.services.modelMapper;

/**
 * Generic interface for Entity to Dto conversion
 * @param <T>
 * @param <E>
 */
public interface ConversionToDto<T,E> {
    T convertToDto(E entity);
}
