package com.interval.service.utils;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @Auther: nlife
 * @Email: xiamisspan@163.com
 * @Date: 2019/1/8 0008
 * @Description:
 */
public interface BaseDao<T> extends BaseMapper<T> {

    void save(T t);

    void save(Map<String, Object> map);

    void saveBatch(List<T> list);

    int update(T t);

    int update(Map<String, Object> map);

    int delete(Object id);

    int deleteEpc(String epc);

    int delete(Map<String, Object> map);

    int deleteBatch(Object[] id);

    T queryObject(Object id);

    T findByOpenIdLike(Object openid);

    T queryObjectUserId(Object userId);

    T queryObjectIdEpc(Map<String, Object> map);

    T queryObjectName(Object name);

    List<T> queryList(Map<String, Object> map);

    List<T> queryList1(Map<String, Object> map);

    T queryObjectScreen(Object id);

    T queryObjectWeddingId(Object weddingId);

    List<T> queryListorder(Map<String, Object> map);

    List<T> queryListother(Map<String, Object> map);

    List<T> queryListtongji(Map<String, Object> map);

    List<T> queryListCountparticipate(Map<String, Object> map);

    List<T> queryListtongjiimgxf(Map<String, Object> map);

    List<T> queryListmysql(Map<String, Object> map);

    List<T> queryListStudent(Map<String, Object> map);

    List<T> queryList(Object id);

    int queryTotal(Map<String, Object> map);

    int queryTotal();
}
