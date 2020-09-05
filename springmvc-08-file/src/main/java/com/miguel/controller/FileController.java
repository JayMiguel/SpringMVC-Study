package com.miguel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
public class FileController {

    @RequestMapping("/upload")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        // 获取文件名
        String uploadFileName = file.getOriginalFilename();
        // 如果文件名为空，直接回到首页
        if ("".equals(uploadFileName)) {
            return "redirect:/index.jsp";
        }
        System.out.println("上传文件名：" + uploadFileName);

        //设置保存路径
        String path = request.getServletContext().getRealPath("/upload");
        //如果保存路径不存在，创建一个
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        System.out.println("文件保存路径：" + realPath);

        InputStream is = file.getInputStream();
        OutputStream os = new FileOutputStream(new File(realPath, uploadFileName));

        //读取写出
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
            os.flush();
        }

        os.close();
        is.close();
        return "redirect:/index.jsp";
    }

    @RequestMapping("/upload2")
    public String fileUpload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        System.out.println("上传文件保存的地址：" + realPath);

        file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));

        return "redirect:/index.jsp";
    }

    @ResponseBody
    @RequestMapping("/download")
    public String downloads(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String path = request.getServletContext().getRealPath("/upload");
        String fileName = "小号存货.txt";

        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));

        File file = new File(path, fileName);
        FileInputStream input = new FileInputStream(file);
        OutputStream output = response.getOutputStream();

        byte[] buffer = new byte[1024];
        int index = 0;

        while ((index = input.read(buffer)) != -1) {
            output.write(buffer, 0, index);
            output.flush();
        }
        output.close();
        input.close();
        return null;
    }
}
