package com.andyfan.tx.controller;

import com.alibaba.fastjson.JSONArray;
import com.andyfan.tx.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andyFan
 * @date 2018年11月10日  19:49:52
 */
@RestController
public class TestController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/demo")
    public Object get(@RequestBody String str) {
//        return userMapper.selectByPrimaryKey(1L);

        Document doc = Jsoup.parse(str);
        Elements links = doc.getElementsByTag("script"); //带有href属性的a元素
        Element last = links.last();
        return JSONArray.parseArray("["+StringUtils.substringBetween(last.toString(),"[","]")+"]",String.class);


//        return links.last();
    }
}
