package com.firecode.app.model.service;

import com.firecode.app.model.entity.BancoEntity;
import com.firecode.app.model.repository.dao.BancoDao;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BancoService extends BancoDao {

    @Override
    public List<BancoEntity> findAllOrderBy(String orderBy) {
        return super.findAllOrderBy(orderBy);
    }

}
