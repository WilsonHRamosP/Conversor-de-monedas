# Conversor-de-monedas
conversor de monedas en tiempo real con uso de API
Currency Converter
Este es un proyecto de Conversor de Monedas desarrollado en Java. Utiliza la API de ExchangeRate para obtener las tasas de cambio entre diferentes divisas. La aplicación permite convertir montos de una moneda a otra en tiempo real.

Características
Conversión de monedas en tiempo real.
Soporte para múltiples divisas.
Uso de la API de ExchangeRate para obtener las tasas de cambio actualizadas.
Tecnologías Utilizadas
Java 21
IntelliJ IDEA como entorno de desarrollo.
API de ExchangeRate para tasas de cambio.
Maven para la gestión de dependencias.
Requisitos
Para ejecutar este proyecto necesitas tener instalado:

Java 21
IntelliJ IDEA
Maven
Configuración del Proyecto
Clona el repositorio:

bash
Copiar código
git clone https://github.com/tuusuario/currencyconverter.git
Accede al directorio del proyecto:

bash
Copiar código
cd currencyconverter
Configura el archivo application.properties con tu clave de API de ExchangeRate:

properties
Copiar código
exchange.rate.api.key=TU_CLAVE_API
Ejecuta el proyecto en IntelliJ IDEA.

Uso
Al ejecutar la aplicación, se te pedirá que ingreses una cantidad y selecciones la moneda de origen y la moneda de destino.
La aplicación consultará la API de ExchangeRate para obtener la tasa de cambio más reciente y calculará el monto convertido.
Ejemplo de Conversión
Si quieres convertir 100 USD a EUR, el programa te dará la tasa de cambio y el resultado, por ejemplo:

css
Copiar código
100 USD son equivalentes a 85 EUR
Contribución
Si deseas contribuir a este proyecto, siéntete libre de hacer un fork y enviar un pull request. Cualquier mejora o sugerencia es bienvenida.

Licencia
Este proyecto está licenciado bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.
