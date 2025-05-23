package ar.com.ddd.ddd_architecture.common.utils;

import org.modelmapper.ModelMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Converter {
    
    private static ModelMapper modelMapper = new ModelMapper();

    public static <T> T convertToEntity(Object object, Class<T> entityClass) {
        return modelMapper.map(object, entityClass);
    }

    public static <T> T convertToModel(Object object, Class<T> dtoClass) {
        return modelMapper.map(object, dtoClass);
    }

    public static <T> T convertToDto(Object object, Class<T> dtoClass) {
        return modelMapper.map(object, dtoClass);
    }
}