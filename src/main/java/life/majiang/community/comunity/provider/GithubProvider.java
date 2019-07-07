package life.majiang.community.comunity.provider;

import com.alibaba.fastjson.JSON;
import life.majiang.community.comunity.dto.AccessTokenDto;
import life.majiang.community.comunity.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;



@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDto accessTokenDto){

       MediaType mediaType = MediaType.get("application/json; charset=utf-8");
       OkHttpClient client= new OkHttpClient();

        System.out.println("clent: " + client);
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDto));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/authorize")
                .post(body)
                 .build();
            try (Response response = client.newCall(request).execute()) {
                String string = response.body().string();
//                String[] split = string.split("&");
//                String tokenstr = split[0];
//                String token = tokenstr.split("=");
                System.out.println(string);
                return string;
            } catch (IOException e) {
                e.printStackTrace();
            }

        return null;
    }
    public GithubUser getUser(String accesToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accesToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string=response.body().string();
            System.out.println("string: "+string);
            GithubUser githubUser = JSON.parseObject(string,GithubUser.class);
           return githubUser;
        } catch (IOException e) {
            return  null;
        }
    }
}
