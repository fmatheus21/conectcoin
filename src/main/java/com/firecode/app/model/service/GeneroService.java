package com.firecode.app.model.service;

import com.firecode.app.model.entity.GeneroEntity;
import com.firecode.app.model.repository.dao.GeneroDao;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GeneroService extends GeneroDao {

    @Override
    public List<GeneroEntity> findAllOrderBy(String orderBy) {
        return super.findAllOrderBy(orderBy);
    }

}
