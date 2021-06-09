package javaSe.little_case2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Dao<T>{
    private HashMap<String,T> map = new HashMap<>();

    /**
     * 保存T类型的对象到Map成员变量中
     * @param id
     * @param entity
     */
    public void save(String id, T entity){
        map.put(id,entity);
    }

    /**
     * 从map中获取id对应的对象
     * @param id
     * @return
     */
    public T get(String id){
        return map.get(id);
    }

    /**
     * 替换map中key为id的内容，改为entity对象
     * @param id
     * @param entity
     */
    public void update(String id,T entity){
        map.replace(id,map.get(id),entity);
    }

    /**
     * 返回map中存放的所有T对象
     * @return
     */
    public List<T> list(){
        Object[] array = map.values().toArray();
        List<Object> objects = Arrays.asList(array);
        return (List<T>)objects;
    }

    /**
     * 删除指定id对象
     * @param id
     */
    public void delete(String id){
        map.remove(id);
    }

}
