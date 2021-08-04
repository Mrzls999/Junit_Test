package javaWeb.shop.dao.impl;

import javaWeb.shop.dao.UserDao;
import javaWeb.shop.entity.User;
import javaWeb.shop.utils.BaseDBUtils;

public class UserDaoImpl extends BaseDBUtils implements UserDao {
    /**
     * 根据用户名密码，查询出一个用户，用来登录
     * @param sql
     * @param user
     * @param params
     * @return
     */
    @Override
    public User getUserFrom_UserNameAndPassWord(String sql, Class<User> user, Object... params) {
        BaseDBUtils baseDBUtils = new BaseDBUtils();
        return baseDBUtils.getBean(sql, user, params);
    }

    /**
     * 通过sql向用户表中注册用户
     * @param sql insert语句
     * @param params 传入的参数
     * @return 是否成功
     */
    @Override
    public Boolean ShopRegister_By_UserNamePasswordEmail(String sql, Object... params) {
        BaseDBUtils baseDBUtils = new BaseDBUtils();
        return (baseDBUtils.update(sql, params)) == 1;
    }
}
