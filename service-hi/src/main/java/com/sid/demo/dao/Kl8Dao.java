package com.sid.demo.dao;

import com.sid.demo.entity.Kl8;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Kl8)表数据库访问层
 *
 * @author makejava
 * @since 2019-02-21 16:33:05
 */
@Mapper
public interface Kl8Dao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Kl8 queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Kl8> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param kl8 实例对象
     * @return 对象列表
     */
    List<Kl8> queryAll(Kl8 kl8);

    /**
     * 新增数据
     *
     * @param kl8 实例对象
     * @return 影响行数
     */
    int insert(List<Kl8> kl8);

    /**
     * 修改数据
     *
     * @param kl8 实例对象
     * @return 影响行数
     */
    int update(Kl8 kl8);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}