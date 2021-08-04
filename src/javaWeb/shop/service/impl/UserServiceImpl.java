package javaWeb.shop.service.impl;

import javaWeb.shop.dao.UserDao;
import javaWeb.shop.dao.impl.UserDaoImpl;
import javaWeb.shop.entity.User;
import javaWeb.shop.service.UserService;

public class UserServiceImpl implements UserService {
    /**
     * 判断用户是否存在，用来登录
     * @param sql
     * @param user
     * @param params
     * @return
     */
    @Override
    public User getUserFrom_UserNameAndPassWord(String sql, Class<User> user, Object... params) {
        UserDao shop_loginDao = new UserDaoImpl();
        return shop_loginDao.getUserFrom_UserNameAndPassWord(sql, user, params);
    }

    /**
     * 通过sql向用户表中注册用户
     * @param sql insert语句
     * @param params 传入的参数
     * @return 是否成功
     */
    @Override
    public Boolean ShopRegister_By_UserNamePasswordEmail(String sql, Object... params) {
        UserDao shop_registerDao = new UserDaoImpl();
        return shop_registerDao.ShopRegister_By_UserNamePasswordEmail(sql, params);
    }
}
