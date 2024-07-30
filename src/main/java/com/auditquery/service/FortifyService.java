package com.auditquery.service;

import com.auditquery.entity.Fortify;
import com.auditquery.entity.RespBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

/**
 * (Fortify)表服务接口
 *
 * @author makejava
 * @since 2024-02-22 22:15:24
 */
public interface FortifyService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Fortify queryById(Integer id);

    /**
     * 分页查询
     *
     * @param fortify 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Fortify> queryByPage(Fortify fortify, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param fortify 实例对象
     * @return 实例对象
     */
    Fortify insertFortify(Fortify fortify);

    /**
     * 修改数据
     *
     * @param fortify 实例对象
     * @return 实例对象
     */
    Fortify updateFortify(Fortify fortify);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteByIdFortify(Integer id);

    //结合Answer查询
    List searchFortify(String problemtype);
}
