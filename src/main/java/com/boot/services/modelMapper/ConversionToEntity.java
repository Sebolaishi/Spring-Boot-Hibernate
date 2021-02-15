package com.boot.services.modelMapper;

/**
 * Generic interface for Dto to Entity conversion
 * @param <T>
 * @param <E>
 */
public interface ConversionToEntity<T,E> {
    T convertToEntity(E dto);
}
