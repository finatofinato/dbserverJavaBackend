//using mysql database
//create database with name 'dbserver' (utf-8)

//create the tables below
//------------------------------------mysql
CREATE TABLE `restaurante` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `votacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` int(11) NOT NULL,
  `email` varchar(60) NOT NULL,
  `restaurante_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_votacao_restaurante` (`restaurante_id`),
  CONSTRAINT `fk_votacao_restaurante` FOREIGN KEY (`restaurante_id`) REFERENCES `restaurante` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `resultados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` int(11) NOT NULL,
  `restaurante_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_resultados_restaurante` (`restaurante_id`),
  CONSTRAINT `fk_resultados_restaurante` FOREIGN KEY (`restaurante_id`) REFERENCES `restaurante` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

//i am using jboss-as-7.1.1.Final, so you need to modify some files to run without problems

$JBOSS_HOME/standalone/configuration/standalone.xml

		<datasource jta="true" jndi-name="java:jboss/datasources/MySqlDS" pool-name="MySqlDS" enabled="true" use-java-context="true" use-ccm="true">
                    <connection-url>jdbc:mysql://localhost:3306/dbserver</connection-url>
                    <driver>com.mysql</driver>
                    <transaction-isolation>TRANSACTION_READ_COMMITTED</transaction-isolation>
                    <security>
                        <user-name>dbserver</user-name>
                        <password>dbserver</password>
                    </security>
                </datasource>
                <drivers>
                    <driver name="com.mysql" module="com.mysql">
                        <xa-datasource-class>com.mysql.jdbc.Driver</xa-datasource-class>
                    </driver>
                </drivers>


cd $JBOSS_HOME/modules/com/
mkdir mysql
mkdir mysql/main
cd mysql/main
//inside 'main' folder, put the mysql jdbc driver (this version 27 works, but the last version doesn't...bugs)
//mysql-connector-java-5.1.27.jar

//inside 'main' folder, create the file module.xml with contents below
touch module.xml

<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.1" name="com.mysql">
  <resources>
    <resource-root path="mysql-connector-java-5.1.27.jar"/>
  </resources>
  <dependencies>
    <module name="javax.api"/>
    <module name="javax.transaction.api"/>
  </dependencies>
</module>







---------------------------------------------------------------------------
//these are just my drafts =) don't care about them

//jboss start
./Users/finatofinato/Finato/Java/jboss-as-7.1.1.Final.dbserver/bin/standalone.sh

//comandos para deploy (na raiz)
mvn clean install -DskipTests=true
cp ear/target/ear-0.0.1-SNAPSHOT.ear /Users/finatofinato/Finato/Java/jboss-as-7.1.1.Final.dbserver/standalone/deployments/
