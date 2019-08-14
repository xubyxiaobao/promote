package com.system.promote;

import com.system.promote.dao.ProductMapper;
import com.system.promote.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan(basePackages = {"com.system.promote.dao"})
public class PromoteApplicationTests {

    @Autowired
    private ProductMapper productMapper;
    @Test
    public void contextLoads() {

        List<Product> products = productMapper.queryAll();
        System.out.println("OK");
    }

}
