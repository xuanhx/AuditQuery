package com.auditquery.service.impl;

import com.auditquery.entity.Findbugs;
import com.auditquery.dao.FindbugsMapper;
import com.auditquery.service.FindbugsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Findbugs)表服务实现类
 *
 * @author makejava
 * @since 2024-02-22 22:14:46
 */
@Service
public class FindbugsServiceImpl implements FindbugsService {
    @Autowired
    private FindbugsMapper findbugsMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Findbugs queryById(Integer id) {
        return this.findbugsMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param findbugs 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Findbugs> queryByPage(Findbugs findbugs, PageRequest pageRequest) {
        long total = this.findbugsMapper.count(findbugs);
        return new PageImpl<>(this.findbugsMapper.queryAllByLimit(findbugs, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param findbugs 实例对象
     * @return 实例对象
     */
    @Override
    public Findbugs insertFindbugs(Findbugs findbugs) {
        this.findbugsMapper.insertFindbugs(findbugs);
        return findbugs;
    }

    /**
     * 修改数据
     *
     * @param findbugs 实例对象
     * @return 实例对象
     */
    @Override
    public Findbugs updateFindbugs(Findbugs findbugs) {
        this.findbugsMapper.updateFindbugs(findbugs);
        return this.queryById(findbugs.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteByIdFindbugs(Integer id) {
        return this.findbugsMapper.deleteByIdFindbugs(id) > 0;
    }
}
