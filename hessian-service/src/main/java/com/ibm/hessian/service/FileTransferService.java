package com.ibm.hessian.service;

import java.io.InputStream;

/**
 * 
 * @Description
 * @author FeiXiangSun
 * @date 2018年1月11日 上午12:06:21
 */
public interface FileTransferService {

    /**
     * 
     * @Description
     * @author FeiXiangSun
     * @param filename
     * @param data
     */
    public void upload(String filename, InputStream data);

}
