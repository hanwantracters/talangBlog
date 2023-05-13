package com.itheima.service;


import com.itheima.domain.Identity;

/**
 * (Identity)表服务接口
 *
 * @author makejava
 * @since 2023-05-09 16:41:44
 */
public interface IdentityService
{
    boolean save(Identity identity);
    Identity compare(Identity identity);

}
