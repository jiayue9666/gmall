package com.atguigu.gmall.user.service;

import com.atguigu.gmall.beans.PmsBaseCatalog1;
import com.atguigu.gmall.beans.PmsBaseCatalog2;
import com.atguigu.gmall.beans.PmsBaseCatalog3;



import java.util.List;

/**
 * Created by jiayu on 2020/7/1.
 */

public interface CatalogService {
    List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
