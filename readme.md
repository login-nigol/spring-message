1. ## Цель проекта

Минисервис на Java Spring, который позволит пользователям обмениваться сообщениями.

2. ## Функционал

### 2.1. Отправка сообщений

Пользователь имеет возможность отправить сообщение другому пользователю, указав его email.

### 2.2. Получение сообщений

Пользователь имеет возможность просматривать список полученных сообщений.

Система предоставляет возможность фильтрации сообщений по отправителю.

Реализована пагинация для списка сообщений.

### 2.3. Ответ на сообщения

Пользователь имеет возможность ответить на полученное сообщение.

При ответе система *автоматически заполняет поле получателя email’ом отправителя исходного сообщения.

### 2.4. Удаление сообщений

Пользователь имеет возможность удалять отправленные и полученные сообщения.

Удаление логическое (пометка сообщения как удаленного без физического удаления из базы данных).

3. ## Технические характеристики

### 3.1. Архитектура

Используется Spring Boot для создания RESTful API.

Применение принципа чистой архитектуры (Clean Architecture) для разделения слоев приложения.

### 3.2. База данных

Используется реляционная база данных PostgreSQL.

Используется ORM для работы с базой данных.

### 3.3. API

Эндпоинты:

POST /api/messages - отправка нового сообщения

GET /api/messages - получение списка сообщений с возможностью фильтрации и пагинации

GET /api/messages/{id} - получение конкретного сообщения по ID

POST /api/messages/{id}/reply - ответ на конкретное сообщение

DELETE /api/messages/{id} - пометка сообщения как удаленного
