package com.zxy.mall.services;

import com.zxy.mall.entities.Goods;

import java.util.Optional;

public interface GoodsService {
    
    Iterable<Goods> listAllGoods();

    Optional<Goods> getGoodsById(Long id);

    Goods saveGoods(Goods Goods);

    void deleteGoods(Long id);
}
