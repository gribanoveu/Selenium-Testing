## Selenoid

### Для запуска тестов через селеноид в докер контейнере (Windows):
#### Запуск при помощи selenoid не отличается от запуска через Selenium Grid, но требеут запущенный docker с контейнером selenoid

    - Установить Docker desktop app
    - установить wsl 2
    - скачать selenoid https://github.com/aerokube/cm/releases
    - запустить selenoid 
        - в папке с файлом cm.exe открыть терминал
        ./cm selenoid start --vnc --port 4444
        ./cm selenoid-ui start
    - в команде запуска указать запуск на удаленной машине mvn -Dremote=true
    
    