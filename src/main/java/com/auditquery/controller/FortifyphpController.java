package com.auditquery.controller;

import com.auditquery.entity.Fortifyphp;
import com.auditquery.service.FortifyphpService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Fortifyphp)表控制层
 *
 * @author makejava
 * @since 2024-02-22 22:16:10
 */
@RestController
@RequestMapping("/fortifyphp")
public class FortifyphpController {
    /**
     * 服务对象
     */
    @Resource
    private FortifyphpService fortifyphpService;

    /**
     * 分页查询
     *
     * @param fortifyphp 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Fortifyphp>> queryByPage(Fortifyphp fortifyphp, PageRequest pageRequest) {
        return ResponseEntity.ok(this.fortifyphpService.queryByPage(fortifyphp, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public ResponseEntity<Fortifyphp> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.fortifyphpService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param fortifyphp 实体
     * @return 新增结果
     */
    @PostMapping("/addFortifyphp")
    public ResponseEntity<Fortifyphp> add(Fortifyphp fortifyphp) {
        return ResponseEntity.ok(this.fortifyphpService.insertFortifyphp(fortifyphp));
    }

    /**
     * 编辑数据
     *
     * @param fortifyphp 实体
     * @return 编辑结果
     */
    @PutMapping("/editFortifyphp")
    public ResponseEntity<Fortifyphp> edit(Fortifyphp fortifyphp) {
        return ResponseEntity.ok(this.fortifyphpService.updateFortifyphp(fortifyphp));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/deleteFortifyphp")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.fortifyphpService.deleteByIdFortifyphp(id));
    }

}

