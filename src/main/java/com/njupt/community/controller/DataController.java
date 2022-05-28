package com.njupt.community.controller;

import com.njupt.community.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class DataController {

    @Autowired
    private DataService dataService;

    // 统计页面
    @RequestMapping(path = "/data", method = {RequestMethod.GET, RequestMethod.POST})
    public String getDataPage(){
        return "/site/admin/data";
    }

    // 统计网站UV
    @RequestMapping(path = "/data/uv", method = RequestMethod.POST) // 页面传的日期的字符串，通过注解告诉服务器日期格式，然后自动转换
    public String getUV(@DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") Date end, Model model){
        if (end.before(start)) {
            model.addAttribute("dateuvMsg", "请选择正确的时间！");
            model.addAttribute("uvStartDate", start);
            model.addAttribute("uvEndDate", end);
            return "forward:/data";
        }
        long uv = dataService.calculateUV(start, end);
        model.addAttribute("uvResult", uv);
        model.addAttribute("uvStartDate", start);
        model.addAttribute("uvEndDate", end);

        return "forward:/data"; // 声明当前方法只将请求处理一半，还让另一个继续处理
    }

    // 统计活跃用户DAU
    @RequestMapping(path = "/data/dau", method = RequestMethod.POST) // 页面传的日期的字符串，通过注解告诉服务器日期格式，然后自动转换
    public String getDAU(@DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
                         @DateTimeFormat(pattern = "yyyy-MM-dd") Date end, Model model){
        if (end.before(start)) {
            model.addAttribute("datedauMsg", "请选择正确的时间！");
            model.addAttribute("dauStartDate", start);
            model.addAttribute("dauEndDate", end);
            return "forward:/data";
        }
        long dau = dataService.calculateDAU(start, end);
        model.addAttribute("dauResult", dau);
        model.addAttribute("dauStartDate", start);
        model.addAttribute("dauEndDate", end);

        return "forward:/data"; // 声明当前方法只将请求处理一半，还让另一个继续处理
    }

}
