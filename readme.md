
#  Conversor de Monedas en Java

¡Bienvenido/a a este emocionante proyecto de desarrollo en Java!  
Este conversor de monedas es una aplicación práctica que consume una API de tasas de cambio para ayudarte a convertir entre diferentes divisas en tiempo real.

---

##  Objetivo

Construir una aplicación funcional que:

- Realice solicitudes a una API de tipo de cambio.
- Analice respuestas en formato JSON.
- Permita filtrar monedas específicas.
- Muestre resultados claros al usuario.

---

##  Tecnologías Usadas

- **Java** (versión 8 o superior)
- **IDE recomendado**: IntelliJ IDEA / Eclipse / NetBeans
- **API REST pública** de tasas de cambio:  
  [ExchangeRate API](https://www.exchangerate-api.com/) o  
  [ExchangeRatesAPI.io](https://exchangeratesapi.io/)
- **Librerías**:
  - `HttpURLConnection` o `OkHttp` (para las solicitudes HTTP)
  - `Gson` (para parsear JSON)

---



##  Pasos del Desarrollo

1. **Configuración del ambiente Java**  
   Instala JDK 8+ y un entorno de desarrollo como IntelliJ IDEA.

2. **Creación del proyecto**  
   Estructura tu proyecto con carpetas `/src`, agrega tus clases Java base.

3. **Consumo de la API**  
   Usa `HttpURLConnection` o `OkHttpClient` para hacer una solicitud GET a la API.

4. **Análisis de la respuesta JSON**  
   Analiza la respuesta JSON con la librería `Gson`.

5. **Filtro de monedas**  
   Extrae solo las monedas que deseas mostrar (por ejemplo: USD, EUR, COP, BRL).

6. **Exhibición de resultados**  
   Muestra la tasa de cambio actual y permite convertir cantidades entre monedas.

---

##  Ejemplo de Uso

```
Ingrese la moneda de origen: USD
Ingrese la moneda de destino: COP
Ingrese la cantidad: 100

Resultado: 100 USD = 390000 COP
(Tasa de cambio actual: 1 USD = 3900 COP)
```

---


##  Contribuciones

¡Las contribuciones son bienvenidas!  
Puedes hacer un **fork**, crear una nueva rama, agregar tu funcionalidad y enviar un **pull request**.

---

**Desarrollado con 💻 por [Yudnaris]**

> Proyecto educativo para aprender Java y consumo de APIs REST.
