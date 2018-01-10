package com.ibm.hessian.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import com.ibm.hessian.service.FileTransferService;

/**
 * 
 * @Description
 * @author FeiXiangSun
 * @date 2018年1月11日 上午12:08:28
 */
public class FileTransferServiceImpl implements FileTransferService {

    /**
     * 
     * Description
     * 
     * @param filename
     * @param data
     * @see com.ibm.hessian.service.FileTransferService#upload(java.lang.String, java.io.InputStream)
     */
    public void upload(String filename, InputStream data) {
        long start = System.currentTimeMillis();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        String file = "d:/temp/fileUpload/" + (UUID.randomUUID() + "-" + filename);
        try {
            // 获取客户端传递的InputStream
            bis = new BufferedInputStream(data);
            // 创建文件输出流
            bos = new BufferedOutputStream(new FileOutputStream(file));
            byte[] buffer = new byte[8192];
            int r = bis.read(buffer, 0, buffer.length);
            while (r > 0) {
                bos.write(buffer, 0, r);
                r = bis.read(buffer, 0, buffer.length);
            }
            long end = System.currentTimeMillis();
            System.out.println("文件[" + file + "]上传成功！花费" + (end-start)/1000 + "s");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
