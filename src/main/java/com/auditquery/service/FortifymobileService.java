package com.auditquery.service;

import com.auditquery.entity.Fortifymobile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Fortifymobile)表服务接口
 *
 * @author makejava
 * @since 2024-02-22 22:15:56
 */
public interface FortifymobileService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Fortifymobile queryById(Integer id);

    /**
     * 分页查询
     *
     * @param fortifymobile 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Fortifymobile> queryByPage(Fortifymobile fortifymobile, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param fortifymobile 实例对象
     * @return 实例对象
     */
    Fortifymobile insertFortifymobile(Fortifymobile fortifymobile);

    /**
     * 修改数据
     *
     * @param fortifymobile 实例对象
     * @return 实例对象
     */
    Fortifymobile updateFortifymobile(Fortifymobile fortifymobile);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteByIdFortifymobile(Integer id);

}
