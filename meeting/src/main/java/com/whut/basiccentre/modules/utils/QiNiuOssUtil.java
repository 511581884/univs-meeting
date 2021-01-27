package com.whut.basiccentre.modules.utils;

import cn.hutool.core.util.StrUtil;
import com.google.gson.Gson;
import com.whut.basiccentre.frame.exception.AppException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URLEncoder;

@Slf4j
public class QiNiuOssUtil {

    private static String accessKey = "IlIykJ5kjc1x1IxZpf9FSbrThIccA1GF5FE5S_MP";
    private static String secretKey = "N2JJkD9xXBRJGfNMEho8kWSW6ZysocME5yqNPejP";

    public static String bucket = "basiccentre";

    /**
     * 保存文件
     *
     * @param bucket      保存到哪个桶， 直接 用 QiNiuOssUtil.bucket 即可
     * @param inputStream 文件流
     */
    public static void saveFile(String bucket, InputStream inputStream, String fileName) {

        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.autoRegion());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);


        try {

            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);

            Response response = uploadManager.put(inputStream, fileName, upToken, null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

        } catch (Exception ex) {

            log.error("", ex);
            throw new AppException("文件上传失败");
        }
    }

    public static String getQiNiuToken(String bucket) {
        Auth auth = Auth.create(accessKey, secretKey);
        return auth.uploadToken(bucket);
    }

    /**
     * 获取文件url
     *
     * @param fileName        文件名称
     * @param expireInSeconds 链接失效时间 单位秒
     * @return
     */
    public static String genUrl(String fileName, long expireInSeconds) {
        if (StrUtil.isBlank(fileName)) {
            return null;
        }
        Configuration cfg = new Configuration(Region.autoRegion());
        Auth auth = Auth.create(accessKey, secretKey);
        String fileUrl = fileName;
        String domainOfBucket = "http://qiniu.basiccentre.com/";
        try {
            String publicUrl = domainOfBucket + URLEncoder.encode(fileUrl,"UTF-8").replace("+", "%20");
            fileUrl = auth.privateDownloadUrl(publicUrl, expireInSeconds);
        } catch (Exception ex) {
            log.error("", ex);
        }

        return fileUrl;
    }

    public static void main(String[] args) {


//        String fileName = "Demo1.mp4";
//        String fileName = "img1.png";
        String fileName = "readme.md";
        try {
//            FileInputStream inputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\static\\images\\"+fileName);
            FileInputStream inputStream = new FileInputStream(fileName);
            saveFile(QiNiuOssUtil.bucket, inputStream, fileName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String fileUrl = genUrl(fileName, 3600);
        System.out.println(fileUrl);
    }

}
