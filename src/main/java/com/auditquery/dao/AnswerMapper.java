package com.auditquery.dao;

import com.auditquery.entity.Answer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Answer)表数据库访问层
 *
 * @author makejava
 * @since 2024-02-22 22:14:22
 */
@Repository
public interface AnswerMapper extends BaseMapper<Answer> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Answer queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param answer 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Answer> queryAllByLimit(Answer answer, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param answer 查询条件
     * @return 总行数
     */
    long count(Answer answer);

    /**
     * 新增数据
     *
     * @param answer 实例对象
     * @return 影响行数
     */
    int insertAnswer(Answer answer);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Answer> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Answer> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Answer> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Answer> entities);

    /**
     * 修改数据
     *
     * @param answer 实例对象
     * @return 影响行数
     */
    int updateAnswer(Answer answer);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteByIdAnswer(Integer id);

}

