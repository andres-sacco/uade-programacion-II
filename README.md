# UADE - Programacion II

Este repositorio contiene el código que se utilizara a lo largo de la cursada.

## Tabla de contenidos

Los siguientes son los tópicos o puntos más relevantes de este archivo:
- [Requerimientos](#Requerimientos)
- [Comprobar requerimientos](#Comprobar-requerimientos)

## Requerimientos

Para poder utilizar el código de este proyecto deberás tener las siguientes herramientas instaladas:

- [Java](https://www.oracle.com/ar/java/technologies/downloads/)
- [Git](https://git-scm.com/)

Si no tienes algunas de estas herramientas instaladas en tu computadora, sigue las instrucciones en la documentación oficial de cada herramienta.

## Comprobar requerimientos 

Si instaló en su computadora algunas de estas herramientas anteriormente o instalaste todas las herramientas ahora, verifica si todo funciona bien. 

- Para comprobar que versión de Java tienes en tu computadora puedes usar este comando: 
   ````
   % java -version
  openjdk 17.0.6 2023-01-17 LTS
  OpenJDK Runtime Environment Microsoft-7209853 (build 17.0.6+10-LTS)
  OpenJDK 64-Bit Server VM Microsoft-7209853 (build 17.0.6+10-LTS, mixed mode, sharing)
   ````
  
- Para comprobar si tienes intalado Git en tu maquina puedes hacerlo ejecutando el siguiente comando:

   ````
   % git -version
  git version 2.34.1
   ````

## Preguntas frecuentes

**¿Qué versión del JDK puedo usar en este proyecto?**

No hay restricción sobre qué versión en particular debes considerar, ya que existen diferentes alternativas al JDK:

* **OracleJDK**: Esta versión era gratuita hasta Java 11, después de esta versión puedes usarla para entornos de desarrollo/prueba, pero debes pagar una licencia para usarla en producción. Esta versión del JDK le ofrece los parches de errores más recientes y nuevas funciones porque Oracle es el propietario del lenguaje.

* **OpenJDK**: Cuando Oracle compró Sun Microsystems, creó esto como una alternativa de código abierto que todos los desarrolladores pueden usar en cualquier entorno sin restricciones. El principal problema de esta versión es que los parches de los errores tardan en aparecer en los casos que no son críticos.

Tenga en cuenta que existen otras alternativas, pero según el [Informe Snyk 2021](https://res.cloudinary.com/snyk/image/upload/v1623860216/reports/jvm-ecosystem-report-2021.pdf), la mayoría de los desarrolladores utilizan OpenJDK.


**¿Qué herramientas puedo utilizar para el desarrollo?**

Hay un sin fin de herramientas para el desarrollo, quizas las dos mas importantes son:
- [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/) – IntelliJ es el IDE más utilizado para el desarrollo.

- [Eclipse](https://www.eclipse.org/downloads/) – Eclipse es otra opción IDE para el desarrollo. La mayoría de los complementos son gratuitos y cuentan con una amplia comunidad de desarrolladores que los actualizan con frecuencia.

Tenga en cuenta que existen otros IDE, pero según el [Informe Snyk 2021](https://res.cloudinary.com/snyk/image/upload/v1623860216/reports/jvm-ecosystem-report-2021.pdf), la mayoría de Los desarrolladores de JVM utilizan Eclipse e Intellij, pero el uso del código de Visual Studio está creciendo en el último año.