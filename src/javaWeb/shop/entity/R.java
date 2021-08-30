package javaWeb.shop.entity;

/**
 * 用来描述注册时 用户名是否存在的 一个 格式化类
 */
public class R {
    private Integer code;//10000 成功  20000失败
    private String message;//用户名重复/不重复
    private Boolean flag;
    //返回成功
    public static R ok(){
        R r = new R();
        r.setCode(10000);
        r.setMessage("ok");
        r.setFlag(true);
        return r;
    }
    //返回失败
    public static R error(){
        R r = new R();
        r.setCode(20000);
        r.setMessage("error");
        r.setFlag(false);
        return r;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
