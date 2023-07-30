package Rest;

import Rest.entities.ApiResponse;
import Rest.entities.Comment;
import Rest.entities.HttpClientUtils;
import Rest.entities.TestConfig;
import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;

public class CommentController {

    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");
    private final OkHttpClient httpClient;
    private final String baseUrl;
    private final String bearerToken;

    public CommentController() {
        this.httpClient = new OkHttpClient();
        this.baseUrl = TestConfig.BASE_URL;
        this.bearerToken = TestConfig.BEARER_TOKEN;
    }

    public ApiResponse postCreateCommentByJobId(Comment comment, String id) throws IOException {
        String url = baseUrl + "/comment/" + id + "/create";
        return sendPostRequest(url, comment);
    }

    public ApiResponse getCommentAll(String id) throws IOException {
        String url = baseUrl + "/comment/" + id + "/all";
        return sendGetRequest(url);
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

    private ApiResponse sendGetRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .header("Authorization", bearerToken)
                .build();

        Response response = HttpClientUtils.executeRequest(request);
        String responseBody = response.body().string();
        return new ApiResponse(response.code(), responseBody);
    }
}


