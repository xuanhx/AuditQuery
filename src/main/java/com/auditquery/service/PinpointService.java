package com.auditquery.service;

import com.auditquery.entity.Pinpoint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Pinpoint)表服务接口
 *
 * @author makejava
 * @since 2024-02-22 22:15:39
 */
public interface PinpointService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Pinpoint queryById(Integer id);

    /**
     * 分页查询
     *
     * @param pinpoint 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Pinpoint> queryByPage(Pinpoint pinpoint, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param pinpoint 实例对象
     * @return 实例对象
     */
    Pinpoint insertPinpoint(Pinpoint pinpoint);

    /**
     * 修改数据
     *
     * @param pinpoint 实例对象
     * @return 实例对象
     */
    Pinpoint updatePinpoint(Pinpoint pinpoint);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteByIdPinpoint(Integer id);

}
