package bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zls
 * @date 2022/8/21 18:40:31
 * @description XXX
 */
public class TMenu {

    private Long id;

    private Long pid;

    private String name;

    private String icon;

    private String url;

    private List<TMenu> childMenus = new ArrayList<>();


}
