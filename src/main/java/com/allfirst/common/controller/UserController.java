package com.allfirst.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    /**
     *
     * @param username
     * @param psw
     * @param model
     * @return
     */
    @PostMapping("/getuser")
    public String getUserWithModel(@RequestParam("user") String username,
                          @RequestParam("password") String psw, Model model){
        System.out.println(username);
        System.out.println(psw);
        String msg = "成功登录";
        model.addAttribute("msg",msg);
        return "success";
    }


    @PostMapping("/getuser")
    public ModelAndView  getUserWithModelAndView(@RequestParam("user") String username,
                          @RequestParam("password") String psw){
        ModelAndView mv = new ModelAndView();
        System.out.println(username);
        System.out.println(psw);
        String msg = "成功登录";
        mv.addObject("msg",msg);
        mv.setViewName("success");
        return mv;
    }


}
