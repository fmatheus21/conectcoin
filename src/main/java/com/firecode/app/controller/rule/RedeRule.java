package com.firecode.app.controller.rule;

import com.firecode.app.controller.dto.IndicadoDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RedeRule {

    private IndicadoDto indicadoDto;

    public List<IndicadoDto> listIndicated() {
        indicadoDto = new IndicadoDto();
        return indicadoDto.list();
    }

}
