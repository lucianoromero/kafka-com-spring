# kafka-com-spring

Projeto de exemplo utilizando Apache Kafka com Spring Boot para produção e consumo de mensagens.

## Tecnologias Utilizadas
- Java
- Spring Boot
- Apache Kafka
- Docker
- Maven

## Estrutura do Projeto
```
producer/
├── docker-compose.yml         # Configuração do ambiente Kafka via Docker
├── pom.xml                    # Dependências do projeto
├── src/
│   ├── main/java/com/live/kafka/stream/
│   │   ├── ProducerApplication.java   # Classe principal
│   │   ├── config/KafkaConfig.java    # Configuração do Kafka
│   │   ├── consumer/CarConsumer.java  # Consumidor de mensagens
│   │   ├── controller/CarController.java # API REST para envio de mensagens
│   │   ├── controller/CarDTO.java     # DTO para mensagens
│   │   ├── exception/ProducerException.java # Exceções customizadas
│   │   └── producer/CarProducer.java  # Produtor de mensagens
│   └── resources/application.properties # Configurações do Spring/Kafka
└── test/java/com/live/kafka/stream/ProducerApplicationTests.java # Testes
```

## Como Executar

### 1. Subir o ambiente Kafka com Docker

No diretório `producer`, execute:
```cmd
cd producer
docker-compose up -d
```

### 2. Executar a aplicação Spring Boot

```cmd
mvnw spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

## Exemplos de Uso

### Produzir uma mensagem
Envie uma requisição POST para `/api/cars`:
```json
{
  "id": "1",
  "model": "VW",
  "color": "Fusca"
}
```

### Consumir mensagens
O consumidor está configurado para ler as mensagens do tópico Kafka e processá-las automaticamente.

## Como Contribuir
1. Faça um fork do projeto
2. Crie uma branch (`git checkout -b feature/nova-feature`)
3. Commit suas alterações (`git commit -m 'Minha nova feature'`)
4. Faça um push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## Licença
Este projeto está sob a licença MIT.
