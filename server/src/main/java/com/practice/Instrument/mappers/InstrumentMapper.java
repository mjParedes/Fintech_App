package com.practice.Instrument.mappers;


import com.practice.Instrument.dtoRequest.InstrumentRequestDto;
import com.practice.Instrument.model.InstrumentModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class InstrumentMapper {

    private final ModelMapper modelMapper;


    public InstrumentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public InstrumentRequestDto toDto(InstrumentModel instrumentModel) {
        return modelMapper.map(instrumentModel, InstrumentRequestDto.class);
    }


}
