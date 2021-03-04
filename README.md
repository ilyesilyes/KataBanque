# KataBanque
Kata Project : est un mini site web pour la gestion de compte bancaire.
il est implementé en java avec le framework Spring boot en plus d'une base de donnée derby pour saimplifier l'utilisation   
Diffrent web service sont implementer notament des API de creation/suppression/depot/retrait de compte bancaire et consulation des operations 

#lancer le projet

Vous pouvez importer le maven projet sur votre edireur eclipce ou intellij ou bien lancer directement le jar file: java -jar target/kata-0.0.1-SNAPSHOT.jar
Vous pouvez consulter swagger pour voir la documentation des api : localhost:8081/v2/api-docs   (si vous lancer le projet en local)

#test des api

afin de tester les api pour lancer des requet get ou post à travers postman ou autre application
1/ creation de compte   
  methode : POST
  add content-type : application/Json
  url : localhost:8081/kata/createCompte
  
2/ consulation des compte   
  methode : GET
  url : localhost:8081/kata/obtenirToutCompte
 
3/ depot du compte   
  methode : GET
  url : localhost:8081/kata/depotCompte/1/80

4/ retrait du compte   
  methode : GET
  url : localhost:8081/kata/retaitCompte/1/30
   
5/ consulation de historique des operations   
  methode : GET
  url : localhost:8081/kata/histoireToutCompte
  
6/ consulation de historique des operations pour un compte   
  methode : GET
  url : localhost:8081/kata/histoireCompte/1
  

 
 
