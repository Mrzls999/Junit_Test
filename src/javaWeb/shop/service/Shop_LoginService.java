package javaWeb.shop.service;

import javaWeb.shop.dao.Shop_LoginDao;
import javaWeb.shop.entity.UserLogin;

public class Shop_LoginService {
    /**
     * 判断用户是否存在，用来登录
     * @param sql
     * @param user
     * @param params
     * @return
     */
    public boolean getUserFrom_UserNameAndPassWord(String sql, Class<UserLogin> user, Object... params) {
        Shop_LoginDao shop_loginDao = new Shop_LoginDao();
        return shop_loginDao.getUserFrom_UserNameAndPassWord(sql, user, params) != null;
    }
}
