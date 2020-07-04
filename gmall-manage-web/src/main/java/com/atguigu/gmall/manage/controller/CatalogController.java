package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.beans.PmsBaseCatalog1;

import com.atguigu.gmall.beans.PmsBaseCatalog2;
import com.atguigu.gmall.beans.PmsBaseCatalog3;
import com.atguigu.gmall.user.service.CatalogService;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by jiayu on 2020/7/1.
 */
@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class CatalogController {
    @Reference
    CatalogService catalog1Service;
    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1(){
        List<PmsBaseCatalog1> list=catalog1Service.getCatalog1();
        return  list;
    }
    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id){
        List<PmsBaseCatalog2> list=catalog1Service.getCatalog2(catalog1Id);
        return  list;
    }
    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id){
        List<PmsBaseCatalog3> list=catalog1Service.getCatalog3(catalog2Id);
        return  list;
    }

}
