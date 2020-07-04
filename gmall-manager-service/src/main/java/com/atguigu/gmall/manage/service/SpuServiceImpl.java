package com.atguigu.gmall.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.beans.*;
import com.atguigu.gmall.manage.mapper.PmsProductImageMapper;
import com.atguigu.gmall.manage.mapper.PmsProductInfoMapper;
import com.atguigu.gmall.manage.mapper.PmsProductSaleAttrMapper;
import com.atguigu.gmall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.atguigu.gmall.user.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by jiayu on 2020/7/2.
 */
@Service
public class SpuServiceImpl implements SpuService {
    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;
    @Autowired
    PmsProductImageMapper pmsProductImageMapper;
    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;
    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo=new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        List<PmsProductInfo> list=pmsProductInfoMapper.select(pmsProductInfo);
        return list;
    }

    @Override
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {
        pmsProductInfoMapper.insert(pmsProductInfo);
        String id=pmsProductInfo.getId();
        //保存商品图片信息
        List<PmsProductImage> pmsProductImages=pmsProductInfo.getSpuImageList();
       for(PmsProductImage pmsProductImage:pmsProductImages) {
           pmsProductImage.setProductId(id);
           pmsProductImageMapper.insert(pmsProductImage);
       }
        //保存图片信息
        List<PmsProductSaleAttr> pmsProductSaleAttrs=pmsProductInfo.getSpuSaleAttrList();
       for(PmsProductSaleAttr pmsProductSaleAttr:pmsProductSaleAttrs) {
           pmsProductSaleAttr.setProductId(id);
           pmsProductSaleAttrMapper.insert(pmsProductSaleAttr);
       }

        //保存销售属性信息


    }

    @Override
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId) {
        PmsProductSaleAttr t=new PmsProductSaleAttr();
        t.setProductId(spuId);
        List<PmsProductSaleAttr> pmsProductSaleAttrs=pmsProductSaleAttrMapper.select(t);
        for (PmsProductSaleAttr pmsProductSaleAttr:pmsProductSaleAttrs){
            PmsProductSaleAttrValue pmsProductSaleAttrValue=new PmsProductSaleAttrValue();
            pmsProductSaleAttrValue.setProductId(spuId);
            pmsProductSaleAttrValue.setSaleAttrId(pmsProductSaleAttr.getSaleAttrId());
            List<PmsProductSaleAttrValue> pmsProductSaleAttrValues=pmsProductSaleAttrValueMapper.select(pmsProductSaleAttrValue);
            pmsProductSaleAttr.setSpuSaleAttrValueList(pmsProductSaleAttrValues);
        }
        return pmsProductSaleAttrs;
    }

    @Override
    public List<PmsProductImage> spuImageList(String spuId) {
        PmsProductImage t=new PmsProductImage();
        t.setProductId(spuId);
        List<PmsProductImage> pmsProductImages=pmsProductImageMapper.select(t);
        return pmsProductImages;
    }


}
