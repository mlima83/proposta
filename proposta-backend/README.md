# Proposta backend

Este projeto foi desenvolvido como avaliação técnica.

### Ferramentas Utilizadas.

- Spring tool suite 4
- JDK 1.8

### Frameworks utilizados.

- Banco de dados h2
- Spring boot 2.1.6.RELEASE
- Apache Maven 3.6.0

### Preparar o Ambiente.

- Faça um clone do projeto em seu workspace.
- No eclipse vá em file > import > Maven > Existing maven projects, realize a importação do projeto.
- Clique com o botão direito na classe br.com.calcard.PropostaBackendApplication.java > Run as > Java application
- Acesse a aplicação pela url `http://localhost:8080`.

### Docker

- No diretório raiz do projeto execute o comando `./mvnw install dockerfile:build` para gerar a imagem.
- Execute o comando `docker run -p 8080:8080 -d calcard/proposta-backend` para subir o projeto.
- Acesse pelo navegador no seguinte endereço `http://localhost:8080`.

### Sobre o motor de crédito

O motor de análise de crédito utiliza árvore de decisão com o Algoritmo ID3 (Inductive Decision Tree).
Através da mostragem disponibilizada na avaliação, o algoritmo toma a decisão baseando-se na probabilidade de ganho em cada ramificação de informação relevante.
Foi utilizada a implementação realizada pelo Leandro Carlos Fernandes, referência: https://github.com/leandro-carlos-fernandes/id3
`
