package Rest;

import Rest.entities.ApiResponse;
import Rest.entities.TestConfig;
import Rest.entities.HttpClientUtils;
import Rest.entities.Job;
import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;

public class JobController {
    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");
    private final String baseUrl;
    private final String bearerToken;

    public JobController() {
        this.baseUrl = TestConfig.BASE_URL;
        this.bearerToken = TestConfig.BEARER_TOKEN;
    }

    public ApiResponse postJobCreate(Job job) throws IOException {
        String url = baseUrl + "/job/create";
        return sendPostRequest(url, job);
    }

    public ApiResponse postJobDeleteByJobId(String jobId) throws IOException {
        String url = baseUrl + "/job/delete/" + jobId;
        return sendPostRequest(url, null);
    }

    public ApiResponse getJobById(String jobId) throws IOException {
        String url = baseUrl + "/job/" + jobId;
        return sendGetRequest(url);
    }

    public ApiResponse getUserJobs() throws IOException {
        String url = baseUrl + "/job/user/jobs";
        return sendGetRequest(url);
    }

    public ApiResponse getAllJobs() throws IOException {
        String url = baseUrl + "/job/all";
        return sendGetRequest(url);
    }

    private ApiResponse sendPostRequest(String url, Object requestObject) throws IOException {
        Gson gson = new Gson();
        String requestBodyJson = gson.toJson(requestObject);

        RequestBody body = RequestBody.create(requestBodyJson, JSON_MEDIA_TYPE);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
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





