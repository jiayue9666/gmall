package com.atguigu.gmall.manage.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by jiayu on 2020/7/3.
 */
public class PmsUploadUtil {


    public static String uploudImage(MultipartFile multipartFile) {
        String imgUrl="192.168.0.109";
        String tracker=PmsUploadUtil.class.getResource("/tracker.conf").getPath();
        try {
            ClientGlobal.init(tracker);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TrackerClient trackerClient=new TrackerClient();
        TrackerServer trackerServer=null;
        try {
            trackerServer=trackerClient.getTrackerServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
      StorageClient storageClient=new StorageClient(trackerServer);
        try{
            byte[]bytes=multipartFile.getBytes();//获得上传文件 的 二进制
            String originalFilename=multipartFile.getOriginalFilename();
            System.out.println(originalFilename);
            int index=originalFilename.lastIndexOf(".");
            String extName=originalFilename.substring(index+1);
            String []uploadInfos=storageClient.upload_file(bytes,extName,null);

            for(String uploadInfo:uploadInfos){
                imgUrl+="/"+uploadInfo;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return imgUrl;
    }

    ;
}
