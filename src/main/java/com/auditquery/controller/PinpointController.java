package com.auditquery.controller;

import com.auditquery.entity.Pinpoint;
import com.auditquery.service.PinpointService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Pinpoint)表控制层
 *
 * @author makejava
 * @since 2024-02-22 22:15:39
 */
@RestController
@RequestMapping("/pinpoint")
public class PinpointController {
    /**
     * 服务对象
     */
    @Resource
    private PinpointService pinpointService;

    /**
     * 分页查询
     *
     * @param pinpoint 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Pinpoint>> queryByPage(Pinpoint pinpoint, PageRequest pageRequest) {
        return ResponseEntity.ok(this.pinpointService.queryByPage(pinpoint, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public ResponseEntity<Pinpoint> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.pinpointService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param pinpoint 实体
     * @return 新增结果
     */
    @PostMapping("/addPinpoint")
    public ResponseEntity<Pinpoint> add(Pinpoint pinpoint) {
        return ResponseEntity.ok(this.pinpointService.insertPinpoint(pinpoint));
    }

    /**
     * 编辑数据
     *
     * @param pinpoint 实体
     * @return 编辑结果
     */
    @PutMapping("/editPinpoint")
    public ResponseEntity<Pinpoint> edit(Pinpoint pinpoint) {
        return ResponseEntity.ok(this.pinpointService.updatePinpoint(pinpoint));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/deletePinpoint")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.pinpointService.deleteByIdPinpoint(id));
    }

}

