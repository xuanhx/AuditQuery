package com.auditquery.service.impl;

import com.auditquery.entity.Fortifymobile;
import com.auditquery.dao.FortifymobileMapper;
import com.auditquery.service.FortifymobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Fortifymobile)表服务实现类
 *
 * @author makejava
 * @since 2024-02-22 22:15:56
 */
@Service
public class FortifymobileServiceImpl implements FortifymobileService {
    @Autowired
    private FortifymobileMapper fortifymobileMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Fortifymobile queryById(Integer id) {
        return this.fortifymobileMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param fortifymobile 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Fortifymobile> queryByPage(Fortifymobile fortifymobile, PageRequest pageRequest) {
        long total = this.fortifymobileMapper.count(fortifymobile);
        return new PageImpl<>(this.fortifymobileMapper.queryAllByLimit(fortifymobile, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param fortifymobile 实例对象
     * @return 实例对象
     */
    @Override
    public Fortifymobile insertFortifymobile(Fortifymobile fortifymobile) {
        this.fortifymobileMapper.insertFortifymobile(fortifymobile);
        return fortifymobile;
    }

    /**
     * 修改数据
     *
     * @param fortifymobile 实例对象
     * @return 实例对象
     */
    @Override
    public Fortifymobile updateFortifymobile(Fortifymobile fortifymobile) {
        this.fortifymobileMapper.updateFortifymobile(fortifymobile);
        return this.queryById(fortifymobile.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteByIdFortifymobile(Integer id) {
        return this.fortifymobileMapper.deleteByIdFortifymobile(id) > 0;
    }
}
