# Favorites Microservice

## Projenin Amacı
Favorites Mikroservis uygulaması, cep telefonunuzdaki uygulamaların kullanım sürelerini kayıt altına alan sanal bir uygulamadan gelen verileri işleyip depolayan ve kullanıcının en çok kullandığı 4 uygulamayı gösteren bir mikroservistir. 

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

### Senaryo
Uygulamanın kullancının son 24 saatte kullandığı en favori 4 uygulamasını liste halinde göstermesi gerekmetedir. Gün değişiminde liste yenilenir ve önceki güne ait olan veriler history tablosunda depolanır. Kullanıcı geçmiş günlerde hangi uygulamayı en çok kullandığını sorgulayabilecektir.

### Gözardı Edilen Durumlar
* Uygulamanın kullanımı esnasında zaman diliminin değişmeyeceği düşünülmüştür.
* Kullanıcının cep telefonu saatini değiştiremeyeceği düşünülmüştür.
* Kullanıcının gece yarısından önce uygulamaları kapattığı düşünülmüştür (Uygulamanın 23:00'da kullanılıp 00:30'da bırakılması durumunda 90 dakikalık kullanım süresi yeni güne yazılacaktır). 

### CASE : Kullanıcının uygulama kullanım sürelerinin kaydedilmesi
* Kullanıcı bir uygulamaya girdiğinde kullanım süresi sayılmaya başlar, kullanmayı bitirdiğinde ise harcadığı süre dakika cinsinden kayıtlanmak amacıyla mikroservis'e gönderilir
* Sanal aplikasyon uygulamaya ait daha önce bir kayıt olup olmadığını kontrol etmek amacıyla **/hasFavoriteList/{APP_NAME}** servisini çağırır ve hali hazırda favori listesinde uygulamanın kayıdının olup olmadığını sorgular
* Favori listesinde kayıt olmaması durumunda **/createFavoriteApp** api'si kullanılarak yeni kayıt oluşturulur.

### CASE : Kullanıcının etkinliklerinin loglanması
* Veri tabanında uygulamaya ait bir kayıt olması durumunda kullanım süresi **/durationLog** servisi kullanılarak arttırılacaktır. Güncelleme esnasında yeni güne gelinmiş ise favorites tablosundaki kayıt history tablosuna atılacaktır ve favorites tablosundaki kayıt yeni gelen veri ile güncellenecektir.

### CASE : Favori uygulamaların tarihe göre çekilmesi
* Sanal telefon uygulaması ekranın ilk açılışında default olarak günün tarihini kullanarak **/getFavorites** api'si üzerinden en favori 4 uygulama verisini erişebilecektir.

## Complexity hakkındaki düşünceler
Favorite tablosu kullanıcının o gün içerisinde kullandığı uygulamaların kaydını tutmaktadır bu sebeple gün içerisinde **n** adet uygulama kullanması durumunda tabloda da **n** adet kayıt tutulacağı anlamına gelmektedir. 
Buradaki olumsuz durum ise herhangi bir gün sonu işi yazılmadığından dolayı ve tablonun sadece sanal uygulamadan gelen güncelle request'ine bağlı olarak güncellenmesi sebebi ile kullanılmayan eski kayıtların favorite tablosunda kalmaya devam edecek olmasıdır.
