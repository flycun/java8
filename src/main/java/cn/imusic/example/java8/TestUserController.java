package cn.imusic.example.java8;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestUserController {

    @Test
    public void Test1() throws Exception {
        UserController userController = new UserController();
        UserService userService = new UserService();
        System.out.println(userService);
        Class<? extends UserController> aClass = userController.getClass();
        Field field = aClass.getDeclaredField("userService");
        String fieldName = field.getName();
        String fieldName4SetMethod = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        Method method = aClass.getMethod(fieldName4SetMethod, UserService.class);
        method.invoke(userController, userService);
        System.out.println(userController.getUserService());
    }

    @Test
    public void Test2() throws Exception {
        UserController userController = new UserController();
        Class<? extends UserController> aClass = userController.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(field -> {
            AutoWrite fieldAnnotation = field.getAnnotation(AutoWrite.class);
            if (fieldAnnotation != null) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                try {
                    Object o = type.newInstance();
                    field.set(userController,o);
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(userController.getUserService());
    }
}
