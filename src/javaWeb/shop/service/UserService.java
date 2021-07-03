package javaWeb.shop.service;
import javaWeb.shop.entity.UserLogin;

public interface UserService {
    /**
     * 判断用户是否存在，用来登录
     * @param sql
     * @param user
     * @param params
     * @return
     */
    public UserLogin getUserFrom_UserNameAndPassWord(String sql, Class<UserLogin> user, Object... params);

    /**
     * 通过sql向用户表中注册用户
     * @param sql insert语句
     * @param params 传入的参数
     * @return 是否成功
     */
    public Boolean ShopRegister_By_UserNamePasswordEmail(String sql, Object... params);
}
