package com.practice.Instrument.dtoRequest;


import com.practice.Instrument.Enum.EnumInvestmentType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "")
public class InstrumentRequestDto {
    private Long id;
    private String ticker;
    private String name;
    String investmentType;
    private String sector;
    private Double quotes;
    private String description;
    private String divisa;
    private Boolean state;


}
