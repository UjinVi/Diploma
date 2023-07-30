package Rest;

import Rest.entities.ApiResponse;
import Rest.entities.HttpClientUtils;
import Rest.entities.TestConfig;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import java.io.IOException;

public class UserController {

    private static final String BASE_URL = TestConfig.BASE_URL;
    private static final String BEARER_TOKEN = TestConfig.BEARER_TOKEN;
    private final OkHttpClient httpClient;

    public UserController() {
        this.httpClient = new OkHttpClient();
    }

    public ApiResponse getUser() throws IOException {
        String url = BASE_URL + "/user/";
        Request request = new Request.Builder()
                .url(url)
                .get()
                .header("Authorization", BEARER_TOKEN)
                .build();

        Response response = HttpClientUtils.executeRequest(request);
        String responseBody = response.body().string();
        return new ApiResponse(response.code(), responseBody);
    }

    public ApiResponse getUserById(int id) throws IOException {
        String url = BASE_URL + "/user/" + id;
        Request request = new Request.Builder()
                .url(url)
                .get()
                .header("Authorization", BEARER_TOKEN)
                .build();

        Response response = HttpClientUtils.executeRequest(request);
        String responseBody = response.body().string();
        return new ApiResponse(response.code(), responseBody);
    }

    public ApiResponse postUserUpdate(JSONObject requestBody) throws IOException {
        String url = BASE_URL + "/user/update";
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(requestBody.toString(), mediaType);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .header("Authorization", BEARER_TOKEN)
                .build();

        Response response = HttpClientUtils.executeRequest(request);
        String responseBody = response.body().string();
        return new ApiResponse(response.code(), responseBody);
    }
}



