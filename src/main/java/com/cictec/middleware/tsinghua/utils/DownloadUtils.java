package com.cictec.middleware.tsinghua.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author qiandaxian
 * 基于Apache httpclient的http媒体文件下载方法
 */
public  class DownloadUtils {

    /**
     * 通用的http下载方法。
     * @param url
     * @param savePath
     * @return
     */
    public static boolean downloadFile(String url,String savePath){
        boolean result = true;
        //下载媒体资源
        //String url = "http://117.34.118.23:9004/upload/2018/01/18/20180118114947830.mp4";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response1 = httpclient.execute(httpGet);
            HttpEntity entity1 = response1.getEntity();
            if(entity1.isStreaming()){
                System.out.println(entity1.getContentType());
                System.out.println(entity1.getContent());
                System.out.println(entity1.getContentEncoding());

                File file = new File(savePath);
                if(!file.exists()){
                    file.createNewFile();
                }
                FileOutputStream out = new FileOutputStream(file);
                entity1.writeTo(out);
                out.close();
            }
            response1.close();
        } catch (IOException e) {
            result = false;
            e.printStackTrace();
        }finally {
            return result;
        }
    }

    /**
     *
     * @param url
     */
    public void sendHttpUrlToAlibabaOSSServer(String url,String keySuffixWithSlash){
        //TODO
    }

}
