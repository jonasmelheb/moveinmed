# MoveInMed

MoveInMed est une application (API RESTful) permettant à un utilisateur de gérer les professionnels, créer,
lire, modifier, supprimer des professionnels.

## Environnement de développement

### Pré-requis

* JAVA 11
* MAVEN
* POSTMAN (Pour tester l'application) 
* Database: Postgresql


### Installation

```bash
# Cloner le repository
git clone https://github.com/jonasmelheb/moveinmed.git
# Entrer dans le directory
cd moveinmed/
```
* Faire une ***Generate sources and Update folders*** de votre IDE

### Structure du projet
```
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── fr
    │   │       └── moveinmed
    │   │           ├── MainApp.java
    │   │           ├── controllers
    │   │           │   └── ProfessionalController.java
    │   │           ├── models
    │   │           │   └── Professional.java
    │   │           ├── repositories
    │   │           │   └── ProfessionalRepository.java
    │   │           └── services
    │   │               └── professionalService.java
    │   │               └── ProfessionalServiceImpl.java
    │   └── resources
    │       ├── application.properties
    │       ├── postman-collection
    │       │   └── MovInMed.postman_collection.json
    │       ├── database
    │       │   └── script-postgres.sql
    │       ├──
```

***DATABASE:***
* Dans le dossier ```src/main/resources/database``` vous trouverez le script sql pour créer la base de données et faire un jeux de données.

* Changer le fichier ***application.properties*** qui se trouve dans ```src/main/resources``` avec vos informations de votre base de données

***Exemple:***
```properties
spring.datasource.url=jdbc:postgresql://localhost:5433/VOTREDB
spring.datasource.username=VOTREUSER
spring.datasource.password=VOTREPASSWORD
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```

* Maintenant vous pouvez lancer l'application 

  
  ```mvn spring-boot:run``` ou ```java -jar target/moveinmed-1.0-SNAPSHOT.jar```


* Tester l'application avec ***POSTMAN***

**_NB:_** Vous trouvrerez la collection postman dans le dossier:
  ```  
  src/main/resources/postman-collection
  ```
