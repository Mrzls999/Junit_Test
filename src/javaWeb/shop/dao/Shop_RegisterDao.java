package javaWeb.shop.dao;

import javaWeb.shop.utils.BaseDBUtils;

public class Shop_RegisterDao {
    /**
     * 通过sql向用户表中注册用户
     * @param sql insert语句
     * @param params 传入的参数
     * @return 是否成功
     */
    public Boolean ShopRegister_By_UserNamePasswordEmail(String sql, Object... params) {
        BaseDBUtils baseDBUtils = new BaseDBUtils();
        return (baseDBUtils.update(sql, params)) == 1;
    }
}
