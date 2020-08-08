package com.sgldts.community.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sgldts.community.dto.GiteeUser;
import com.sgldts.community.mapper.UserMapper;
import com.sgldts.community.model.User;
import com.sgldts.community.utils.GiteeHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * @author herry
 * @create 2020-08-08-15:21
 */
@Controller
public class GiteeController {

    @Value("${gitee.oauth.clientid}")
    private String CLIENTID;

    @Value("${gitee.oauth.clientsecret}")
    private String CLIENTSECRET;

    @Value("${gitee.oauth.callback}")
    private String URL;

    @Autowired
    private UserMapper userMapper;

    /**
     * 授权回调
     */
    @GetMapping(value = "/callback")
    public String qqCallback(HttpServletRequest request) throws Exception {
        // 得到Authorization Code
        String code = request.getParameter("code");

        // Step2：通过Authorization Code获取Access Token
        String url = "https://gitee.com/oauth/token?grant_type=authorization_code" +
                "&client_id=" + CLIENTID +
                "&client_secret=" + CLIENTSECRET +
                "&code=" + code +
                "&redirect_uri=" + URL;
        JSONObject accessTokenJson = GiteeHttpClient.getAccessToken(url);

        // Step3: 获取用户信息
        url = "https://gitee.com/api/v5/user?access_token=" + accessTokenJson.get("access_token");
        JSONObject jsonObject = GiteeHttpClient.getUserInfo(url);
        /**
         * 获取到用户信息之后，就该写你自己的业务逻辑了
         */
        System.out.println(jsonObject.toString());
        String string = jsonObject.toString();
        GiteeUser giteeUser = JSON.parseObject(string, GiteeUser.class);
        System.out.println(giteeUser);
        if (giteeUser != null) {
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
            user.setName(giteeUser.getName());
            user.setAccountId(String.valueOf(giteeUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
            request.getSession().setAttribute("giteeUser", giteeUser);
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }

}
