package mapper;

import entity.User;

public interface UserMapper {
    public User findUserById(int userId);
    public void insertUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
}
