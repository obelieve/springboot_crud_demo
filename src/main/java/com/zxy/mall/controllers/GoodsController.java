package com.zxy.mall.controllers;

import com.zxy.mall.entities.Goods;
import com.zxy.mall.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @ResponseBody
    @RequestMapping(value = "/api/goods", method = RequestMethod.GET)
    public List<Goods> list() {
        List<Goods> list = new ArrayList<>();
        for (Goods g : goodsService.listAllGoods()) {
            list.add(g);
        }
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/api/goods/page", method = RequestMethod.GET)
    public List<Goods> list(@RequestParam int startPage,@RequestParam int pageSize) {
        List<Goods> list = new ArrayList<>();
        for (Goods g : goodsService.listPageGoods(startPage,pageSize)) {
            list.add(g);
        }
        return list;
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
