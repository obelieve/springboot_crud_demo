package com.zxy.mall.services;

import com.zxy.mall.entities.EntityPage;
import com.zxy.mall.entities.Goods;
import com.zxy.mall.repositories.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GoodsServiceImpl implements GoodsService {

    private GoodsRepository goodsRepository;

    @Autowired
    public void setGoodsRepository(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Override
    public Iterable<Goods> listAllGoods() {
        return goodsRepository.findAll();
    }

    @Override
    public EntityPage<Goods> listPageGoods(int startPage, int pageSize) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(startPage, pageSize, sort);
        Page<Goods> page = goodsRepository.findAll(pageable);
        EntityPage<Goods> entityPage = new EntityPage<>();
        entityPage.setList(page.getContent());
        entityPage.setStartPage(page.getNumber());
        entityPage.setPageSize(page.getSize());
        entityPage.setTotal(page.getTotalElements());
        entityPage.setNext(page.getContent().size() == page.getSize());
        return entityPage;
    }

    @Override
    public Optional<Goods> getGoodsById(Long id) {
        return goodsRepository.findById(id);
    }

    @Override
    public Goods saveGoods(Goods Goods) {
        return goodsRepository.save(Goods);
    }

    @Override
    public void deleteGoods(Long id) {
        goodsRepository.deleteById(id);
    }
}
