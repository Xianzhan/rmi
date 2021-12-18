package xianzhan.rmi.base;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author xianzhan
 * @since 2021-12-18
 */
public interface UserService extends Remote {

    /**
     * 创建用户
     *
     * @param name 名称
     * @param age  年龄
     * @return 用户
     * @throws RemoteException rmi
     */
    User add(String name, Integer age) throws RemoteException;

    /**
     * 删除用户
     *
     * @param name 名称
     * @return 删除的个数
     * @throws RemoteException rmi
     */
    int delete(String name) throws RemoteException;

    /**
     * 查找用户
     *
     * @param name 名称
     * @return 用户列表
     * @throws RemoteException rmi
     */
    List<User> query(String name) throws RemoteException;
}
