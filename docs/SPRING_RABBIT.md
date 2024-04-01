
# Running Rabbit in Docker

Pull the image

```shell
docker pull bitnami/rabbitmq:3.12.13
```


```shell
mkdir -p /Users/devtools/integration/messaging/rabbitmq/docker/data
```

```shell
docker run -it --name rabbitmq --env RABBITMQ_USERNAME=rabbit --env RABBITMQ_PASSWORD=secret --env RABBITMQ_MANAGEMENT_ALLOW_WEB_ACCESS=true --rm  -p 5672:5672 -p 15672:15672 -v  /Users/devtools/integration/messaging/rabbitmq/docker/data:/bitnami/rabbitmq/mnesia  bitnami/rabbitmq:3.12.13
```

Start Application

1 - Create Vhost with default Quorum Queue Type
2 - Add parameter --spring.rabbitmq.virtual-host=account-balance

Testing 

1 - open http://localhost:15672/#/exchanges
2 - Click Exchange-> vhost: account-balance exchange:payment
3 - Publish message -> Headers: Content-Type: application/json -> payload
```json
{
  "id": "3",
  "amount": 33
}
```

4 - Get Payment 

```shell
curl -X 'GET' \
  'http://localhost:8080/readBalanceFunction/3' \
  -H 'accept: application/json'
```

Testing publish with RabbitMQ 


VHost: account-balaance




