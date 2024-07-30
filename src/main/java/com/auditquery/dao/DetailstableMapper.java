package com.auditquery.dao;

import com.auditquery.entity.Answer;
import com.auditquery.entity.Detailstable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Detailstable)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-05 16:51:57
 */
@Repository
public interface DetailstableMapper  extends BaseMapper<Detailstable> {

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    Detailstable queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param detailstable 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Detailstable> queryAllByLimit(Detailstable detailstable, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param detailstable 查询条件
     * @return 总行数
     */
    long count(Detailstable detailstable);

    /**
     * 新增数据
     *
     * @param detailstable 实例对象
     * @return 影响行数
     */
    int insert(Detailstable detailstable);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Detailstable> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Detailstable> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Detailstable> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Detailstable> entities);

    /**
     * 修改数据
     *
     * @param detailstable 实例对象
     * @return 影响行数
     */
    int update(Detailstable detailstable);

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 影响行数
     */
    int deleteById(String id);

    int updateDetailstable(Detailstable detailstable);
}

