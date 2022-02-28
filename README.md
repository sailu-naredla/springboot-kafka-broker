# springboot-kafka-broker

#Download kafka binary from below link

https://kafka.apache.org/downloads.html

NOTE: Choose latest Binary like Scala 2.13 etc.

#Unzip using 7-zip

#Rename Kafka soure folder name(unziped folder name) to D:\User\snaredla\Kafka
#Create folder named "data" under D:\User\snaredla\Kafka
   a. create sub folder D:\User\snaredla\Kafka/data/zookeeper
   b. create sub folder D:\User\snaredla\Kafka/data/kafka
#Make the changes in D:\User\snaredla\Kafka\config to override the default configuration of zookeeper and Kafka server
   a. edit zookeeper property file with
     dataDir=D:\\\\User\\\\snaredla\\\\Kafka\\\\data\\\\zookeeper
 NOTE: Choose respective folder structure - I am using Windows 10 and Kafka path is D:\User\snaredla\Kafka
 
   b. edit server property file with 
     zookeeper.connect=localhost:2181
     log.dirs=D:\\\\User\\\\snaredla\\\\Kafka\\\\data\\\\kafka
 NOTE: Choose respective folder structure - I am using Windows 10 and Kafka path is D:\User\snaredla\Kafka
     listeners=PLAINTEXT://localhost:9092
     
#open command prompt on folder
D:\User\snaredla\Kafka\bin\windows

#Start Zookeeper service
zookeeper-server-start.bat D:\User\snaredla\Kafka\config\zookeeper.properties

#Start Kafka service
kafka-server-start.bat D:\User\snaredla\Kafka\config\server.properties


#Create New Topic using client
>kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic TestTopic

#Invoke below API to test bothe Producer and Consumer
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
