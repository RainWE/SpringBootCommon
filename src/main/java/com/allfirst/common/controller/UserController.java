package com.allfirst.common.controller;

import org.springframework.stereotype.Controller;

/**
 * 测试Model和ModelAndView
 */
@Controller
public class UserController {


    /**
     *  使用Model与前端交互
     * @param username
     * @param psw
     * @param model
     * @return
     */
 /*   @PostMapping("/getuser1")
    public String getUserWithModel(@RequestParam("user") String username,
                          @RequestParam("password") String psw, Model model){
        System.out.println(username);
        System.out.println(psw);
        String msg = "成功登录";
        model.addAttribute("msg",msg);
        return "success_test";
    }
*/
    /**
     * 使用ModelAndView与前端交互
     * @param username
     * @param psw
     * @return
     */
 /*   @PostMapping("/getuser")
    public ModelAndView  getUserWithModelAndView(@RequestParam("user") String username,
                          @RequestParam("password") String psw){
        ModelAndView mv = new ModelAndView();
        //获取前端请求的数据
        System.out.println(username);
        System.out.println(psw);
        //测试传输后端数据
        String msg = "成功登录";
        mv.addObject("msg",msg);
        //测试传输list集合
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        mv.addObject("lists",list);
        //测试传输map集合
        Map<String,String> map = new HashMap<>();
        map.put("aa","11");
        map.put("bb","22");
        mv.addObject("maps",map);
        //测试传输对象
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        mv.addObject("user",user);

        mv.setViewName("success_test");
        return mv;
    }
*/


}
