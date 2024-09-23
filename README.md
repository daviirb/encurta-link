# Encurta Link

Um serviço simples para encurtar URLs, permitindo que os usuários gerem links curtos a partir de URLs longas e redirecionem esses links para os destinos originais.

## Tecnologias Utilizadas

- Java
- Spring Boot
- PostgreSQL
- Apache Commons Lang
- JPA (Java Persistence API)

## Funcionalidades

- **Encurtar URL**: Permite que os usuários enviem uma URL longa e recebam uma URL curta.
- **Redirecionamento**: Os usuários podem acessar a URL curta, que redirecionará para a URL original.


## Endpoints

### POST /encurta-link

- **Descrição**: Gera uma URL encurtada.
- **Requisição**:
  - **Body**: `{ "urlOriginal": "URL_LONGA_AQUI" }`
- **Resposta**:
  - **Status**: 201 Created
  - **Body**:
    ```json
    {
      "id": 1,
      "urlLonga": "URL_LONGA_AQUI",
      "urlRedirecionamento": "http://localhost:8080/r/URL_ENCURTADA",
      "urlQrCode": "QR CODE INDISPONIVEL NO MOMENTO",
      "urlCriadaEm": "2024-09-23T10:00:00"
    }
    ```

### GET /r/{urlEncurtada}

- **Descrição**: Redireciona para a URL original a partir da URL encurtada.
- **Parâmetros**:
  - `urlEncurtada`: A parte encurtada da URL.
- **Resposta**:
  - **Status**: 302 Found (redireciona) ou 404 Not Found

<img width="1309" alt="Captura de Tela 2024-09-23 às 12 21 48" src="https://github.com/user-attachments/assets/424e8fb0-3cfe-48ba-a6d9-b07200da594d">
<img width="1354" alt="Captura de Tela 2024-09-23 às 12 22 36" src="https://github.com/user-attachments/assets/67d41b9d-0259-4a4b-aad4-f08c83f809ca">



https://github.com/user-attachments/assets/f59218b7-9e19-4585-9669-ae4b804c523a




