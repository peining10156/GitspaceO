package com.o2o.pn.util;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;



public class ImageUtil {
    //定义常量
    private static final Random r = new Random();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    public static String basePath =Thread .currentThread().getContextClassLoader().getResource("").getPath();
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    /*
    *将CommonsMultipartFile转换成File
    * */

    public static File transferCommonsMultipartFileTOFile (CommonsMultipartFile cFile){
        File newFile = new File(cFile.getOriginalFilename());

        try{
                cFile.transferTo(newFile);
        }
        catch(IllegalArgumentException e)
        {
            logger.error(e.toString());
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        } return newFile;
    }

    /*
     * 处理缩略图，并返回新生成图片的相对路径
     *
     * */
    //public static String generateThumbnail(CommonsMultipartFile thumbnail, String targetAddr){
    public static String generateThumbnail(InputStream thumbnailInputStream,String fileName, String targetAddr){

    String realFileName = getRandomFileName();
    String extension = getFileExtension(fileName);
    makeDirPath(targetAddr);
    String relativeAddr = targetAddr + realFileName + extension;
    logger.debug("current relativeAddr is:" + relativeAddr);
    File dest = new File(PathUtil.getImgBastPath() + relativeAddr);
    logger.debug("current completeAddr is:" + PathUtil.getImgBastPath() + relativeAddr);
    try{
        //创建缩略图
        // Thumbnails.of(thumbnail.getInputStream())
        Thumbnails.of(thumbnailInputStream).size(200,200).watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.png")),0.25f).outputQuality(0.8f).toFile(dest);

    }catch (IOException e){
        logger.error(e.toString());
        e.printStackTrace();
    }
    return relativeAddr;
}
    /*
    *
    * 创建目标路径所涉及到的目录
    *
    * */
    private static void makeDirPath(String targetAddr) {

        String realFileParentPath = PathUtil.getImgBastPath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }
    }
    /*
    * 获取输入文件流的扩展名
    *
    * */
    private static String getFileExtension(String fileName) {

        return fileName.substring(fileName.indexOf("."));
    }
    /*
    *
    * 随机生成文件名，当前年月日小时分钟秒钟+五位随机数
    *
    * */
    public static String getRandomFileName(){
        // 获取随机的五位数
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + rannum;
    }
//    public static void main (String[] args)throws IOException {
//    //执行当前线程获取水印图片的绝对值路径
//        System.out.print("水印图片绝对路径：" + basePath);
//        Thumbnails.of(new File("D:/image/baoerjie.jpg")).size(200,200)
//                .watermark(Positions.BOTTOM_RIGHT,
//                        ImageIO.read(new File(basePath + "/watermark.png")),0.25f).outputQuality(0.8f)
//                        .toFile("D:/image/o2ozip/baoerjienew.jpg");
//    }
}
