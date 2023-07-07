# Proyecto de Conversión de Unidades
Este proyecto en Java permite realizar conversiones de unidades en tres categorías: Divisas, Temperatura y Longitud. Proporciona una interfaz gráfica de usuario para seleccionar el tipo de conversión y realizar las conversiones de manera interactiva.

## Características
- Pantalla de bienvenida que solicita la confirmación del usuario para iniciar. 
- Menú de selección de tipo de unidad a convertir: Divisas, Temperatura o Longitud.
- Ventanas interactivas para ingresar los valores de conversión, seleccionar las unidades iniciales y de destino, y realizar las conversiones.
- Opción de limpiar el campo de entrada.
- Opción de regresar al menú de selección de tipo de conversión.
- Opción de cerrar la aplicación por completo.
- Utiliza la biblioteca JOptionPane para mostrar las ventanas de diálogo.
- Requiere una clave de API válida proporcionada por ExchangeRate-API para realizar conversiones de divisas. 

## Configuración
- Obtén una clave de API válida de ExchangeRate-API.
- Dentro de config.json, en la carpeta raiz del proyecto, modifica lo siguiente:
```
  {
  "api_key": "TU_CLAVE_DE_API"
  }
  ```
  Reemplaza TU_CLAVE_DE_API con tu clave de API obtenida de ExchangeRate-API.

## Requisitos del Sistema
Java JDK 8 o superior.

## Ejecución
1. Compila el proyecto usando el siguiente comando:
   - javac Main.java
2. Ejecuta el proyecto con el siguiente comando:
   - java Main
3. Se mostrará una ventana de bienvenida. Selecciona "Yes" para continuar.
4. Se abrirá una nueva ventana para seleccionar el tipo de unidad a convertir (Divisas, Temperatura o Longitud). 
5. Selecciona el tipo de unidad y se abrirá una ventana para ingresar los valores de conversión y realizar las conversiones. 
6. Sigue las instrucciones en pantalla y utiliza los botones proporcionados para interactuar con la aplicación.