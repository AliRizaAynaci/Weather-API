# Weather API
---
### Spring Boot Application
Fetches the weather information of the desired city

## Summary
Brings the weather information of the entered city via openweathermap api

---

# Tech Stack
- Java 17
- Spring Boot (Backend)
- Thymeleaf (Frontend)
- HTML, CSS
- Restful API
- Docker
- Java HTTP Client (for handling HTTP requests)
- OpenWeatherMap API (for weather data)

---

## Run & Build
```
docker build . -t weatherapi:1.0
docker images 

docker run --name weatherapi -d -p 9090:8080 weatherapi:1.0 
docker ps -a 

docker container rm -f b67f1db3166c
```
