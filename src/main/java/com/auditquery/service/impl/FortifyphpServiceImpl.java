package com.auditquery.service.impl;

import com.auditquery.entity.Fortifyphp;
import com.auditquery.dao.FortifyphpMapper;
import com.auditquery.service.FortifyphpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Fortifyphp)表服务实现类
 *
 * @author makejava
 * @since 2024-02-22 22:16:10
 */
@Service
public class FortifyphpServiceImpl implements FortifyphpService {
    @Autowired
    private FortifyphpMapper fortifyphpMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Fortifyphp queryById(Integer id) {
        return this.fortifyphpMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param fortifyphp 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Fortifyphp> queryByPage(Fortifyphp fortifyphp, PageRequest pageRequest) {
        long total = this.fortifyphpMapper.count(fortifyphp);
        return new PageImpl<>(this.fortifyphpMapper.queryAllByLimit(fortifyphp, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param fortifyphp 实例对象
     * @return 实例对象
     */
    @Override
    public Fortifyphp insertFortifyphp(Fortifyphp fortifyphp) {
        this.fortifyphpMapper.insertFortifyphp(fortifyphp);
        return fortifyphp;
    }

    /**
     * 修改数据
     *
     * @param fortifyphp 实例对象
     * @return 实例对象
     */
    @Override
    public Fortifyphp updateFortifyphp(Fortifyphp fortifyphp) {
        this.fortifyphpMapper.updateFortifyphp(fortifyphp);
        return this.queryById(fortifyphp.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteByIdFortifyphp(Integer id) {
        return this.fortifyphpMapper.deleteByIdFortifyphp(id) > 0;
    }
}
