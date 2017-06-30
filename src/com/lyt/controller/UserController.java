package com.lyt.controller;  
  
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
  
import com.lyt.model.User;  
import com.lyt.service.impl.UserService;  
 
@Controller  
@RequestMapping("/user")  
public class UserController {  
    @Autowired  
    private UserService userService;  
    /**  
     * 获取所有用户列表  
     * @param request  
     * @return  
     */  
    @RequestMapping("/getAllUser")  
    public String getAllUser(HttpServletRequest request,Model model){  
        List<User> user = userService.findAll();  
        model.addAttribute("userList", user);  
        request.setAttribute("userList", user);  
        return "/allUser";  
    }  
    /**  
     * 跳转到添加用户界面  
     * @param request  
     * @return  
     */  
    @RequestMapping("/toAddUser")  
    public String toAddUser(){  
        return "/addUser";  
    }  
    /**  
     * 添加用户并重定向  
     * @param user  
     * @param request  
     * @return  
     */  
    @RequestMapping("/addUser")  
    public String addUser(User user,Model model){  
        if(userService.save(user)==1)
        	return "redirect:/user/getAllUser";
        else
        	return "error";
    }  
    /**  
     *编辑用户  
     * @param user  
     * @param request  
     * @return  
     */  
    @RequestMapping("/updateUser")  
    public String updateUser(User user,Model model){  
        if(userService.update(user)==1){  
            //user = userService.findById(user.getId());  
            //request.setAttribute("user", user);  
            //model.addAttribute("user", user);  
            return "redirect:/user/getAllUser";  
        }else{  
            return "/error";  
        }  
    }  
    /**  
     * 根据id查询单个用户  
     * @param id  
     * @param request  
     * @return  
     */  
    @RequestMapping("/getUser")  
    public String getUser(int id,HttpServletRequest request,Model model){  
        request.setAttribute("user", userService.findById(id));  
        model.addAttribute("user", userService.findById(id));  
        return "/editUser";  
    }  
    /**  
     * 删除用户  
     * @param id  
     * @param request  
     * @param response  
     */  
    @RequestMapping("/delUser")  
    public String delUser(int id,HttpServletRequest request,HttpServletResponse response){  
        String result = "{\"result\":\"error\"}";  
        if(userService.delete(id)==1){  
            result = "{\"result\":\"success\"}";
        }  
        response.setContentType("application/json");  
        try {
            PrintWriter out = response.getWriter();  
            out.write(result);
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        return "redirect:/user/getAllUser";
    }  
}