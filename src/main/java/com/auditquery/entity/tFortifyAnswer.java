package com.auditquery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)   //setter方法返回当前对象
public class tFortifyAnswer implements Serializable {
    private static final long serialVersionUID = 1L;

    private String tbname;

    /**
     * 问题类型
     */
    private String problemtype;
    /**
     * 文字回答
     */
    private String wordanswer;
    /**
     * 图片回答
     */
    private String pictureanswer;

    /**
     * 修复建议
     */
    private String propose;
}
