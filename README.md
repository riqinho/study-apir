
  

# Study APIR

  

  

API Java para estudo de Spring Boot

## Client Database
````
docker pull ubuntu
docker pull debian
docker images
docker run ubuntu
docker run -it ubuntu
docker ps
docker ps -a
````

  
## Docker
````
docker pull ubuntu
docker pull debian
docker images
docker run ubuntu
docker run -it ubuntu
docker ps
docker ps -a
docker rm 3d97af3e50f9
docker rm -f 3d97af3e50f9
````
  

## Instalação

  

### Limpar e criar a pasta */target*

````
mnv clean packge
````

  

___

### Configuração do Swagger

  

- https://springdoc.org/properties.html

 
___

  

### application.properties

  

```
spring.application.name=study-apir
springdoc.swagger-ui.path=/
```

  

## Navegação

  

  

### Executar a API

  

-  *Executando*  **Maven**

````

mnv sping-boot:run

````

  

  

### Documentação da API (Swagger)

  

- http://localhost:8080/swagger-ui/index.html

  

  

## Referências

  

- https://springdoc.org/