# MoveInMed

MoveInMed est une application (API RESTful) permettant a un utilisateur de gérer les professionals, créer,
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

  
***DATABASE:***
* Dans le dossier ```src/main/resources/database``` vous trouverez le script sql pour créer la base de données et un script pour faire un jeux de données.

* Changer le fichier ***application.properties*** qui se trouve dans ```src/main/resources``` avec vos informations de votre base do données

***Exemple:***
```properties
spring.datasource.url=jdbc:postgresql://localhost:5433/VOTREDB
spring.datasource.username=VOTREUSER
spring.datasource.password=VOTREPASSWORD
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```

* Maintenant vous pouvez lancer et tester l'application avec ***POSTMAN***



* Vous trouvrerez la collection postman dans le dossier:
  ```  
  src/main/resources/postman-collection
  ```