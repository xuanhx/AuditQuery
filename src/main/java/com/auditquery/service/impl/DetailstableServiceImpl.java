package com.auditquery.service.impl;

import com.auditquery.dao.DetailstableMapper;
import com.auditquery.entity.Answer;
import com.auditquery.entity.Detailstable;
import com.auditquery.service.DetailstableService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * (Detailstable)表服务实现类
 *
 * @author makejava
 * @since 2024-03-05 16:51:57
 */
@Service
public class DetailstableServiceImpl implements DetailstableService {
    @Autowired
    private DetailstableMapper detailstableMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    @Override
    public Detailstable queryById(String id) {
        return this.detailstableMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param detailstable 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Detailstable> queryByPage(Detailstable detailstable, PageRequest pageRequest) {
        long total = this.detailstableMapper.count(detailstable);
        return new PageImpl<>(this.detailstableMapper.queryAllByLimit(detailstable, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param detailstable 实例对象
     * @return 实例对象
     */
    @Override
    public Detailstable insert(Detailstable detailstable) {
        this.detailstableMapper.insert(detailstable);
        return detailstable;
    }

    /**
     * 修改数据
     *
     * @param detailstable 实例对象
     * @return 实例对象
     */
    @Override
    public Detailstable update(Detailstable detailstable) {
        this.detailstableMapper.update(detailstable);
        return this.queryById(detailstable.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.detailstableMapper.deleteById(id) > 0;
    }

    //查询全部Answer
    @Override
    public List<Detailstable> lists() {
        QueryWrapper queryWrapper = new QueryWrapper();
        return detailstableMapper.selectList(queryWrapper.select());
    }


    @Override
    public int updateDetailstable(Detailstable detailstable) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("systemname", detailstable.getSystemname());
        queryWrapper.eq("problemtime", detailstable.getProblemtime());
        List list = detailstableMapper.selectList(queryWrapper);
        for (int i = 0; i < list.size(); i++) {
            Detailstable deta = (Detailstable) list.get(i);
            if("".equals(deta.getProblemlevel()) || null==deta.getProblemlevel()){
                deta.setProblemlevel("高");
            }
            detailstable.setRisklevel("组件");//缺陷风险层面
            detailstable.setComponentname(deta.getComponentname());//组件名称
            detailstable.setProblemdescription(deta.getProblemdescription());//问题描述
            detailstable.setRisklocation(deta.getRisklocation());//风险位置
            detailstable.setQuestionnumber(deta.getQuestionnumber());//问题编号
            detailstable.setProblemlevel(deta.getProblemlevel());//问题等级
            int j = detailstableMapper.updateDetailstable(detailstable);
            if (j > 0) {
                System.out.println("成功"+i);
            } else {
                return 0;
            }
        }
        return 1;
    }


}
