package com.shoppingmall.shop.mapper;

import com.shoppingmall.shop.data.FavoriteDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FavoriteMapper {
    void addFavorite(FavoriteDTO favoriteDTO);

    void deleteFavorite(FavoriteDTO favoriteDTO);

    List<FavoriteDTO> getFavoriteList(String customerId);
}
