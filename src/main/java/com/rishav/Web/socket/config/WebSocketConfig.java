package com.rishav.Web.socket.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //add endpoints for socketjs
        registry.addEndpoint("/ws").withSockJS(); //to work with secure websocket like http or https, use wss(web socket secure)

    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //enable simple broker
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");


    }
}
