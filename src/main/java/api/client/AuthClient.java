package api.client;

import io.restassured.response.Response;
import pojo.User;

public class AuthClient extends BaseHttpClient {

    private static final String BASE_PATH = "/api/auth";

    public Response register(User user) {
        return postRequest(BASE_PATH + "/register", user);
    }

    public Response login(User user) {
        return postRequest(BASE_PATH + "/login", user);
    }

    public Response delete(User user, String accessToken) {
        return deleteRequest(BASE_PATH + "/user", accessToken);
    }

}