package com.auditquery.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * (Answer)实体类
 *
 * @author makejava
 * @since 2024-02-22 22:14:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)   //setter方法返回当前对象
public class Answer implements Serializable {
    private static final long serialVersionUID = 408407320153455357L;

    @TableId(type = IdType.AUTO)
    private Integer id;
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
    
    private String remarks;
    /**
     * 表名
     */
    private String tbname;

    private List<tFortifyAnswer> tFortifyAnswer;
}

