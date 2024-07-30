package com.auditquery.service;

import com.auditquery.entity.Findbugs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Findbugs)表服务接口
 *
 * @author makejava
 * @since 2024-02-22 22:14:46
 */
public interface FindbugsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Findbugs queryById(Integer id);

    /**
     * 分页查询
     *
     * @param findbugs 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Findbugs> queryByPage(Findbugs findbugs, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param findbugs 实例对象
     * @return 实例对象
     */
    Findbugs insertFindbugs(Findbugs findbugs);

    /**
     * 修改数据
     *
     * @param findbugs 实例对象
     * @return 实例对象
     */
    Findbugs updateFindbugs(Findbugs findbugs);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteByIdFindbugs(Integer id);

}
