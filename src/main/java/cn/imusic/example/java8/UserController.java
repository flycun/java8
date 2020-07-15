package cn.imusic.example.java8;

public class UserController {

    @AutoWrite
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
