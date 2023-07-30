package RestApi;

import Rest.AuthController;
import Rest.entities.ApiResponse;
import Rest.entities.SignInUp;
import Rest.entities.TestConfig;
import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;


public class AuthControllerTest {

    private AuthController authController;

    @BeforeClass
    public void setup() {
        String baseUrl = "https://freelance.lsrv.in.ua/api";
        authController = new AuthController(TestConfig.BASE_URL, TestConfig.BEARER_TOKEN);
    }

    @Test
    public void signUpTest() throws IOException {
        SignInUp signUp = new SignInUp();
        signUp.setUsername("Randomuser1234");
        signUp.setPassword("Test12345");
        signUp.setConfirmPassword("Test12345");

        ApiResponse response = authController.postSignUp(signUp);

        Assert.assertEquals(response.statusCode(), 200, "Запрос на регистрацию завершился неудачно. Код ответа: " + response.statusCode());
    }

    @Test
    public void signInTest() throws IOException {
        SignInUp signIn = new SignInUp();
        signIn.setUsername("Randomuser1234");
        signIn.setPassword("Test12345");

        ApiResponse response = authController.postSignIn(signIn);

        Assert.assertEquals(response.statusCode(), 200, "Запрос на вход завершился неудачно. Код ответа: " + response.statusCode());
    }
}


