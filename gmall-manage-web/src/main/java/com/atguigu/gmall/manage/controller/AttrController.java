package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.beans.PmsBaseAttrInfo;
import com.atguigu.gmall.beans.PmsBaseAttrValue;
import com.atguigu.gmall.beans.PmsBaseSaleAttr;
import com.atguigu.gmall.beans.PmsProductInfo;
import com.atguigu.gmall.user.service.AttrService;
import com.sun.net.httpserver.Authenticator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

/**
 * Created by jiayu on 2020/7/1.
 */
@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class AttrController {
    @Reference
    AttrService attrService;

    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
       String str= attrService.saveAttrInfo(pmsBaseAttrInfo);
        return str;

    }

    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String Catalog3Id){
        List<PmsBaseAttrInfo> list=  attrService.attrInfoList(Catalog3Id);
        return list;

    }


    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){
        List<PmsBaseAttrValue> list=attrService.getAttrValueList(attrId);
        return list;

    }
    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> baseSaleAttrList(){
        List<PmsBaseSaleAttr> list=attrService.baseSaleAttrList();
        return list;

    }

}
