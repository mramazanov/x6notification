package com.javajabka.x6_notification.listener;

import com.javajabka.x6_notification.Utils.AsciiArtUtil;
import com.javajabka.x6_notification.model.OrderResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class NotificationConsumer {

    private AsciiArtUtil asciiArtUtil;

    public NotificationConsumer(AsciiArtUtil asciiArtUtil) {
        this.asciiArtUtil = asciiArtUtil;
    }

    @RabbitListener(queues = "${app.rabbitmq.queue}")
    public void receive(OrderResponse orderResponse) {
        asciiArtUtil.getAsciiArtMessage();
        log.info("Received message: " + orderResponse);
    }
}