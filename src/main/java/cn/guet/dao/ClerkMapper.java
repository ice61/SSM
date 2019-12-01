package cn.guet.dao;

import cn.guet.bean.Clerk;
import org.springframework.stereotype.Repository;

/**
 * Created by WIN 10 on 2019/1/16.
 */

public interface ClerkMapper {
    public Clerk findClerk(String id);
    public void insertClerk(Clerk clerk);
}
