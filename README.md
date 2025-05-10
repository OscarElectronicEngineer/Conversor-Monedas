# 💱 Conversor de Monedas en Java

Este es un proyecto de consola en Java que permite convertir entre diferentes monedas en tiempo real utilizando una API externa de tipo de cambio. Está desarrollado con buenas prácticas de programación orientada a objetos y una arquitectura limpia dividida en capas.

---

## ⚙️ ¿Cómo funciona?

El programa muestra un menú con pares de monedas disponibles. El usuario selecciona una opción, ingresa el monto a convertir y el sistema consulta en tiempo real el resultado de la conversión usando una API externa. El resultado se muestra de forma clara y formateada en la consola.

---

## 🧩 ¿De qué se compone?

El sistema está dividido en clases y paquetes que cumplen funciones específicas:

- **`Main.java`**: Ejecuta el programa, muestra el menú, lee la opción del usuario e imprime el resultado.
- **`ConversorMoneda.java`**: Contiene los pares de monedas disponibles y su gestión.
- **`CapturarDatosApi.java`**: Conecta con la API `https://www.exchangerate-api.com/` para obtener el tipo de cambio.
- **`Moneda.java`**: Es un *record* que mapea automáticamente la respuesta JSON de la API.
- **Estructura en paquetes**:
  - `modelos`: contiene la lógica del modelo y acceso a datos.
  - `principal`: contiene la clase principal que ejecuta el programa.

---

## 🛠️ Tecnologías utilizadas

- Java 21
- API REST (`HttpClient`)
- GSON (para procesar JSON)
- IDE: IntelliJ IDEA
- API: [ExchangeRate-API](https://www.exchangerate-api.com/)

---

## ✅ Características destacadas

- Entrada interactiva con `Scanner`.
- Validación de opciones del menú.
- Arquitectura clara y mantenible.
- Uso de emojis y diseño visual amigable para consola.
- Preparado para futuras mejoras (como interfaz gráfica con JavaFX).

---



📌 Nota

Este proyecto usa la API gratuita de ExchangeRate-API, recuerda colocar tu clave en la variable API_KEY dentro de CapturarDatosApi.java.
