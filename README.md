# springboot-kafka-broker

#Start Zookeeper service
>zookeeper-server-start.bat D:\User\snaredla\Kafka\config\zookeeper.properties

#Start Kafka service
kafka-server-start.bat D:\User\snaredla\Kafka\config\server.properties


#Create New Topic using client
>kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic TestTopic


http://localhost:8925/api/users/push

Method: POST

Content-Type: application/json

Request:

{
    "id":1001,
    "name":"Test Topic User",
    "country":"India"
}

#Watch IDE console for new messages


#Watch new messages in Kafka consumer
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic TestTopic --from-beginning
