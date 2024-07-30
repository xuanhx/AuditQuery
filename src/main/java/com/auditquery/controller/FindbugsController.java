package com.auditquery.controller;

import com.auditquery.entity.Findbugs;
import com.auditquery.service.FindbugsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Findbugs)表控制层
 *
 * @author makejava
 * @since 2024-02-22 22:14:46
 */
@RestController
@RequestMapping("/findbugs")
public class FindbugsController {
    /**
     * 服务对象
     */
    @Resource
    private FindbugsService findbugsService;



//    //结合Answer查询
//    @GetMapping("/searchFindbugs/")
//    public ResponseEntity<Findbugs> queryById(@PathVariable("id") String problemtype) {
//        return ResponseEntity.ok(this.findbugsService.queryById(problemtype));
//    }

    /**
     * 分页查询
     *
     * @param findbugs 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Findbugs>> queryByPage(Findbugs findbugs, PageRequest pageRequest) {
        return ResponseEntity.ok(this.findbugsService.queryByPage(findbugs, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public ResponseEntity<Findbugs> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.findbugsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param findbugs 实体
     * @return 新增结果
     */
    @PostMapping("/addFindbugs")
    public ResponseEntity<Findbugs> add(Findbugs findbugs) {
        return ResponseEntity.ok(this.findbugsService.insertFindbugs(findbugs));
    }

    /**
     * 编辑数据
     *
     * @param findbugs 实体
     * @return 编辑结果
     */
    @PutMapping("/editFindbugs")
    public ResponseEntity<Findbugs> edit(Findbugs findbugs) {
        return ResponseEntity.ok(this.findbugsService.updateFindbugs(findbugs));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/deleteFindbugs")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.findbugsService.deleteByIdFindbugs(id));
    }

}

