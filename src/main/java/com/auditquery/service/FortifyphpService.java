package com.auditquery.service;

import com.auditquery.entity.Fortifyphp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Fortifyphp)表服务接口
 *
 * @author makejava
 * @since 2024-02-22 22:16:10
 */
public interface FortifyphpService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Fortifyphp queryById(Integer id);

    /**
     * 分页查询
     *
     * @param fortifyphp 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Fortifyphp> queryByPage(Fortifyphp fortifyphp, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param fortifyphp 实例对象
     * @return 实例对象
     */
    Fortifyphp insertFortifyphp(Fortifyphp fortifyphp);

    /**
     * 修改数据
     *
     * @param fortifyphp 实例对象
     * @return 实例对象
     */
    Fortifyphp updateFortifyphp(Fortifyphp fortifyphp);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteByIdFortifyphp(Integer id);

}
