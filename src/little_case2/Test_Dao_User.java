package little_case2;

import org.junit.Test;

import java.util.List;

public class Test_Dao_User {

    @Test
    public void test_Dao_User() {
        Dao<User> dao = new Dao<>();
        User user1 = new User(1,18,"zls");
        User user2 = new User(2,19,"zrs");
        User user3 = new User(3,20,"zxs");

        dao.save(Integer.toString(user1.getId()),user1);
        dao.save(Integer.toString(user2.getId()),user2);
        dao.save(Integer.toString(user3.getId()),user3);

        User user = dao.get("1");

        dao.update("2",new User(4,22,"zs"));

        List<User> list = dao.list();

        for (User u : list) {
            System.out.println(u);
        }

        dao.delete("3");

        List<User> list1 = dao.list();

        for (User u1 : list1) {
            System.out.println(u1);
        }
    }
}
