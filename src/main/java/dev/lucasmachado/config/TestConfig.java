package dev.lucasmachado.config;

import dev.lucasmachado.services.DbService;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DbService dbService;

    @Bean
    public boolean instantiateDatabase() throws ParseException {
        dbService.instantiateTestDatabase();
        return true;
    }

//    @Bean
//    public NewTopic topic() {
//        return new NewTopic("example-topic", 10, (short) 0);
//    }
//
//    @KafkaListener(topicPartitions = @TopicPartition(topic = "example-topic",
//            partitions = "#{@finder.partitions('example-topic')}"))
//    public void listen(@Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key, String payload) {
//        System.out.println(key + ":" + payload);
//    }
//
//    @Bean
//    public PartitionFinder finder(ConsumerFactory<String, String> consumerFactory) {
//        return new PartitionFinder(consumerFactory);
//    }
//
//    public static class PartitionFinder {
//
//        public PartitionFinder(ConsumerFactory<String, String> consumerFactory) {
//            this.consumerFactory = consumerFactory;
//        }
//
//        private final ConsumerFactory<String, String> consumerFactory;
//
//        public String[] partitions(String topic) {
//            try (Consumer<String, String> consumer = consumerFactory.createConsumer()) {
//                return consumer.partitionsFor(topic).stream()
//                        .map(pi -> "" + pi.partition())
//                        .toArray(String[]::new);
//            }
//        }
//    }

}
