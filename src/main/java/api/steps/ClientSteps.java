package api.steps;

import api.client.AuthClient;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import pojo.User;

public class ClientSteps {

    AuthClient authClient = new AuthClient();

    @Step("Создание пользователя")
    public ValidatableResponse registerUser(User user) {
        return authClient.register(user).then();
    }

    @Step("Логин пользователя")
    public ValidatableResponse loginUser(User user) {
        return authClient.login(user).then();
    }

    @Step("Удаление пользователя")
    public ValidatableResponse deleteUser(User user, String accessToken) {
        return authClient.delete(user, accessToken).then();
    }

    @Step("Получение access token")
    public String extractAccessToken(ValidatableResponse response) {
        return response.extract().body().path("accessToken");
    }

}