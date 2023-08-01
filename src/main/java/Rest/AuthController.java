package Rest;

import Rest.entities.ApiResponse;
import Rest.entities.HttpClientUtils;
import Rest.entities.SignInUp;
import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;

public class AuthController {
    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");
    private final OkHttpClient httpClient;
    private final String baseUrl;
    private final String bearerToken;

    public AuthController(String baseUrl, String bearerToken) {
        this.baseUrl = baseUrl;
        this.bearerToken = bearerToken;
        this.httpClient = new OkHttpClient();
    }

    public ApiResponse postSignUp(SignInUp signUp) throws IOException {
        return sendPostRequest(baseUrl + "/auth/signup", signUp);
    }

    public ApiResponse postSignIn(SignInUp signIn) throws IOException {
        return sendPostRequest(baseUrl + "/auth/signin", signIn);
    }

    private ApiResponse sendPostRequest(String url, Object requestObject) throws IOException {
        Gson gson = new Gson();
        String requestBodyJson = gson.toJson(requestObject);

        RequestBody body = RequestBody.create(requestBodyJson, JSON_MEDIA_TYPE);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .header("Content-Type", "application/json")
                .header("Authorization", bearerToken)
                .build();

        Response response = HttpClientUtils.executeRequest(request);
        String responseBody = response.body().string();
        return new ApiResponse(response.code(), responseBody);
    }
}





