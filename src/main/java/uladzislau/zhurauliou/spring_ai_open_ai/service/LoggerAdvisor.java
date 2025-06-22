package uladzislau.zhurauliou.spring_ai_open_ai.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.AdvisedRequest;
import org.springframework.ai.chat.client.RequestResponseAdvisor;
import org.springframework.ai.chat.metadata.ChatResponseMetadata;
import org.springframework.ai.chat.model.ChatResponse;

public class LoggerAdvisor implements RequestResponseAdvisor {

    private static final Logger log = LoggerFactory.getLogger(LoggerAdvisor.class);

    @Override
    public AdvisedRequest adviseRequest(AdvisedRequest request, Map<String, Object> context) {
        String model = request.chatOptions().getModel();
        String userText = request.userText();
        String systemText = request.systemText();

        log.info(String.format("Request to %s model.", model));
        log.info(String.format("User text: %s.", userText));
        log.info(String.format("System text: %s", systemText));
        return request;
    }

    @Override
    public ChatResponse adviseResponse(ChatResponse response, Map<String, Object> context) {
        ChatResponseMetadata metadata = response.getMetadata();

        log.info(String.format("Response metadata: %s", metadata));
        return response;
    }
}
