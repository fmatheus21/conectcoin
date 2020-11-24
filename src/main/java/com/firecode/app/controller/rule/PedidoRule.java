package com.firecode.app.controller.rule;

import com.firecode.app.controller.dto.PedidoDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PedidoRule {

    private PedidoDto pedidoDto;

    public List<PedidoDto> list() {
        pedidoDto = new PedidoDto();
        return pedidoDto.list();
    }

}
