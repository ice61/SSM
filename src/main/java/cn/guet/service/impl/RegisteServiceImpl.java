package cn.guet.service.impl;

import cn.guet.bean.Clerk;
import cn.guet.dao.ClerkMapper;
import cn.guet.service.RegisteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by WIN 10 on 2019/1/16.
 */
@Service("registeService")
public class RegisteServiceImpl implements RegisteService {

    @Resource(name = "clerkMapper")
    private ClerkMapper clerkMapper;

    @Override
    public String insertClerk(Clerk clerk) {
        Clerk clerk1 = clerkMapper.findClerk(clerk.getId());
        if(clerk1 != null) {
            return "error";
        }else {
            clerkMapper.insertClerk(clerk);
            if(clerkMapper.findClerk(clerk.getId()) != null) {
                return "success";
            }
        }
        return "fail";

    }
}
