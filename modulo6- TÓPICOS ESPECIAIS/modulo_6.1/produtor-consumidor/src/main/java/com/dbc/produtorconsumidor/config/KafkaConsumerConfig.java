package com.dbc.produtorconsumidor.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {
    private static final String EARLIEST = "earliest";
    private static final String LATEST = "latest";
    @Value(value = "${kafka.bootstrap-server}")
    private String bootstrapServer;
    @Value(value = "${kafka.client-id}")
    private String clientId;

    private <T> Map<String, Object> consumerConfigs(Class<? extends Deserializer<T>> clazz,
                                                    String autoOffset) {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, clazz);
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, clientId);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 10);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffset);
        return props;
    }

    private <T> ConsumerFactory<String, T> consumerFactory(Class<? extends Deserializer<T>> clazz,
                                                           String autoOffset) {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(clazz, autoOffset));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> listenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory(StringDeserializer.class, EARLIEST));
        return factory;
    }
}
