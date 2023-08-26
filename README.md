# PruebaSegundoBimestre

CONEXIÓN DE JAVA CON SQL SEVER:
INTEGRANTES:
-Hidalgo Paul
-Lascano David
-Morales Gilmar
-Ruiz Erick

Empezamos creado una base de datos en SQL server, la cual iniciaremos con dos regitros, el scrip para su creación es el siguiente:
  
  CREATE DATABASE PERSONAS;
  
  USE PERSONAS;
  
  CREATE TABLE REGISTROS( Codigo INT PRIMARY KEY, Cedula VARCHAR(50), Nombre VARCHAR(50), Nacimiento DATE, Signo VARCHAR(50) );
  
  INSERT INTO REGISTROS VALUES (1,'1752383838', 'Paul', '2002-04-10', 'Leo');
  
  INSERT INTO REGISTROS VALUES (2,'1010101010', 'Erick', '2008-11-20', 'Tauro');
  
  SELECT * FROM REGISTROS;

Ahora para la conexión, deberemos configurar varios parametros de SQL server, iniciando por el protocolo TCP/IP, este debe estar habilitado: 

![imagen](https://github.com/Paulesh5/PruebaSegundoBimestre_SQL/assets/117743844/7f33dcec-0c47-4137-b290-c8f79df9aca8)

También, deberemos iniciar SQL SERVER BOWSER:

![imagen](https://github.com/Paulesh5/PruebaSegundoBimestre_SQL/assets/117743844/8596e3ef-d811-48db-9f76-b4164cd31031)

(En caso de que no permita iniciar, deberemos entrar a las propiedades de SQL SERVER BOWSER, y en la pestaña de servicios cambiar el inicio como automática) 

![imagen](https://github.com/Paulesh5/PruebaSegundoBimestre_SQL/assets/117743844/4707f0d5-0d1e-4343-860c-3f046f37cbf6)

Ahora deberemos crear un nuevo usuario en SQL server, donde habilitaremos varias caracterisisticas y roles del mismo, que permitira el uso de la base de datos,
en este cado la base para el sistema.

![imagen](https://github.com/Paulesh5/PruebaSegundoBimestre_SQL/assets/117743844/2f86d93c-d689-4826-ab41-c14b1cd9b230)

Tener en cuenta que debemos desabilitar el cuadro de verificación que se encuentra debajo de verificar contraseña. Esto evitara que se cambie la contraseña.
En las opciones izquierdas de crear el usuario, entraremos en Server Roles, donde le daremos roles a dicho usuario:

![imagen](https://github.com/Paulesh5/PruebaSegundoBimestre_SQL/assets/117743844/80a5eab6-954f-4bd0-a194-956bf1e12e7e)

Y en la pestaña de User Mapping, selecionaremos las bases de datos que podra acceder, en este caso master y PERSONAS (PERSONAS es la base donde se encuentra la información
del sistema):

![imagen](https://github.com/Paulesh5/PruebaSegundoBimestre_SQL/assets/117743844/d340986c-c665-4aac-85d6-86f4d362902b)

Por último, cambiaremos una configuración de la base master, que permitira el ingreso con el usuario creado:

![imagen](https://github.com/Paulesh5/PruebaSegundoBimestre_SQL/assets/117743844/b55f1054-999a-4c53-8561-34ff16aa422d)

En la pestaña de seguridad, podremos ver los metodos de Autenticación marcaremos mixto.

Ahora descargaremos el driver(controlador) para IntelliJ IDEA, de la página oficial de de JET BRAIN, mismo que agregaremos a nuestro proyecto,
para lo cual entraremos a project structure detro de la app, y agregaremos dicha libreria-driver:

![imagen](https://github.com/Paulesh5/PruebaSegundoBimestre_SQL/assets/117743844/157be4a7-cb84-4a3a-8a04-39d645a6f620)

Con estas configuraciones ya podremos ingresar a la base de datos desde nuestro proyecto.

Deberemos verificar las credenciales en el proyecto:

![imagen](https://github.com/Paulesh5/PruebaSegundoBimestre_SQL/assets/117743844/e7650e3e-2e55-4d56-b0c3-83394e886977)

Principalmente debemos escribir correctamente la URL de la base con todas las especificaciones que se muestran.


CAPTURAS DE LA EJECUCIÓN:

![imagen](https://github.com/Paulesh5/PruebaSegundoBimestre_SQL/assets/117743844/5128f306-ea1d-4801-84bb-80faa043322a)














