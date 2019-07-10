package com.zxy.mall.services;

import com.zxy.mall.entities.Goods;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface GoodsService {
    
    Iterable<Goods> listAllGoods();

    Page<Goods> listPageGoods(int startPage,int pageSize);

    Optional<Goods> getGoodsById(Long id);

    Goods saveGoods(Goods Goods);

    void deleteGoods(Long id);
}
