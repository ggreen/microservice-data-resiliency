
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



Create Vhost with default Quorum Queue Type


Add parameter --spring.rabbitmq.virtual-host=account-balance
