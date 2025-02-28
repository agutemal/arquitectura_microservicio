# Configuración del Microservicio

Este proyecto es un microservicio que está configurado para funcionar con una base de datos PostgreSQL. A continuación se describen las configuraciones clave.

## Configuracion del archivo application.properties

```properties
spring.application.name=microservicio
server.servlet.context-path=/api/v1
spring.datasource.url=jdbc:postgresql://localhost:5432/Prueba
spring.datasource.username=postgres_user
spring.datasource.password=bEto2386
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.initialization-mode=always
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
hibernate.format_sql=true
hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE

spring.data.web.pageable.page-parameter=p
spring.data.web.pageable.size-parameter=limit
