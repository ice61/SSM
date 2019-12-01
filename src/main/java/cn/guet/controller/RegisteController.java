package cn.guet.controller;

import cn.guet.bean.Clerk;
import cn.guet.service.RegisteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WIN 10 on 2019/1/16.
 */
@RequestMapping("/reg")
@Controller
public class RegisteController {

    @Resource(name = "registeService")
    private RegisteService registeService;

    @RequestMapping(value = "/registe",method = RequestMethod.GET)
    public String goRegiste() {
        System.out.println("我被访问到了");
        return "registe";
    }

    @RequestMapping(value = "/registe",method = RequestMethod.POST)
    public String registe(@RequestBody Clerk clerk, HttpServletRequest request,HttpServletResponse response) throws IOException {
        String result = registeService.insertClerk(clerk);
        if(result.equals("success")) {
            request.getSession().setAttribute("id",clerk.getId());
            return "success";
        }else if(result.equals("error")) {
            response.getWriter().write("error");
            return "registe";
        }
            return "registe";
    }

}
