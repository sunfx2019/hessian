package com.hessian.client.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import com.caucho.hessian.client.HessianProxyFactory;
import com.ibm.hessian.service.FileTransferService;

public class FileTransferServiceClient {

    // Hessian服务的url
    private static final String url = "http://localhost:8080/hessian-service/hessian/fileTransfer";

    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws Exception {

        // 创建HessianProxyFactory实例
        HessianProxyFactory factory = new HessianProxyFactory();
        // 获得Hessian服务的远程引用
        FileTransferService service = (FileTransferService) factory.create(FileTransferService.class, url);
        // 读取需要上传的文件
        
        // 调用远程服务上传文件。
        for (int i = 0; i < 10; i++) {
            File file = new File("C:\\Users\\FeiXiangSun\\Desktop\\新建文件夹\\eclipse-jee-oxygen-2-win32-x86_64.zip");
            InputStream data = new BufferedInputStream(new FileInputStream(file));
            service.upload("eclipse-jee-oxygen-2-win32-x86_64.zip", data);
            System.out.println(new Date().toLocaleString());
        }

    }
}
