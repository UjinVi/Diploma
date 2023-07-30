package RestApi;

import Rest.UserController;
import Rest.entities.ApiResponse;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class UserControllerTest {

    private final UserController userController = new UserController();

    @DataProvider(name = "userIds")
    public static Object[][] provideUserIds() {
        return new Object[][]{
                {1},
                {2},
                {3}
        };
    }

    @Test
    public void getUserTest() throws IOException {
        ApiResponse response = userController.getUser();
        System.out.println(response.statusCode());
        System.out.println(response.responseBody());
    }

    @Test(dataProvider = "userIds")
    public void getUserByIdTest(int userId) throws IOException {
        ApiResponse response = userController.getUserById(userId);
        System.out.println(response.statusCode());
        System.out.println(response.responseBody());
    }

    @Test
    public void userUpdateTest() throws IOException {
        JSONObject json = new JSONObject();
        json.put("id", 2);
        json.put("username", "randomuser123");
        json.put("name", "User");
        json.put("lastname", "Random");

        ApiResponse response = userController.postUserUpdate(json);
        System.out.println(response.statusCode());
        System.out.println(response.responseBody());
    }
}
