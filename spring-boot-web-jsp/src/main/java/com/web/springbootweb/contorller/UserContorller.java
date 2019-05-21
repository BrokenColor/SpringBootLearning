package com.web.springbootweb.contorller;

import com.web.springbootweb.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: GWL
 * @Description:
 * @Date: Create in 10:01 2019/5/21
 */
@Controller
public class UserContorller {

    @RequestMapping("/showUser")
    public String showUser(Model model){
        List list = new ArrayList();
        list.add(new User(1,"二丫",10));
        list.add(new User(2,"三傻",23));
        list.add(new User(3,"布兰",100));
        //需要一个Model对象
        model.addAttribute("list",list);
        //跳转视图 userList.jsp
        return "userList";
    }
}
