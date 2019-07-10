package com.zxy.mall.controllers;

import com.zxy.mall.entities.Goods;
import com.zxy.mall.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GoodsController {
    private GoodsService goodsService;

    @Autowired
    public void setGoodsService(GoodsService goodsService){
        this.goodsService = goodsService;
    }
    @RequestMapping(value="/goods", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("goods",goodsService.listAllGoods());
        System.out.println("Returning goods:");
        return "goods";
    }
    @RequestMapping("goods/{id}")
    public String showGoods(@PathVariable Long id ,Model model){
        model.addAttribute("goods",goodsService.getGoodsById(id));
        return "goodsshow";
    }

    @RequestMapping("goods/edit/{id}")
    public String edit(@PathVariable Long id , Model model){
        model.addAttribute("goods",goodsService.getGoodsById(id));
        return "goodsform";
    }
    @RequestMapping("goods/new")
    public String newGoods(Model model){
        model.addAttribute("goods",new Goods());
        return "goodsform";
    }
    @RequestMapping(value = "goods",method = RequestMethod.POST)
    public String saveGoods(Goods Goods){
        goodsService.saveGoods(Goods);
        return "redirect:/goods/" + Goods.getId();
    }

    @RequestMapping("goods/delete/{id}")
    public String delete(@PathVariable Long id){
        goodsService.deleteGoods(id);
        return "redirect:/goods";
    }
}
