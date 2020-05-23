package com.o2o.pn.service.impl;

import com.o2o.pn.dao.ProduceCategoryDao;
import com.o2o.pn.dao.ProductDao;
import com.o2o.pn.dto.ProductCategoryExecution;
import com.o2o.pn.entity.ProductCategory;
import com.o2o.pn.enums.ProductCategoryStateEnum;
import com.o2o.pn.exceptions.ProductCategoryOperationException;
import com.o2o.pn.service.ProductCategorySercive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProductCategorySerciveImpl implements ProductCategorySercive {
    @Autowired
    private ProduceCategoryDao produceCategoryDao;

    @Autowired
    private ProductDao productDao;
    /*
     * 查询某个指定店铺下的所有商品类别
     *
     * @param long shopId
     * @return list<ProductCategory>
     * */
    @Override
    public List<ProductCategory> getProductCategoryList(Long shopId) {
        return produceCategoryDao.queryProductCategoryList(shopId);
    }

    @Override
    @Transactional
    public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException {
        if (productCategoryList !=null&&productCategoryList.size()>0){
            try {
                int effectedNum = produceCategoryDao.batchInsertProductCategory(productCategoryList);
                if (effectedNum<=0){
                    throw new ProductCategoryOperationException("店铺类别创建失败");
                }else{
                    return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
                }
            }catch (Exception e){
                throw new ProductCategoryOperationException("batchAddProductCategory error:" + e.getMessage());
            }
        }else {
            return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
        }
    }

    @Override
    @Transactional
    public ProductCategoryExecution deleteProductGory(long productCategoryId, long shopId) throws ProductCategoryOperationException {
       //解除tb_product里的商品与productCategoryId的关联
        try {
            int effectedNum = productDao.updateProductCategoryToNull(productCategoryId);
            if (effectedNum<0){
                throw new ProductCategoryOperationException("商品类别更新失败");
            }
        }catch (Exception e){
            throw new ProductCategoryOperationException("deleteProductCategory error:"+e.getMessage());
        }

        //删除该productCategory
        try {
            int effectedNum =produceCategoryDao.deleteProductCategory(productCategoryId,shopId);
            if (effectedNum<=0){
                throw new ProductCategoryOperationException("商品类别删除失败");
            }else {
                return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
            }
        }catch (Exception e){
            throw new ProductCategoryOperationException("deleteProductCategory error"+e.getMessage());
        }


    }
}
