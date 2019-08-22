package edu.qust.market.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class FileUpload {

    public static String savaFile(HttpServletRequest httpServletRequest) throws IOException, ServletException {
        Collection<Part> parts = httpServletRequest.getParts();
        FileInputStream fis = null;
        String type = null;
        for (Iterator<Part> iterator = parts.iterator(); iterator.hasNext(); ) {
            Part part = iterator.next();
            System.out.println("-----类型名称------->" + part.getName());
            System.out.println("-----类型------->" + part.getContentType());
            System.out.println("-----提交的类型名称------->" + part.getSubmittedFileName());
            System.out.println("----流-------->" + part.getInputStream());
            if (!"file".equals(part.getName())) {
                continue;
            }
            fis = (FileInputStream) part.getInputStream();
            if (part.getContentType() != null)
                type = part.getContentType().split("/")[1];
        }


        String time = DateUtils.getCurrDate(DateUtils.LONG_DATE_FORMAT).replace("-","_");
        Long name = System.currentTimeMillis();
        String path =System.getProperty("user.dir")+ "/static/goods_images/";

        File dir = new File(path);
        System.out.println(dir.getAbsolutePath());
        if (!dir.exists()){
            dir.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream( dir.getAbsolutePath()+"/"+ time + "_" + name + "." + type);
        byte[] by = new byte[1024];
        int len = 0;
        while ((len = fis.read(by)) != -1) {
            fos.write(by, 0, len);
        }
        fos.close();
        fis.close();
        return  "goods_images/" + time + "_" + name + "." + type;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(ResourceUtils.getURL("classpath:").getPath());

    }
}
