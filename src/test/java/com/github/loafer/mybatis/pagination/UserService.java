package com.github.loafer.mybatis.pagination;

import com.github.loafer.mybatis.pagination.model.DataPaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date Created  2014-2-17
 *
 * @author loafer[zjh527@163.com]
 * @version 1.0
 */
@Component
public class UserService {
    @Autowired
    private IRepository repository;

    public List listing(){
        return repository.selectList("com.github.loafer.mybaits.mappers.UserMapper.selectUser", null);
    }

    public DataPaging paging(Object parameterObject){
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("orgna_id", parameterObject);
        return  repository.selectPaging("com.github.loafer.mybaits.mappers.UserMapper.selectPaging", parameter, 0, 10);
    }
}
