# Favorites Microservice

## Projenin Amacı

## Kullanılan Teknolojiler
* Spring Web
* Spring Data JPA
* SpringBoot Devtools
* Spring Validation
* Springfox Swagger-2
* PostgreSQL Driver
* Lombok

## Kurulum

Uygulama 12504 Port'u üzerinden çalışmaktadır bu sebeple uygulamayı başlatmadan önce portun açık olduğundan emin olmanız gerekmektedir. Ancak, sunucunun çalışacağı portu application.properties dosyasında aşağıda bulunan alanı değiştirerek istediğiniz port'ta kullanabiliirsiniz.
```
server.port=12504
```

Veri tabanı ismi favorite olarak tanımlanmıştır ancak aşağıda bulunan dataSource.url'den veri tabanı isminizi değiştirebilirsiniz. Ek olarak,  **favorite** isminde bir şema tanımlamanız gerekmektedir (Entity'lerede şema ismi bu şekilde tanımlanmıştır).
```
spring.datasource.url=jdbc:postgresql://localhost:5432/favorite
```

Proje PostgreSQL kullanılarak geliştirilmiştir ancak lokalinizde farklı bir ilişkisel veri tabanı kullanıyorsanız aşağıdaki adımları takip edebilirsiniz. Ek olarak, aşağıda belirtilen alanı build gradle'dan değiştirmeniz gerecektir.
```
runtimeOnly 'org.postgresql:postgresql'
```

Gerekli konfigürasyonları bitirmenizin ardından hibernate tablolarınızı otomatik olarak yaratacaktır. Swagger'a erişmek için aşağıda bulunan linki kullanabilirsiniz.
```
http://localhost:12504/swagger-ui.html
```
> Not : Server portuna göre link'i konfigüre etmeniz gerekebilir

### MSSQL Kurulumu ve Konfigürasyonlar
Build gradle dosyasında kurulum bölümünde belirtilen alanı aşağıdaki kod ile değiştirmeniz gereklidir.
```
runtimeOnly 'com.microsoft.sqlserver:mssql-jdbc'
```

Aşağıda verilen PostgreSQL datasource.url'ini, veri tabanınıza ait olan datasource.url'i ile değiştirilmesi gereklidir.
```
spring.datasource.url=jdbc:postgresql://localhost:5432/favorite
```

Veri tabanınıza yetkilendirilmiş kullanıcıya ait username ve password'u değiştirmek için aşağıda bullunan alanları kullanabilirsiniz
``` 
spring.datasource.username=postgres
spring.datasource.password=postgres
```

Son olarak aşağıda bulunan spring.jpa ayarını veri tabanınız için değiştirmeniz gerecektir.
``` 
spring.jpa.database=sql_server
```

### MYSQL Kurulumu ve Konfigürasyonlar
Build gradle dosyasında kurulum bölümünde belirtilen alanı aşağıdaki kod ile değiştirmeniz gereklidir.
```
runtimeOnly 'mysql:mysql-connector-java
```

Aşağıda verilen PostgreSQL datasource.url'ini, veri tabanınıza ait olan datasource.url'i ile değiştirilmesi gereklidir.
```
spring.datasource.url=jdbc:postgresql://localhost:5432/favorite
```

Veri tabanınıza yetkilendirilmiş kullanıcıya ait username ve password'u değiştirmek için aşağıda bullunan alanları kullanabilirsiniz
```
spring.datasource.username=postgres  
spring.datasource.password=postgres
```

Son olarak aşağıda bulunan spring.jpa ayarını veri tabanınız için değiştirmeniz gerecektir.
```
spring.jpa.database=mysql
```

## Uygulama Akışı

