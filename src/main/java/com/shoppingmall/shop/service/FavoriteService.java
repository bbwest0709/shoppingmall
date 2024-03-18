package com.shoppingmall.shop.service;

import com.shoppingmall.shop.data.FavoriteDTO;
import com.shoppingmall.shop.mapper.FavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteMapper favoriteMapper;


    public void addFavorite(FavoriteDTO favoriteDTO) {
        favoriteMapper.addFavorite(favoriteDTO);
    }

    public void deleteFavorite(FavoriteDTO favoriteDTO) {
        favoriteMapper.deleteFavorite(favoriteDTO);
    }

    public List<FavoriteDTO> getFavoriteList(String customerId) {
        return favoriteMapper.getFavoriteList(customerId);
    }
}
