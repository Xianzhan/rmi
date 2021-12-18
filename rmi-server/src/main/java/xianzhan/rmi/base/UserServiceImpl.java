package xianzhan.rmi.base;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author xianzhan
 * @since 2021-12-18
 */
public class UserServiceImpl extends UnicastRemoteObject implements UserService {

    private final Map<String, List<User>> db = new ConcurrentHashMap<>();

    public UserServiceImpl() throws RemoteException {
    }

    @Override
    public User add(String name, Integer age) throws RemoteException {
        System.out.println("add: " + name);
        User user = new User(name, age);

        List<User> list = db.getOrDefault(name, new CopyOnWriteArrayList<>());
        list.add(user);
        db.put(name, list);

        return user;
    }

    @Override
    public int delete(String name) throws RemoteException {
        System.out.println("delete: " + name);
        List<User> remove = db.remove(name);
        return remove == null ? 0 : remove.size();
    }

    @Override
    public List<User> query(String name) throws RemoteException {
        List<User> users = db.get(name);
        System.out.println("query: " + users);
        return users == null ? List.of() : users;
    }


}
