package javaWeb.shop.service;

import javaWeb.shop.dao.Shop_RegisterDao;

public class Shop_RegisterService {
    /**
     * 通过sql向用户表中注册用户
     * @param sql insert语句
     * @param params 传入的参数
     * @return 是否成功
     */
    public Boolean ShopRegister_By_UserNamePasswordEmail(String sql, Object... params) {
        Shop_RegisterDao shop_registerDao = new Shop_RegisterDao();
        return shop_registerDao.ShopRegister_By_UserNamePasswordEmail(sql, params);
    }
}
