package com.firecode.app.controller.rule;

import com.firecode.app.controller.dto.FinanceiroDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FinanceiroRule {

    private FinanceiroDto financeiroDto;

    public List<FinanceiroDto> listExtract() {
        financeiroDto = new FinanceiroDto();
        return financeiroDto.listExtract();
    }

    public List<FinanceiroDto> listWithdraw() {
        financeiroDto = new FinanceiroDto();
        return financeiroDto.listWithdraw();
    }

}
