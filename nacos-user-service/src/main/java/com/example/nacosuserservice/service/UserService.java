package com.example.nacosuserservice.service;


import com.example.nacosuserservice.entity.User;

import java.util.List;

/**
 * @author wei.song
 * @since 2023/4/11 16:51
 */
public interface UserService {

    /**
     * 创建
     *
     * @param user 用户
     */
    void create(User user);

    /**
     * 获取用户
     *
     * @param id id
     * @return {@link User}
     */
    User getUser(Long id);

    /**
     * 更新
     *
     * @param user 用户
     */
    void update(User user);

    /**
     * 删除
     *
     * @param id id
     */
    void delete(Long id);

    /**
     * 通过用户名得到用户
     *
     * @param username 用户名
     * @return {@link User}
     */
    User getByUsername(String username);

    /**
     * 通过用户id获取用户
     *
     * @param ids id
     * @return {@link List}<{@link User}>
     */
    List<User> getUserByIds(List<Long> ids);

}
