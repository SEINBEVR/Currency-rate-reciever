# CURRENCY RATE RECIEVER
## Техническое задание
#### Создать сервис, который обращается к сервису курсов валют, и отдает gif в ответ:
* если курс по отношению к рублю за сегодня стал выше вчерашнего, то отдаем рандомную отсюда https://giphy.com/search/rich
* если ниже - отсюда https://giphy.com/search/broke
#### Ссылки
[REST API курсов валют](https://docs.openexchangerates.org/)
[REST API гифок](https://developers.giphy.com/docs/api#quick-start-guide)
#### Must Have
- [x] Сервис на Spring Boot 2 + Java / Kotlin
- [x] Запросы приходят на HTTP endpoint, туда передается код валюты
- [x] Для взаимодействия с внешними сервисами используется Feign
- [x] Все параметры (валюта по отношению к которой смотрится курс, адреса внешних сервисов и т.д.) вынесены в настройки
- [x] На сервис написаны тесты (для мока внешних сервисов можно использовать @mockbean или WireMock)
- [x] Для сборки должен использоваться Gradle
- [x] Результатом выполнения должен быть репо на GitHub с инструкцией по запуску
#### Nice to Have
- [x] Сборка и запуск Docker контейнера с этим сервисом

## Stack
* Kotlin
* Spring Boot
* Spring Cloud(Open Feign)
* JUnit5

## Сборка и запуск
* Произвести клонирование репозитория командой:
> git clone https://github.com/SEINBEVR/Currency-rate-reciever.git
* Перейдя в корневую папку собрать проект:
> gradlew build
* Собрать докер-образ с произвольным именем:
> docker image build -t currencyreciever .
* Запустить контейнер с образом
> docker run -p 8080:8080 docker.io/library/currencyreciever 

## Endpoints
Возвращает .gif в зависимости от курса валют
* /api/gif/Код_валюты
> Пример : **http://localhost:8080/api/gif/BTC**

