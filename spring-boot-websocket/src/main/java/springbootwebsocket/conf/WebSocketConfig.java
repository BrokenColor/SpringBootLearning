package springbootwebsocket.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Description:WebSocket配置
 * <p>
 * Author: GWL
 * Date: Create in 18:55 2020/3/15
 */
@Configuration
public class WebSocketConfig {
    /**
     * 配置webSocket 配置信息，也就是配置webSocket 服务端点
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
