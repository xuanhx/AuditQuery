package com.auditquery.controller;

import com.auditquery.entity.Answer;
import com.auditquery.entity.RespBean;
import com.auditquery.service.AnswerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (Answer)表控制层
 *
 * @author makejava
 * @since 2024-02-22 22:14:21
 */
@Slf4j
@Controller
@RequestMapping("/answer")
public class AnswerController {
    /**
     * 服务对象
     */
    @Autowired
    private AnswerService answerService;

    /**
     * 分页查询
     *
     * @param answer 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Answer>> queryByPage(Answer answer, PageRequest pageRequest) {
        return ResponseEntity.ok(this.answerService.queryByPage(answer, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public ResponseEntity<Answer> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.answerService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param answer 实体
     * @return 新增结果
     */
    @RequestMapping("/addAnswer")
    public String add(Answer answer) {
        System.out.println(answer);
        answerService.insertAnswer(answer);
        return "redirect:/answer/lists";
    }
    @RequestMapping("/add")
    public String add() {
        return "addAnswer";
    }

    @RequestMapping(value = "/lists")
    public  String lists(Model model){
        log.info("查询所有Answer信息");
        List<Answer> answerList = answerService.lists();
        model.addAttribute("answerList",answerList);
        return "answer";
    }

    /**
     * 编辑数据
     *
     * @param answer 实体
     * @return 编辑结果
     */
    @PutMapping("/editAnswer")
    public ResponseEntity<Answer> edit(Answer answer) {
        return ResponseEntity.ok(this.answerService.updateAnswer(answer));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/deleteAnswer")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.answerService.deleteByIdAnswer(id));
    }

}

