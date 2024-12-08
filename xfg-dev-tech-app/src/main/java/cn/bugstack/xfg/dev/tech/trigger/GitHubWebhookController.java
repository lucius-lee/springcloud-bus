package cn.bugstack.xfg.dev.tech.trigger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
@RestController
public class GitHubWebhookController {

    @PostMapping("/webhook")
    public String handleGitWebhook(@RequestBody String payload) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode content = mapper.readTree(payload);

            log.info("收到 webhook {} 更新配置通知", content.get("pusher"));

            // 创建URL对象
            URL url = new URL("http://127.0.0.1:8000/actuator/bus-refresh");

            // 打开连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 设置请求方法为POST
            connection.setRequestMethod("POST");

            // 开启输入输出流
            connection.setDoOutput(true);

            // 设置请求头，如果需要，可以设置Content-Type等
            connection.setRequestProperty("Content-Type", "application/json");

            // 获取输出流
            try (OutputStream os = connection.getOutputStream()) {
                // 如果有请求体数据，也可以在这里写入
                // String jsonInputString = "{\"key\": \"value\"}";
                // os.write(jsonInputString.getBytes("utf-8"));
                os.flush();
            }

            // 发送请求并获取响应码
            int responseCode = connection.getResponseCode();

            log.info("调用 actuator/bus-refresh 更新全局配置完成 code:{}", responseCode);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "done";
    }

}