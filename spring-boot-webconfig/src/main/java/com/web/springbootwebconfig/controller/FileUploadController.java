package com.web.springbootwebconfig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: GWL
 * @Description: 文件上传
 * @Date: Create in 13:33 2019/5/18
 */
@Controller
public class FileUploadController {

    @RequestMapping(value = "/fileUpload",method = RequestMethod.POST )
    @ResponseBody
    public Map fileUpload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        System.out.println(multipartFile.getOriginalFilename());
        multipartFile.transferTo(new File("d:/"+multipartFile.getOriginalFilename()));
        Map map = new HashMap();
        map.put("msg","ok");
        return map;
    }

}
