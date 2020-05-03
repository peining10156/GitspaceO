package com.o2o.pn.util;
public class PathUtil {
    public static String seperator = System.getProperty("file.seperator");

    public static String getImgBastPath(){
        String os= System.getProperty("os.name");
        String basePaht = "";
        if(os.toLowerCase().startsWith("win")){
            basePaht = "";
            System.out.print("我看看你到底是个啥" + seperator);
        }else {
            basePaht = "/home/peining/image/";
        }
           // basePaht =basePaht.replace("/",seperator);
        return basePaht;
    }
    public static String getShopImagePath(long shopId){
        String imagePath = "D:/image/o2oimge" + shopId +"/";
       //return imagePath.replace("/",seperator);
        return imagePath;
    }
}
