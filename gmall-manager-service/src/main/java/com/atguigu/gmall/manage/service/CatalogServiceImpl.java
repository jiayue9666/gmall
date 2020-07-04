package com.atguigu.gmall.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.beans.PmsBaseCatalog1;
import com.atguigu.gmall.beans.PmsBaseCatalog2;
import com.atguigu.gmall.beans.PmsBaseCatalog3;
import com.atguigu.gmall.manage.mapper.PmsBaseCatalog1Mapper;
import com.atguigu.gmall.manage.mapper.PmsBaseCatalog2Mapper;
import com.atguigu.gmall.manage.mapper.PmsBaseCatalog3Mapper;
import com.atguigu.gmall.user.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Created by jiayu on 2020/7/1.
 */
@Service
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;
    @Autowired
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;
    @Autowired
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        List<PmsBaseCatalog1> list=pmsBaseCatalog1Mapper.selectAll();
        return list;
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        PmsBaseCatalog2 t=new PmsBaseCatalog2();
        t.setCatalog1Id(catalog1Id);
        List<PmsBaseCatalog2> list=pmsBaseCatalog2Mapper.select(t);
        return list;
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        PmsBaseCatalog3 t=new PmsBaseCatalog3();
        t.setCatalog2Id(catalog2Id);
        List<PmsBaseCatalog3> list=pmsBaseCatalog3Mapper.select(t);
        return list;
    }
}
