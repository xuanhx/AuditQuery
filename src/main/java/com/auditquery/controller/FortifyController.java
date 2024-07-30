package com.auditquery.controller;

import com.auditquery.entity.Fortify;
import com.auditquery.entity.RespBean;
import com.auditquery.entity.tFortifyAnswer;
import com.auditquery.service.FortifyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Fortify)表控制层
 *
 * @author makejava
 * @since 2024-02-22 22:15:24
 */
@Slf4j
@Controller
@RequestMapping("/fortify")
public class FortifyController {
    /**
     * 服务对象
     */
    @Autowired
    private FortifyService fortifyService;


    @RequestMapping("/test")
    public String test1(){
        return "Fortify";
    }


    //结合Answer查询
    //@ResponseBody
    @RequestMapping("/searchFortify")///{problemtype}  @PathVariable("problemtype")
    public String searchFortify(Model model,String problemtype) {
        List<tFortifyAnswer> tFortifyAnswerList = fortifyService.searchFortify(problemtype);
        model.addAttribute("tFortifyAnswerList",tFortifyAnswerList);
        return "fortifyAnswer";
    }

    @RequestMapping("/search")
    public String search() {
        return "Fortify";
    }

    /**
     * 分页查询
     *
     * @param fortify 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Fortify>> queryByPage(Fortify fortify, PageRequest pageRequest) {
        return ResponseEntity.ok(this.fortifyService.queryByPage(fortify, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public ResponseEntity<Fortify> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.fortifyService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param fortify 实体
     * @return 新增结果
     */
    @PostMapping("/addFortify")
    public ResponseEntity<Fortify> add(Fortify fortify) {
        return ResponseEntity.ok(this.fortifyService.insertFortify(fortify));
    }

    /**
     * 编辑数据
     *
     * @param fortify 实体
     * @return 编辑结果
     */
    @PutMapping("/editFortify")
    public ResponseEntity<Fortify> edit(Fortify fortify) {
        return ResponseEntity.ok(this.fortifyService.updateFortify(fortify));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/deleteFortify")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.fortifyService.deleteByIdFortify(id));
    }

}

