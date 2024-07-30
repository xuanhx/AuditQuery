package com.auditquery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Fortifyphp)实体类
 *
 * @author makejava
 * @since 2024-02-22 22:16:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)   //setter方法返回当前对象
public class Fortifyphp implements Serializable {
    private static final long serialVersionUID = 839410164167685118L;
    /**
     * 序号
     */
    private Integer id;
    /**
     * 规则名称
     */
    private String problemtype;
    /**
     * 对应规范编号
     */
    private String nums;
    /**
     * 类别
     */
    private String classification;
    /**
     * 子类别
     */
    private String subcategory;
    /**
     * 规则概要
     */
    private String outline;
    /**
     * 规则描述
     */
    private String describes;
    /**
     * 修复建议
     */
    private String propose;
    /**
     * 等级
     */
    private String grade;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 类型
     */
    private String ruletype;

}

