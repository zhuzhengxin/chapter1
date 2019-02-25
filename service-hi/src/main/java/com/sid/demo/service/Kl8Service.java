package com.sid.demo.service;

import com.sid.demo.entity.Kl8;
import java.util.List;

/**
 * (Kl8)表服务接口
 *
 * @author makejava
 * @since 2019-02-21 16:33:06
 */
public interface Kl8Service {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Kl8 queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Kl8> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param  li
     * @return 实例对象
     */
    void insert();

    /**
     * 修改数据
     *
     * @param kl8 实例对象
     * @return 实例对象
     */
    Kl8 update(Kl8 kl8);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}