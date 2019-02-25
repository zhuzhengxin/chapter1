package com.sid.demo.service.impl;

import com.sid.demo.entity.Kl8;
import com.sid.demo.dao.Kl8Dao;
import com.sid.demo.service.Kl8Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (Kl8)表服务实现类
 *
 * @author makejava
 * @since 2019-02-21 16:33:06
 */
@Service("kl8Service")
public class Kl8ServiceImpl implements Kl8Service {
    @Resource
    private Kl8Dao kl8Dao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Kl8 queryById(String id) {
        return this.kl8Dao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Kl8> queryAllByLimit(int offset, int limit) {
        return this.kl8Dao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param
     * @return 实例对象
     */
    @Override
    public void insert() {
        long s2= System.currentTimeMillis();
        String pathname = "C:\\Users\\DELL\\Desktop\\happy8\\happy8\\快乐8.txt"; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            List<Kl8> collect = br.lines().parallel().map(s -> {
                 String [] s1 =s.split(",");
                 String winning_number1 = Integer.parseInt(s1[1]) +Integer.parseInt(s1[2])+Integer.parseInt(s1[3]) +Integer.parseInt(s1[4]) +Integer.parseInt(s1[5]) +Integer.parseInt(s1[6]) +"";
                 String winning_number2 = Integer.parseInt(s1[7]) +Integer.parseInt(s1[8])+Integer.parseInt(s1[9]) +Integer.parseInt(s1[10]) +Integer.parseInt(s1[11]) +Integer.parseInt(s1[12])+"";
                 String winning_number3 = Integer.parseInt(s1[11]) +Integer.parseInt(s1[12])+Integer.parseInt(s1[13]) +Integer.parseInt(s1[16]) +Integer.parseInt(s1[17]) +Integer.parseInt(s1[18])+"";
                 int a1 =Integer.parseInt(winning_number1.substring(winning_number1.length()-1));
                 int a2 = Integer.parseInt(winning_number2.substring(winning_number2.length()-1));
                 int a3 = Integer.parseInt(winning_number3.substring(winning_number3.length()-1));
                 int winning_number =a1+a2+a3;
                 int big_small =winning_number>13?1:0;
                 int even_odd =winning_number % 2 == 1 ?1:0;
                Kl8 kl = new Kl8();
                kl.setSmall(big_small);
                kl.setNumber(winning_number);
                kl.setOdd(even_odd);
                // 一次读入一行数据
                return kl;
            }).collect(Collectors.toList());
            this.kl8Dao.insert(collect);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long s3= System.currentTimeMillis();
        System.out.println("执行时间---"+(s3-s2));
    }

    /**
     * 修改数据
     *
     * @param kl8 实例对象
     * @return 实例对象
     */
    @Override
    public Kl8 update(Kl8 kl8) {
        this.kl8Dao.update(kl8);
        return this.queryById(kl8.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.kl8Dao.deleteById(id) > 0;
    }
}