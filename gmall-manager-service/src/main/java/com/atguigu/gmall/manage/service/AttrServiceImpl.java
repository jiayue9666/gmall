package com.atguigu.gmall.manage.service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.beans.PmsBaseAttrInfo;
import com.atguigu.gmall.beans.PmsBaseAttrValue;
import com.atguigu.gmall.beans.PmsBaseSaleAttr;
import com.atguigu.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.atguigu.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.atguigu.gmall.manage.mapper.PmsBaseSaleAttrMapper;
import com.atguigu.gmall.user.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiayu on 2020/7/1.
 */
@Service
public class AttrServiceImpl implements AttrService {
    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;
    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;
    @Autowired
    PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;
    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo info=new PmsBaseAttrInfo();
        info.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> list=pmsBaseAttrInfoMapper.select(info);
        for(PmsBaseAttrInfo pmsBaseAttrInfo:list){
            List<PmsBaseAttrValue> pmsBaseAttrValues=new ArrayList<PmsBaseAttrValue>();
            PmsBaseAttrValue pmsBaseAttrValue=new PmsBaseAttrValue();
            pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
            pmsBaseAttrValues=pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
            pmsBaseAttrInfo.setAttrValueList(pmsBaseAttrValues);
        }
        return list;
    }

    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        String id=pmsBaseAttrInfo.getId();
        if(StringUtils.isBlank(id)){
            pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);
            List<PmsBaseAttrValue> attrValueList=pmsBaseAttrInfo.getAttrValueList();
            for(PmsBaseAttrValue pmsBaseAttrValue:attrValueList){
                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
            }
        }
        else {
            //修改平台属性
            Example example =new Example(PmsBaseAttrInfo.class);
            example.createCriteria().andEqualTo("id",pmsBaseAttrInfo.getId());
            pmsBaseAttrInfoMapper.updateByExampleSelective(pmsBaseAttrInfo,example);

            //按照属性id删除属性值
            PmsBaseAttrValue pmsBaseAttrDel=new PmsBaseAttrValue();
            pmsBaseAttrDel.setAttrId(pmsBaseAttrInfo.getId());
            pmsBaseAttrValueMapper.delete(pmsBaseAttrDel);
            //属性值修改
            List<PmsBaseAttrValue> attrValueList=pmsBaseAttrInfo.getAttrValueList();
            for(PmsBaseAttrValue pmsBaseAttrValue1:attrValueList){
                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue1);
            }
        }


        return "success";
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        PmsBaseAttrValue pmsBaseAttrValue=new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
       List<PmsBaseAttrValue> pmsBaseAttrValues= pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
       return pmsBaseAttrValues;

    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        PmsBaseSaleAttr pmsBaseSaleAttr=new PmsBaseSaleAttr();
        List<PmsBaseSaleAttr> pmsBaseSaleAttrs=pmsBaseSaleAttrMapper.selectAll();
        return pmsBaseSaleAttrs;
    }
}
