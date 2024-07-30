package com.auditquery.dao;

import com.auditquery.entity.Answer;
import com.auditquery.entity.Findbugs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Findbugs)表数据库访问层
 *
 * @author makejava
 * @since 2024-02-22 22:14:46
 */
public interface FindbugsMapper extends BaseMapper<Findbugs> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Findbugs queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param findbugs 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Findbugs> queryAllByLimit(Findbugs findbugs, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param findbugs 查询条件
     * @return 总行数
     */
    long count(Findbugs findbugs);

    /**
     * 新增数据
     *
     * @param findbugs 实例对象
     * @return 影响行数
     */
    int insertFindbugs(Findbugs findbugs);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Findbugs> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Findbugs> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Findbugs> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Findbugs> entities);

    /**
     * 修改数据
     *
     * @param findbugs 实例对象
     * @return 影响行数
     */
    int updateFindbugs(Findbugs findbugs);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteByIdFindbugs(Integer id);

}

