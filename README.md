- Устанавливаем posgresql:
```
sudo apt-get install postgresql postgresql-contrib
```

- Создаем базу данных и привязываем к ней пользователя:
```
sudo su - postgres
createdb restaurantdb
psql -s restaurantdb
create user codeinside password 'gliA6kkvn';
GRANT ALL PRIVILEGES ON DATABASE restaurantdb TO codeinside;
```

- Клонируем репозиторий с гитхаба:
```
git clone https://github.com/revalle88/restaurant2.git
```

- Переходим в корневую папку репозитория (где лежит pom.xml) и запускаем сборку проекта:
```
cd restaurant2/
mvn clean package
```

- Запускаем приложение из jar файла.
```
java -jar target/restaurant2-0.0.1-SNAPSHOT.jar
```

- Запускаем приложение в браузере:
```
http://localhost:8080/
```