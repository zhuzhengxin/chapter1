package com.sid.demo.controller;

import com.sid.demo.service.Kl8Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.List;

import static com.sid.demo.ReadTxt.readFile;

/**
 * (Kl8)表控制层
 *
 * @author makejava
 * @since 2019-02-21 16:33:07
 */
@RestController
@RequestMapping("kl8")
public class Kl8Controller {
    /**
     * 服务对象
     */
    @Resource
    private Kl8Service kl8Service;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public void selectOne(String id) {
        //List<String> li = readFile();

        this.kl8Service.insert();

    }

}