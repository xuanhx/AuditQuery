package com.auditquery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Detailstable)实体类
 *
 * @author makejava
 * @since 2024-03-05 16:51:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)   //setter方法返回当前对象
public class Detailstable implements Serializable {
    private static final long serialVersionUID = -10437017404192134L;
    /**
     * 序号
     */
    private String id;
    /**
     * 问题编号
     */
    private String questionnumber;
    /**
     * 测试年份
     */
    private String testyear;
    /**
     * 测试单位
     */
    private String testunit;
    /**
     * 测试人员
     */
    private String testpeople;
    /**
     * 测试人员联系方式
     */
    private String testpeoplelink;
    /**
     * 缺陷/风险层面
     */
    private String risklevel;
    /**
     * 资产/系统名称
     */
    private String systemname;
    /**
     * 系统版本
     */
    private String systemversion;
    /**
     * 组件名称
     */
    private String componentname;
    /**
     * 问题描述
     */
    private String problemdescription;
    /**
     * 风险位置
     */
    private String risklocation;
    /**
     * 问题等级
     */
    private String problemlevel;
    /**
     * 问题发现时间
     */
    private String problemtime;
    /**
     * 要求整改时间
     */
    private String requesttime;
    /**
     * 整改完成时间
     */
    private String completiontime;
    /**
     * 是否已整改
     */
    private String yesorno;
    /**
     * 责任单位
     */
    private String responsibleunit;
    /**
     * 责任人
     */
    private String responsibleperson;
    /**
     * 责任人联系方式
     */
    private String responsiblepersonlink;
    /**
     * 测试申请单号
     */
    private String applicationnumber;
    /**
     * 备注
     */
    private String remarks;



}

