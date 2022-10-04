package com.example.mall.service;

import com.example.mall.service.imp.UpLoadServiceImp;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class UpLoadService implements UpLoadServiceImp {
    private String result=null;
    @Override
    public String upLoad(InputStream inputStream, String FileName) {
        //构造一个带指定 Region 对象的配置类

        Configuration cfg = new Configuration(Zone.zone0());
        //cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本
//...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传
        String accessKey = "-8AowYUVXWbcTbmDX1e2jWCF3oBugGqxMBKQKSGP";
        String secretKey = "Kd8m4BbsJFJURN6K-AHtjOen6HU-d7uyhLpRm5di";
        String bucket = "mall-tet";
//如果是Windows情况下，格式是 D:\\qiniu\\test.png
        String localFilePath = "/home/qiniu/test.png";
//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
            if (response.statusCode == 200) {
                result= ' '+FileName;
            }
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
