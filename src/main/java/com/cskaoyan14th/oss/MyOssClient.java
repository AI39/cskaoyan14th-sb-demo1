package com.cskaoyan14th.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.cskaoyan14th.bean.Storage;
import com.cskaoyan14th.converter.DateConverter;
import com.cskaoyan14th.vo.DateCurrentTime;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@ConfigurationProperties(prefix = "myoss")
@Component
public class MyOssClient {
    String bucket;
    String endpoint;
    String accessKey;

    String secret;

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Storage ossFileUpload(MultipartFile myfile) throws IOException {
        if(myfile != null){
            InputStream inputStream = myfile.getInputStream();

            long size = myfile.getSize();//文件大小

            String contentType = myfile.getContentType();//获得文件类型

            String originalFilename = myfile.getOriginalFilename();//获得文件原始名

            String uuid = UUID.randomUUID().toString().replace("-", "");//生成一个随机文件名

            //以下开始设置oss的配置
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(size);//设置文件大小
            objectMetadata.setContentType(contentType);//设置文件类型

            PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, uuid, inputStream, objectMetadata);

            OSSClient ossClient = new OSSClient(endpoint, accessKey, secret);

            ossClient.putObject(putObjectRequest);

            //以下是将一些数据封装到Storage中
            Date date = DateCurrentTime.dateCurrentTime();

            Storage storage = new Storage();
            storage.setName(originalFilename);

            storage.setKey(uuid);
            storage.setType(contentType);
            storage.setSize(size);

            storage.setAddTime(date);
            storage.setUpdateTime(date);
            String url = "https://cskaoyan14th.oss-cn-beijing.aliyuncs.com/" + uuid;
            storage.setUrl(url);

            return storage;
        }
        return null;
    }
}
