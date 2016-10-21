package neroao.demobox.mybatisdemo;

public interface UserMapper {
    public void insertUser(User user);

    public User getUser(String name);
}
