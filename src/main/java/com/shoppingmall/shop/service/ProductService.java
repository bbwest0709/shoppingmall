package com.shoppingmall.shop.service;

import com.shoppingmall.shop.data.BrandDTO;
import com.shoppingmall.shop.data.CategoryDTO;
import com.shoppingmall.shop.data.ProductDTO;
import com.shoppingmall.shop.mapper.ProductMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;

    public void addProduct(ProductDTO productDTO) {
        productMapper.addProduct(productDTO);
    }

    public void addCategory(CategoryDTO categoryDTO) {
        productMapper.addCategory(categoryDTO);
    }

    public void deleteCategory(CategoryDTO categoryDTO) {
        productMapper.deleteCategory(categoryDTO);
    }
    public void addBrand(BrandDTO brandDTO) {
        productMapper.addBrand(brandDTO);
    }

    public void deleteBrand(BrandDTO brandDTO) {
        productMapper.deleteBrand(brandDTO);
    }
    public List<ProductDTO> getProductList() {
        return productMapper.getProductList();
    }

    public void updateProduct(ProductDTO productDTO) {
        // 기존 상품 정보
        ProductDTO productInfo = productMapper.getProductById(productDTO.getPno());

        System.out.println("기존 상품 정보 : " + productInfo);

        // 변경 사항 확인하고, 변경된 컬럼만 수정하기
        ProductDTO update = new ProductDTO();
        BeanUtils.copyProperties(productDTO, update);

        if (update.getProductName() == null) {
            update.setProductName(productInfo.getProductName());
        }
        if (update.getProductImage() == null) {
            update.setProductImage(productInfo.getProductImage());
        }
        if (update.getDescription() == null) {
            update.setDescription(productInfo.getDescription());
        }
        if (update.getPrice() == 0) {
            update.setPrice(productInfo.getPrice());
        }
        if (update.getSellingPrice() == 0) {
            update.setSellingPrice(productInfo.getSellingPrice());
        }
        if (update.getQuantity() == 0) {
            update.setQuantity(productInfo.getQuantity());
        }
        if (update.getUseyn() == null) {
            update.setUseyn(productInfo.getUseyn());
        }
        if (update.getBno() == 0) {
            update.setBno(productInfo.getBno());
        }

        System.out.println("상품 수정 정보 : " + update);

        productMapper.updateProduct(update);
    }

    public void deleteProduct(ProductDTO productDTO) {
        productMapper.deleteProduct(productDTO);
    }

    public int getSellingPriceByPno(int pno) {
        return productMapper.getSellingPriceByPno(pno);
    }
}
