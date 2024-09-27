package com.example.catdemo.huaweicloudTest;

import com.obs.services.ObsClient;
import com.obs.services.exception.ObsException;
import com.obs.services.model.ObsObject;

import java.io.*;

public class GetObject001 {
    public static void main(String[] args) {
        String ak = "N2MO1ATYECISEROY4YHY";
        String sk = "GXLStXpihVyCCNhLVefCoyHiuyhyt2bd6c4bnT4s";
        String endPoint = "https://obs.ap-southeast-1.myhuaweicloud.com";
        ObsClient obsClient = new ObsClient(ak, sk,endPoint);
        try {
            // 流式下载
            ObsObject obsObject = obsClient.getObject("niyeshijojo", "objectkey");
            // 读取对象内容
            System.out.println("Object content:");
            InputStream input = obsObject.getObjectContent();
            byte[] b = new byte[1024];
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            while ((len = input.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            System.out.println("getObjectContent successfully");
            System.out.println(new String(bos.toByteArray()));
            // 现在将baos的内容写入到文件中
            try (OutputStream outputStream = new FileOutputStream("测试.png")) {
                bos.writeTo(outputStream); // 将数据写入文件
            } catch (IOException e) {
                e.printStackTrace();
            }
            bos.close();
            input.close();
        } catch (ObsException e) {
            System.out.println("getObjectContent failed");
            System.out.println("HTTP Code:" + e.getResponseCode());
            System.out.println("Error Code:" + e.getErrorCode());
            System.out.println("Error Message:" + e.getErrorMessage());
            System.out.println("Request ID:" + e.getErrorRequestId());
            System.out.println("Host ID:" + e.getErrorHostId());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("getObjectContent failed");
            e.printStackTrace();
        }
    }
}
