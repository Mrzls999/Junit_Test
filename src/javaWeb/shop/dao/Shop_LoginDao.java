package javaWeb.shop.dao;

import javaWeb.shop.entity.UserLogin;
import javaWeb.shop.utils.BaseDBUtils;

public class Shop_LoginDao {

    /**
     * 根据用户名密码，查询出一个用户，用来登录
     * @param sql
     * @param user
     * @param params
     * @return
     */
    public UserLogin getUserFrom_UserNameAndPassWord(String sql, Class<UserLogin> user, Object...params){
        BaseDBUtils baseDBUtils = new BaseDBUtils();
        return baseDBUtils.getBean(sql, user, params);
    }
}
