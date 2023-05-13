package com.itheima.service.impl;


import com.itheima.controller.Code;
import com.itheima.dao.IdentityDao;
import com.itheima.domain.Identity;
import com.itheima.exception.BusinessException;
import com.itheima.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Identity)表服务实现类
 *
 * @author makejava
 * @since 2023-05-09 16:41:44
 */
@Service("identityService")
public class IdentityServiceImpl implements IdentityService
{
    @Autowired
    private IdentityDao identityDao;

    public boolean save(Identity identity)
    {
        try
        {
            boolean flag = identityDao.save(identity);
            return flag;
        }
        catch (Exception e)
        {
            throw new BusinessException(Code.BUSINESS_ERR, "此账号已经被注册请重新注册");
        }
    }

    public Identity compare(Identity identity)
    {

        Identity standard = identityDao.compare(identity);
        return standard;

    }
}
