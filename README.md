## Módulo 3 PMP

Módulo 3 do Projeto de PMP para entrega do Projeto Final, nele foi atendido os seguintes requisitos:

```
Módulo 3
Crie uma função Lambda que escute um tópico Kafka e exiba no console a mensagem recebida, por exemplo:

A mensagem chegou: <mensagem>

Em seguida:

Gere uma imagem Docker dessa aplicação.

Publique a imagem no DockerHub através de uma GitHub Action configurada no repositório.
```

### Observação
* Inicialmente, para o 3° módulo, temos apenas esta aplicação. Que irá ser integrada com os próximos módulos posteriormente.

---

## 📘 Estrutura do Projeto

```
modulo-lambda/
├── 📁 .github ← Workflows CI/CD e configurações de automação
├── 📁 .idea ← Configurações da IDE (IntelliJ)
├── 📁 .mvn ← Scripts auxiliares do Maven Wrapper
├── 📁 src
│   ├── 📁 main
│   │   ├── 📁 java
│   │   │   └── 📁 modulo_lambda ← Pacote principal da aplicação
│   │   │       ├── 📁 function ← Funções Lambda e handlers principais
│   │   │       ├── 📁 utils/json ← Utilidades e classes para manipulação de JSON
│   │   │       └── 📄 ModuloLambdaApplication.java ← Classe principal da aplicação
│   │   └── 📁 resources
│   │       ├── 📁 payload ← Exemplos de payloads para testes
│   │       ├── 📄 application.properties ← Configurações padrão
│   │       ├── 📄 application-local.properties ← Configurações para ambiente local
│   │       └── 📄 logback-spring.xml ← Configuração de logs
│   ├── 📁 test ← Testes automatizados
├── 📁 target ← Artefatos gerados pelo Maven
├── 📄 .gitattributes ← Normalização de arquivos e regras de texto
├── 📄 .gitignore ← Arquivos ignorados pelo Git
├── 📄 docker-compose.yml ← Orquestração de containers para ambiente local
├── 📄 Dockerfile ← Definição da imagem Docker da aplicação
├── 📄 HELP.md ← Documentação auxiliar do Spring Boot
├── 📄 mvnw ← Maven Wrapper (Linux/Mac)
├── 📄 mvnw.cmd ← Maven Wrapper (Windows)
├── 📄 pom.xml ← Gerenciamento de dependências e build Maven
└── 📄 README.md ← Este arquivo


````
## 🧩 Tecnologias Utilizadas

- **Spring Boot** → Framework Back-End
- **Java** → Linguagem de programação
- **Maven** → Build
- **Docker** → Containers e virtualização
- **MongoDB** → Persistência de dados
- **Redis** → Cache
- **Graylog** → Central de Logs
- **SonarQube** → Qualidade do Código
- **Github Actions** → CI/CD automatizado
- **Spring Boot** → Framework Back-End
- **Docker Hub** → Repositório de imagens Docker
- **Kafka** → Mensageria via Eventos
- **Zookeeper** → Gerenciamento do Kafka
---
## ✅ Qualidade de Código (SonarQube)

> A Qualidade de Código do Projeto é Analisada através do SonarQube, verifique os badges a seguir que apresentam as métricas obtidas no projeto!

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo3&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo3)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo3&metric=bugs)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo3)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo3&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo3)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo3&metric=coverage)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo3)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo3&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo3)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo3&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo3)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo3&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo3)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo3&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo3)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo3&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo3)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo3&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo3)

---

## Imagens Docker
#### A imagem do Projeto está presente no link a seguir!
### [Módulo 3](https://hub.docker.com/r/juliosn/lambda-consumer)

---

## 📦 Instalação e Configuração do Ambiente
> Obs.: Tenha as imagens acima baixadas e presentes no seu docker para execução!

### 1️⃣ Clone o projeto na sua máquina e baixe as dependências:
```bash
# Clonar repositório
git clone https://github.com/PMP-Projects/modulo3.git

# Acesse a pasta do projeto
cd modulo2
````

### 2️⃣ Suba os Containers e Rode a Aplicação
```bash
# Inicie os containers (MongoDB, Kafka, Zookeper OpenSearch, Graylog), juntamente com o Dockerfile da aplicação
docker compose up -d --build
```

#### Serviços do Docker Compose

Caso queira acessar o gerenciamento de logs ou a base de dados do MongoDB, você pode utilizar esses acessos
- Graylog Web UI: http://localhost:9000 (usuário: admin, senha: admin)
- MongoDB: localhost:27017

---

### 🧪 Execução e Testes com Kafka

#### Esta aplicação consome mensagens do tópico Kafka lambda.kafka
> Para facilitar os testes, foi criado o utilitário JsonHexUtil, responsável por:
> - Ler arquivos JSON do diretório resources
> - Minificar o JSON (remover espaços e quebras)
> - Converter o conteúdo para hexadecimal UTF-8
> - Garantir uma entrada padronizada para testes locais e automatizados
> #### OBS.: O valor da conversão hexadecimal é exibido nos logs da aplicação


#### Isso ajuda a testar dois cenários:
- Mensagens JSON comuns
- Mensagens em hexadecimal convertidas pelo JsonHexUtil

📦 Exemplo de Payload JSON
- #### Arquivo em src/main/resources/payload/client.json:
```
{
"nome": "Julio",
"dataNascimento": "2000-10-10"
}
```

🔁 Conversão JSON ➜ Hexadecimal
- Com o método:
  - JsonHexUtil.jsonResourceToHex("payload/client.json");

- O arquivo acima é convertido para:
  - 7b226e6f6d65223a224a756c696f222c22646174614e617363696d656e746f223a22323030302d31302d3130227d

#### ▶️ Enviando mensagens para o Kafka
1. Entre no container do Kafka
```
docker exec -it kafka bash
```

##### 📤 Enviar JSON diretamente para o tópico
```
echo '{"nome":"Julio","dataNascimento":"2000-10-10"}' \
| kafka-console-producer --broker-list localhost:9092 --topic lambda.kafka
```


##### Enviar com chave (exemplo: "key" → hexadecimal 6b6579)
```
echo -n "6b6579:7b226e6f6d65223a224a756c696f222c22646174614e617363696d656e746f223a22323030302d31302d3130227d" \
| kafka-console-producer --broker-list localhost:9092 --topic lambda.kafka --property parse.key=true --property key.separator=":"
```

📡 Verificando se o consumer recebeu
> Alternativamente, pode ser testado através de aplicações como o Offset Explorer


Ao enviar qualquer uma das mensagens acima, você deverá ver no console da aplicação:

```
Recebendo cadastro do cliente:
Nome do Cliente: xxxx
Data de Nascimento: xxxx
```

---

## 📦 Esteira CI/CD com Github Actions

A esteira CI/CD deste projeto é automatizada via Github Actions.

###  Etapas da Esteira:
1️⃣ Verificação de **Vulnerabilidades** com o **Trivy**

2️⃣ Análise de qualidade de código com **Sonar Cloud**

3️⃣ Subida da Imagem no DockerHub

---

---

## ✍️ Autor do Projeto

<div align="center">

| [<img src="https://avatars.githubusercontent.com/u/99426563" width=115><br><sub>Júlio Neves</sub>](https://github.com/juliosn)
| :---: |

</div>

---
