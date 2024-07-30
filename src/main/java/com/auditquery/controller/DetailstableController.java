package com.auditquery.controller;

import com.auditquery.entity.Answer;
import com.auditquery.entity.Detailstable;
import com.auditquery.service.DetailstableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Detailstable)表控制层
 *
 * @author makejava
 * @since 2024-03-05 16:51:57
 */
@Slf4j
@Controller
@RequestMapping("/detailstable")
public class DetailstableController {
    /**
     * 服务对象
     */
    @Resource
    private DetailstableService detailstableService;

    /**
     * 分页查询
     *
     * @param detailstable 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Detailstable>> queryByPage(Detailstable detailstable, PageRequest pageRequest) {
        return ResponseEntity.ok(this.detailstableService.queryByPage(detailstable, pageRequest));
    }

    @RequestMapping(value = "/lists")
    public  String lists(Model model){
        log.info("查询所有员工信息");
        List<Detailstable> detailstableList = detailstableService.lists();
        model.addAttribute("detailstableList",detailstableList);
        return "detailstable";
    }
    //updatedetailstable
    @RequestMapping("/update")
    public String update() {
        return "updatedetailstable";
    }

    @RequestMapping("/updatedetailstable")
    public String updatedetailstable(Detailstable detailstable) {
        System.out.println(detailstable);
        int i = detailstableService.updateDetailstable(detailstable);
        if (i ==1){
            return "redirect:/detailstable/update";//还没写
        }else {
            return "redirect:/detailstable/update";
        }

    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Detailstable> queryById(@PathVariable("id")String  id) {
        return ResponseEntity.ok(this.detailstableService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param detailstable 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Detailstable> add(Detailstable detailstable) {
        return ResponseEntity.ok(this.detailstableService.insert(detailstable));
    }

    /**
     * 编辑数据
     *
     * @param detailstable 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Detailstable> edit(Detailstable detailstable) {
        return ResponseEntity.ok(this.detailstableService.update(detailstable));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.detailstableService.deleteById(id));
    }

}

