package com.firecode.app.controller.rule;

import com.firecode.app.controller.dto.FinanciamentoDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FinanciamentoRule {

    private FinanciamentoDto financiamentoDto;

    public List<FinanciamentoDto> listPaymentSchedule() {
        financiamentoDto = new FinanciamentoDto();
        return financiamentoDto.listPaymentSchedule();
    }
}
