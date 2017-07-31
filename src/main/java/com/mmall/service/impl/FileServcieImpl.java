package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by My_coder on 2017-07-20.
 */
@Service("iFileService")
public class FileServcieImpl implements IFileService {
    private static final Logger  logger = LoggerFactory.getLogger(FileServcieImpl.class);
    public String upload(MultipartFile file,String path){
        String filename = file.getOriginalFilename();
        //扩展名
        String fileExtensionName = filename.substring(filename.lastIndexOf(".")+1);
        //生成上传名称
        String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
        logger.info("开始文件上传，上传文件的文件名:{},上传的路径:{},新文件名:{}",filename,
                path,uploadFileName);
        File fileDir = new File(path);
        if (!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path,uploadFileName);

        try {
            //文件已经上传成功
            file.transferTo(targetFile);
            //将targetFile上传到我们ftp服务器上
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //上传完成后，删除upload下面的文件
            targetFile.delete();
        } catch (IOException e) {
            logger.error("上传异常",e);
            return null;
        }
        return targetFile.getName();
    }
}
