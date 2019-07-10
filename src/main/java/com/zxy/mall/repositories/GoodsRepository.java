package com.zxy.mall.repositories;

import com.zxy.mall.entities.Goods;
import org.springframework.data.repository.CrudRepository;

public interface GoodsRepository extends CrudRepository<Goods,Long> {
}
