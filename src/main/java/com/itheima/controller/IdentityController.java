package com.itheima.controller;

import com.itheima.domain.Identity;
import com.itheima.service.IdentityService;
import com.itheima.util.IdentifyBroadcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/identities")
public class IdentityController
{
    @Autowired
    private IdentityService identityService;

    @PostMapping
    public Result log_in(@RequestBody Identity identity)
    {
        boolean flag=identityService.save(identity);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,null,"注册成功");
    }

    @GetMapping
    public Result sign_in(@RequestBody Identity identity)
    {
        Identity standard = identityService.compare(identity);
        if (standard != null)
        {
            boolean flag = standard.getPassword().equals(identity.getPassword());
            if (flag)
            {
                IdentifyBroadcast.SetIdentifyBroadcast(standard.getUsername());
                return new Result(Code.GET_OK,null,"登录成功");
            }
            else
            {
                return new Result(Code.GET_ERR,null,"密码不正确请重新输入");
            }
        }
        else
        {
            return new Result(Code.GET_ERR,null,"账号不存在请重新输入");
        }
    }
}
