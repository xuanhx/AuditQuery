package com.auditquery.service.impl;

import com.auditquery.entity.Answer;
import com.auditquery.dao.AnswerMapper;
import com.auditquery.entity.RespBean;
import com.auditquery.service.AnswerService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (Answer)表服务实现类
 *
 * @author makejava
 * @since 2024-02-22 22:14:24
 */
@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerMapper answerMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Answer queryById(Integer id) {
        return this.answerMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param answer 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Answer> queryByPage(Answer answer, PageRequest pageRequest) {
        long total = this.answerMapper.count(answer);
        return new PageImpl<>(this.answerMapper.queryAllByLimit(answer, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param answer 实例对象
     * @return 实例对象
     */
    @Override
    public RespBean insertAnswer(Answer answer) {
//        String problemtype = String.valueOf(answer.);
//        String wordanswer = String.valueOf(params.get("wordanswer"));
//        String pictureanswer = String.valueOf(params.get("pictureanswer"));
//        String remarks = String.valueOf(params.get("remarks"));
//        String tbname = String.valueOf(params.get("tbname"));

        Answer answer1 = new Answer();
        answer1.setProblemtype(answer.getProblemtype());
        answer1.setWordanswer(answer.getWordanswer());
        answer1.setPictureanswer(answer.getPictureanswer());
        answer1.setRemarks(answer.getRemarks());
        answer1.setTbname(answer.getTbname());

        int i = this.answerMapper.insertAnswer(answer1);
        if (i > 0) {
            return RespBean.ok("成功创建了一个样品",answer1);
        } else {
            return RespBean.error("创建样品失败...");
        }
    }

    /**
     * 修改数据
     *
     * @param answer 实例对象
     * @return 实例对象
     */
    @Override
    public Answer updateAnswer(Answer answer) {
        int update = this.answerMapper.updateAnswer(answer);
        if(update > 0){
            return this.queryById(answer.getId());
        }
        return this.queryById(answer.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteByIdAnswer(Integer id) {
        return this.answerMapper.deleteByIdAnswer(id) > 0;
    }

    //查询全部Answer
    @Override
    public List<Answer> lists() {
        QueryWrapper queryWrapper = new QueryWrapper();
        return answerMapper.selectList(queryWrapper.select("id","tbname","wordanswer","pictureanswer","problemtype","remarks"));
    }
}
