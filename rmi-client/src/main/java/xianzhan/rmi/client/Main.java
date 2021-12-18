package xianzhan.rmi.client;

import xianzhan.rmi.base.User;
import xianzhan.rmi.base.UserService;

import java.rmi.Naming;
import java.util.List;

/**
 * @author xianzhan
 * @since 2021-12-18
 */
public class Main {

    public static void main(String[] args) throws Exception {
        UserService userService = (UserService) Naming.lookup("rmi://127.0.0.1:2021/userService");
        final int times = 3;
        for (int i = 0; i < times; i++) {
            User user = userService.add("lxz", i);
            System.out.println("add: " + user);
        }

        List<User> lxz = userService.query("lxz");
        System.out.println("query: " + lxz);

        int d = userService.delete("lxz");
        System.out.println("delete: " + d);
    }
}
