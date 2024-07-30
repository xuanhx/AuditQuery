package com.auditquery.service;

import com.auditquery.entity.Answer;
import com.auditquery.entity.Detailstable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Detailstable)表服务接口
 *
 * @author makejava
 * @since 2024-03-05 16:51:57
 */
public interface DetailstableService {

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    Detailstable queryById(String id);

    /**
     * 分页查询
     *
     * @param detailstable 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Detailstable> queryByPage(Detailstable detailstable, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param detailstable 实例对象
     * @return 实例对象
     */
    Detailstable insert(Detailstable detailstable);

    /**
     * 修改数据
     *
     * @param detailstable 实例对象
     * @return 实例对象
     */
    Detailstable update(Detailstable detailstable);

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    boolean deleteById(String id);

    ////查询全部Detailstable
    List<Detailstable> lists();


    int updateDetailstable(Detailstable detailstable);
}
