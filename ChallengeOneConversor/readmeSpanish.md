# Proyecto de Conversión de Unidades

[![Maven Central](https://img.shields.io/maven-central/v/com.google.code.gson/gson.svg?label=Maven%20Central)](https://search.maven.org/artifact/com.google.code.gson/gson)
[![Maven Central](https://img.shields.io/maven-central/v/com.mashape.unirest/unirest-java.svg?label=Maven%20Central)](https://search.maven.org/artifact/com.mashape.unirest/unirest-java)
[![Maven Central](https://img.shields.io/maven-central/v/org.projectlombok/lombok.svg?label=Maven%20Central)](https://search.maven.org/artifact/org.projectlombok/lombok)
[![Maven Central](https://img.shields.io/maven-central/v/org.apache.logging.log4j/log4j-core.svg?label=Maven%20Central)](https://search.maven.org/artifact/org.apache.logging.log4j/log4j-core)


Este proyecto en Java te permite realizar conversiones de unidades en tres categorías: Divisas, Temperatura y Longitud. Proporciona una interfaz gráfica de usuario para seleccionar el tipo de conversión y realizar las conversiones de manera interactiva.

## Características
- Pantalla de bienvenida que solicita al usuario confirmación para comenzar.
- Menú para seleccionar el tipo de unidad a convertir: Divisas, Temperatura o Longitud.
- Ventanas interactivas para ingresar valores de conversión, seleccionar las unidades iniciales y objetivo, y realizar las conversiones.
- Opción para limpiar el campo de entrada.
- Opción para volver al menú de selección de tipo.
- Opción para cerrar completamente la aplicación.
- Utiliza la biblioteca JOptionPane para mostrar ventanas de diálogo.
- Requiere una clave de API válida proporcionada por ExchangeRate-API para realizar conversiones de divisas.

## Configuración
1. Obtén una clave de API válida de ExchangeRate-API, desde [ExchangeRate-API](https://app.exchangerate-api.com/ "The Accurate & Reliable Exchange Rate API").
2. Dentro de config.json, en la carpeta resources en main.java del proyecto, modifica lo siguiente:
```
  {
  "API_KEY": "YOUR_API_KEY"
  }
  ```
  Reemplaza YOUR_API_KEY con tu clave API obtenida de ExchangeRate-API.

## Requisitos del Sistema
- Java JDK 8 o superior.

## Instalación y Uso
1. Clona o descarga el proyecto en tu máquina local.
2. Compila el proyecto utilizando el siguiente comando:
   - mvn clean compile
3. Ejecuta el proyecto utilizando el siguiente comando:
   - mvn exec:java
4. Se mostrará una ventana de bienvenida. Selecciona "Sí" para continuar.
5. Se abrirá una nueva ventana para seleccionar el tipo de unidad a convertir (Divisas, Temperatura o Longitud).
6. Selecciona el tipo de unidad y se abrirá una ventana para ingresar los valores de conversión y realizar las conversiones.
7. Sigue las instrucciones en pantalla y utiliza los botones proporcionados para interactuar con la aplicación.

## Ejemplos
- Para convertir divisas:
   - Ejecuta el programa y selecciona "Sí" en la ventana de bienvenida.
   - Selecciona "Divisas" en el menú.
   - Ingresa el valor a convertir en el campo de entrada.
   - Selecciona las unidades iniciales y objetivo de la divisa.
   - Haz clic en "Convertir" para mostrar el valor convertido.
   - Haz clic en "Limpiar" para borrar el campo de entrada.
   - Haz clic en "Atrás" para volver al menú de selección de tipo.
   - Haz clic en "Cerrar" para salir de la aplicación.

## Unidades Soportadas
- Las conversiones de divisas admiten todos los valores posibles.
- Las conversiones de temperatura admiten las siguientes unidades:
   - Celsius
   - Fahrenheit
   - Kelvin
   - Rankine
- Las conversiones de longitud admiten las siguientes unidades:
   - km (kilómetro)
   - m (metro)
   - mi (milla)
   - ft (pie)
   - in (pulgada)

## Obtención de una Clave de API
Para obtener una clave de API, sigue estos pasos:
1. Crea una cuenta en el sitio web de ExchangeRate-API.
2. Inicia sesión en tu cuenta y dirígete a la sección "API Keys".
3. Tu clave de API se mostrará en el menú.

## Limitaciones
- La versión gratuita de ExchangeRate-API permite hasta 1500 solicitudes por mes. Hay planes adicionales disponibles en su sitio web.
