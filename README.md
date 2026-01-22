# Notas de aula

Anotações de aula da disciplina de WEB 2.

## Pré-requisitos

- Java 25
- Maven

## Como executar

Para executar a aplicação, utilize o seguinte comando:

```bash
mvn spring-boot:run
```

## Endpoints da API

### Buscar notícia por ID

- **GET** `/news/{id}`

Busca uma notícia pelo seu ID.

### Filtrar notícias

- **GET** `/news`

Filtra as notícias com base nos seguintes parâmetros:

- `author` (opcional): Filtra as notícias por autor.
- `category` (opcional): Filtra as notícias por categoria.
- `order` (opcional, `inc` ou `dec`): Ordena as notícias pelo título. O padrão é `inc` (ascendente).
