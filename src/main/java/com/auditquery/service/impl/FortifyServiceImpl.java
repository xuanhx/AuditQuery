package com.auditquery.service.impl;

import com.auditquery.entity.Answer;
import com.auditquery.entity.Fortify;
import com.auditquery.dao.FortifyMapper;
import com.auditquery.entity.RespBean;
import com.auditquery.entity.tFortifyAnswer;
import com.auditquery.service.FortifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * (Fortify)表服务实现类
 *
 * @author makejava
 * @since 2024-02-22 22:15:24
 */
@Service
public class FortifyServiceImpl implements FortifyService {
    @Autowired
    private FortifyMapper fortifyMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Fortify queryById(Integer id) {
        return this.fortifyMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param fortify 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Fortify> queryByPage(Fortify fortify, PageRequest pageRequest) {
        long total = this.fortifyMapper.count(fortify);
        return new PageImpl<>(this.fortifyMapper.queryAllByLimit(fortify, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param fortify 实例对象
     * @return 实例对象
     */
    @Override
    public Fortify insertFortify(Fortify fortify) {
        this.fortifyMapper.insertFortify(fortify);
        return fortify;
    }

    /**
     * 修改数据
     *
     * @param fortify 实例对象
     * @return 实例对象
     */
    @Override
    public Fortify updateFortify(Fortify fortify) {
        this.fortifyMapper.updateFortify(fortify);
        return this.queryById(fortify.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteByIdFortify(Integer id) {
        return this.fortifyMapper.deleteByIdFortify(id) > 0;
    }


    //结合Answer查询
    @Override
    public List searchFortify(String problemtype) {
        List maps = fortifyMapper.searchFortify(problemtype);
        System.out.println(maps);
        if(maps.size()<=0){
            return Collections.singletonList("没有查询到");
        }
        List tFortifyAnswerList = new ArrayList<>();
        Fortify fortify = (Fortify) maps.get(0);
        List tFortifyAnswerList1 = fortify.getTFortifyAnswer();
        for (int i = 0; i < tFortifyAnswerList1.size(); i++) {
            tFortifyAnswer tFortifyAnswer = new tFortifyAnswer();
            Answer answer = (Answer) tFortifyAnswerList1.get(i);
            tFortifyAnswer.setWordanswer(answer.getWordanswer());
            tFortifyAnswer.setPictureanswer(answer.getPictureanswer());
            tFortifyAnswer.setProblemtype(fortify.getProblemtype());
            tFortifyAnswer.setPropose(fortify.getPropose());
            tFortifyAnswerList.add(tFortifyAnswer);
        }
        System.out.println(tFortifyAnswerList);
        return tFortifyAnswerList;

    }
}
