package cn.georgesecret.provider;

import cn.georgesecret.entity.AccessToken;
import cn.georgesecret.entity.GithubUser;
import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {
    public String getAcessToken(AccessToken accessToken){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessToken));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            System.out.println(string);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    public GithubUser getGithubUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();

        try{
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            return JSON.parseObject(string,GithubUser.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
