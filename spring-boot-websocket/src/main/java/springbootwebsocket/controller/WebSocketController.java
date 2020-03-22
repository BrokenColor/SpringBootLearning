package springbootwebsocket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springbootwebsocket.socket.WebSocketUtils;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Description:
 * <p>
 * Author: GWL
 * Date: Create in 16:15 2020/3/22
 */
@RestController
@ServerEndpoint("/chat-room/{username}")
public class WebSocketController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @OnOpen
    public void openSession(@PathParam("username") String username, Session session) {
        WebSocketUtils.LIVING_SESSIONS_CACHE.put(username, session);
        String message = "欢迎用户[" + username + "] 来到聊天室！";
        log.info(message);
        WebSocketUtils.sendMessageAll(message);

    }

    @OnMessage
    public void onMessage(@PathParam("username") String username, String message) {
        log.info(message);
        WebSocketUtils.sendMessageAll("用户[" + username + "] : " + message);
    }

    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {
        //当前的Session 移除
        WebSocketUtils.LIVING_SESSIONS_CACHE.remove(username);
        //并且通知其他人当前用户已经离开聊天室了
        WebSocketUtils.sendMessageAll("用户[" + username + "] 已经离开聊天室了！");
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throwable.printStackTrace();
    }


    @GetMapping("/chat-room/{sender}/to/{receive}")
    public void onMessage(@PathVariable("sender") String sender, @PathVariable("receive") String receive, String message) {
        WebSocketUtils.sendMessage(
                WebSocketUtils.LIVING_SESSIONS_CACHE.get(receive),
                "[" + sender + "]" + "-> [" + receive + "] : " + message);
    }

}
