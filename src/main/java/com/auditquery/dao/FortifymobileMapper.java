package com.auditquery.dao;

import com.auditquery.entity.Fortify;
import com.auditquery.entity.Fortifymobile;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Fortifymobile)表数据库访问层
 *
 * @author makejava
 * @since 2024-02-22 22:15:56
 */
public interface FortifymobileMapper extends BaseMapper<Fortifymobile> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Fortifymobile queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param fortifymobile 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Fortifymobile> queryAllByLimit(Fortifymobile fortifymobile, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param fortifymobile 查询条件
     * @return 总行数
     */
    long count(Fortifymobile fortifymobile);

    /**
     * 新增数据
     *
     * @param fortifymobile 实例对象
     * @return 影响行数
     */
    int insertFortifymobile(Fortifymobile fortifymobile);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Fortifymobile> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Fortifymobile> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Fortifymobile> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Fortifymobile> entities);

    /**
     * 修改数据
     *
     * @param fortifymobile 实例对象
     * @return 影响行数
     */
    int updateFortifymobile(Fortifymobile fortifymobile);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteByIdFortifymobile(Integer id);

}

