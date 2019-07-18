# Proposta frontend

Este projeto foi desenvolvido como avaliação técnica.

### Ferramentas Utilizadas.

- Visual Code 1.27.2 
- Node 12.16.0
- npm 6.9.0
- AngularJS 1.7.8
- Docker 18.09.7

### Preparar o Ambiente.

- Faça um clone do projeto em seu workspace.
- No terminal navegue até o diretório raiz  do projeto frontend e excecute `npm install`.
- Após instalar todas as dependências suba o projeto backend, certifique-se que está rodando no seguinte endereço: localhost:8080.
- No diretório raiz execute `npm start`.
- Acesse a aplicação pela url `http://localhost:9000`.

### Docker

- No diretório raiz do projeto execute o comando `docker build .` para gerar a imagem.
- Execute o comando `docker run -d -p 9000:80 <id-imagem>` para subir o projeto.
- Acesse pelo navegador no seguinte endereço `http://localhost:9000`.
`
