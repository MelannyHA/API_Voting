# Voting_API

API RESTful para gestionar un sistema de votaciones.  
Permite registrar votantes y candidatos, emitir votos únicos y consultar los resultados de la votación.  

## Tecnologías
- Java 17
- Spring Boot 3
- Maven
- MySQL
- JPA / Hibernate

## Requisitos previos
- Tener instalado **JDK 17+**
- Tener instalado **Maven**
- Tener **MySQL** corriendo en `localhost:3306`

## Instalación y ejecución
1. Clonar el repositorio:
   git clone https://github.com/usuario/voting-api.git
   cd voting-api


## Uso
1. Crear credenciales:
   spring.datasource.url=jdbc:mysql://localhost:3306/votingdb
   spring.datasource.username=root
   spring.datasource.password=TU_PASSWORD
   spring.jpa.hibernate.ddl-auto=update
2. Compilar y ejecutar
   mvn spring-boot:run
3. Acceder a la API:
   http://localhost:8080
Postman
4. Crear votante: 
http://localhost:8080/voters
   {
     "name": "Carlos Perez",
     "email": "carlos@example.com"
   }
5. Crear candidato:
http://localhost:8080/candidates
   {
     "name": "María Goméz",
     "party": "Partido Azul"
   }

6. Emitir voto:
http://localhost:8080/votes?voterId=1&candidateId=2


Notas:
Cada votante solo puede emitir un voto.
No se permite que un votante sea también candidato y viceversa.
Los votos se contabilizan automáticamente en el campo votes del candidato.

## Votantes
<img width="393" height="131" alt="image" src="https://github.com/user-attachments/assets/bd2bcfdb-6d0b-4fd1-9fb2-2dee4b02ed73" />

## Candidados
<img width="277" height="81" alt="image" src="https://github.com/user-attachments/assets/24646a6e-0909-4ebe-b3ee-0820f6472e36" />

## Votos y estadísticas (Postman)
<img width="217" height="137" alt="image" src="https://github.com/user-attachments/assets/f5caff8a-c8dc-4ed3-8048-0baeb8ce7e4e" />
<img width="313" height="279" alt="image" src="https://github.com/user-attachments/assets/c5de5ff7-3696-480e-8d93-64c15765de70" />

