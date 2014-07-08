package com.github.loafer.mybatis.pagination;

import com.github.loafer.mybatis.pagination.model.DataPaging;

import java.util.List;
import java.util.Map;

/**
 * Date Created 2014-2-17
 *
 * @author loafer[zjh527@163.com]
 * @version 1.0
 */
public interface IRepository {
    <T> T selectOne(String statement, Object parameter);

    <E>List<E> selectList(String statement, Object parameter);

    <E>DataPaging<E> selectPaging(String statement, Object parameter, int offset, int limit);

    <K, V>Map<K, V> selectMap(String statement, Object parameter, String mapKey);

    int insert(String statement, Object parameter);

    int update(String statement, Object parameter);

    int delete(String statement, Object parameter);
}
