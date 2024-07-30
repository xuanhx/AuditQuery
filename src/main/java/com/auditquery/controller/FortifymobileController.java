package com.auditquery.controller;

import com.auditquery.entity.Fortifymobile;
import com.auditquery.service.FortifymobileService;
import com.auditquery.service.FortifymobileService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Fortifymobile)表控制层
 *
 * @author makejava
 * @since 2024-02-22 22:15:56
 */
@RestController
@RequestMapping("/fortifymobile")
public class FortifymobileController {
    /**
     * 服务对象
     */
    @Resource
    private FortifymobileService fortifymobileService;

    /**
     * 分页查询
     *
     * @param fortifymobile 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Fortifymobile>> queryByPage(Fortifymobile fortifymobile, PageRequest pageRequest) {
        return ResponseEntity.ok(this.fortifymobileService.queryByPage(fortifymobile, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public ResponseEntity<Fortifymobile> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.fortifymobileService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param fortifymobile 实体
     * @return 新增结果
     */
    @PostMapping("/addFortifymobile")
    public ResponseEntity<Fortifymobile> add(Fortifymobile fortifymobile) {
        return ResponseEntity.ok(this.fortifymobileService.insertFortifymobile(fortifymobile));
    }

    /**
     * 编辑数据
     *
     * @param fortifymobile 实体
     * @return 编辑结果
     */
    @PutMapping("/editFortifymobile")
    public ResponseEntity<Fortifymobile> edit(Fortifymobile fortifymobile) {
        return ResponseEntity.ok(this.fortifymobileService.updateFortifymobile(fortifymobile));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/deleteFortifymobile")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.fortifymobileService.deleteByIdFortifymobile(id));
    }

}

