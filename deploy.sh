
echo "INICIANDO MAVEN"
mvn clean install -DskipTests=true
echo "INICIANDO COPIA"
cp ear/target/ear-0.0.1-SNAPSHOT.ear /Users/finatofinato/Finato/Java/jboss-as-7.1.1.Final.dbserver/standalone/deployments/
echo "FINALIZADA COPIA"
