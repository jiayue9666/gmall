package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.beans.PmsProductImage;
import com.atguigu.gmall.beans.PmsProductInfo;
import com.atguigu.gmall.beans.PmsProductSaleAttr;
import com.atguigu.gmall.manage.util.PmsUploadUtil;
import com.atguigu.gmall.user.service.SpuService;
import org.csource.fastdfs.ClientGlobal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by jiayu on 2020/7/2.
 */
@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class SpuController {
    @Reference
    SpuService spuService;

    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String Catalog3Id){
        List<PmsProductInfo> list=spuService.spuList(Catalog3Id);
        return list;
    }
    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){
        spuService.saveSpuInfo(pmsProductInfo);
        return "success";
    }
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUploud(@RequestParam("file")MultipartFile multipartFile){

        String imgUrl= PmsUploadUtil.uploudImage(multipartFile);

        return imgUrl;
    }
    @RequestMapping("spuSaleAttrList")
    @ResponseBody
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId){

        List<PmsProductSaleAttr> list=spuService.spuSaleAttrList(spuId);

        return list;
    }


    @RequestMapping("spuImageList")
    @ResponseBody
    public List<PmsProductImage> spuImageList(String spuId){

        List<PmsProductImage> list=spuService.spuImageList(spuId);

        return list;
    }

}
