package xianzhan.rmi.server;

import xianzhan.rmi.base.UserService;
import xianzhan.rmi.base.UserServiceImpl;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author xianzhan
 * @since 2021-12-18
 */
public class Main {
    public static void main(String[] args) throws Exception {

        UserService userService = new UserServiceImpl();

        Registry registry = LocateRegistry.createRegistry(2021);
        registry.bind("userService", userService);
    }
}
