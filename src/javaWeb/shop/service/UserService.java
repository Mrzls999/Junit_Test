package javaWeb.shop.service;
import javaWeb.shop.entity.User;

public interface UserService {
    /**
     * 判断用户是否存在，用来登录
     * @param sql
     * @param user
     * @param params
     * @return
     */
    User getUserFrom_UserNameAndPassWord(String sql, Class<User> user, Object... params);

    /**
     * 通过sql向用户表中注册用户
     * @param sql insert语句
     * @param params 传入的参数
     * @return 是否成功
     */
    Boolean ShopRegister_By_UserNamePasswordEmail(String sql, Object... params);

    /**
     * 检查是否存在重名
     * @param params
     * @return
     */
    boolean checkUserName(String sql,Object... params);
}
