package com.auditquery.dao;

import com.auditquery.entity.Fortifymobile;
import com.auditquery.entity.Fortifyphp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Fortifyphp)表数据库访问层
 *
 * @author makejava
 * @since 2024-02-22 22:16:10
 */
public interface FortifyphpMapper extends BaseMapper<Fortifyphp> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Fortifyphp queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param fortifyphp 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Fortifyphp> queryAllByLimit(Fortifyphp fortifyphp, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param fortifyphp 查询条件
     * @return 总行数
     */
    long count(Fortifyphp fortifyphp);

    /**
     * 新增数据
     *
     * @param fortifyphp 实例对象
     * @return 影响行数
     */
    int insertFortifyphp(Fortifyphp fortifyphp);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Fortifyphp> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Fortifyphp> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Fortifyphp> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Fortifyphp> entities);

    /**
     * 修改数据
     *
     * @param fortifyphp 实例对象
     * @return 影响行数
     */
    int updateFortifyphp(Fortifyphp fortifyphp);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteByIdFortifyphp(Integer id);

}

