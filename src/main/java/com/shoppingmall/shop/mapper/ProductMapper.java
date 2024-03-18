package com.shoppingmall.shop.mapper;

import com.shoppingmall.shop.data.BrandDTO;
import com.shoppingmall.shop.data.CategoryDTO;
import com.shoppingmall.shop.data.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.*;

@Mapper
public interface ProductMapper {

    //상품 등록
    void addProduct(ProductDTO productDTO);

    void addCategory(CategoryDTO categoryDTO);

    void deleteCategory(CategoryDTO categoryDTO);

    void addBrand(BrandDTO brandDTO);

    void deleteBrand(BrandDTO brandDTO);

    List<ProductDTO> getProductList();

    void updateProduct(ProductDTO productDTO);

    ProductDTO getProductById(int pno);

    void deleteProduct(ProductDTO productDTO);

    void updateProductQuantity(int pno);

    Integer getSellingPriceByPno(int pno);
}
