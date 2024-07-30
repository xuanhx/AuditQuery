package com.auditquery.service;

import com.auditquery.entity.Answer;
import com.auditquery.entity.RespBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.HashMap;
import java.util.List;

/**
 * (Answer)表服务接口
 *
 * @author makejava
 * @since 2024-02-22 22:14:24
 */
public interface AnswerService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Answer queryById(Integer id);

    /**
     * 分页查询
     *
     * @param answer 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Answer> queryByPage(Answer answer, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param answer 实例对象
     * @return 实例对象
     */
    RespBean insertAnswer(Answer answer);

    /**
     * 修改数据
     *
     * @param answer 实例对象
     * @return 实例对象
     */
    Answer updateAnswer(Answer answer);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteByIdAnswer(Integer id);

    ////查询全部Answer
    List<Answer> lists();
}
