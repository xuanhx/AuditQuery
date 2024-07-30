package com.auditquery.dao;

import com.auditquery.entity.Findbugs;
import com.auditquery.entity.Fortify;
import com.auditquery.entity.RespBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Map;

/**
 * (Fortify)表数据库访问层
 *
 * @author makejava
 * @since 2024-02-22 22:15:24
 */
public interface FortifyMapper extends BaseMapper<Fortify> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Fortify queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param fortify 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Fortify> queryAllByLimit(Fortify fortify, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param fortify 查询条件
     * @return 总行数
     */
    long count(Fortify fortify);

    /**
     * 新增数据
     *
     * @param fortify 实例对象
     * @return 影响行数
     */
    int insertFortify(Fortify fortify);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Fortify> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Fortify> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Fortify> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Fortify> entities);

    /**
     * 修改数据
     *
     * @param fortify 实例对象
     * @return 影响行数
     */
    int updateFortify(Fortify fortify);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteByIdFortify(Integer id);

    //结合Answer查询
    List searchFortify(String problemtype);
}

