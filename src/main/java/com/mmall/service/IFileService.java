package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by My_coder on 2017-07-20.
 */
public interface IFileService {
    String upload(MultipartFile file, String path);
}
