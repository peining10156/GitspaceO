//package com.o2o.pn.service;
//
//import com.o2o.pn.BaseTest;
//import com.o2o.pn.entity.Area;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//public class AreaServiceTest extends BaseTest {
//
//
//    @Autowired
//    private AreaService areaService;
//    @Autowired
//    private CacheService cacheService;
//    @Test
//    public void testGteAreaList(){
//
//        List<Area> areaList=areaService.getAreaList();
//        assertEquals("西苑",areaList.get(0).getAreaName());
//        System.out.println("查询出来的是什么：：：："+ areaList.get(0).getAreaName());
////        cacheService.removeFromCache(areaService.AREALISTKEY);
//        areaList = areaService.getAreaList();
//    }
//
//}
