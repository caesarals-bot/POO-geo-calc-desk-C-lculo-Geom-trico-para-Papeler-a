# GeoCalcDesk

GeoCalcDesk es una aplicación de escritorio desarrollada en Java que permite calcular el volumen y la superficie de diferentes figuras geométricas 3D de manera sencilla e intuitiva.

## Características

- Interfaz gráfica amigable con pestañas para cada tipo de figura
- Cálculo de volumen y superficie para:
  - Caja (prisma rectangular)
  - Cilindro
  - Esfera
- Validación de entrada de datos
- Botones para calcular y limpiar campos
- Visualización clara de resultados

## Requisitos

- Java 11 o superior
- Maven (solo para compilación)

## Cómo ejecutar

1. Asegúrate de tener Java instalado en tu sistema
2. Descarga o clona este repositorio
3. Navega hasta el directorio del proyecto
4. Ejecuta el siguiente comando:

```bash
java -jar target/GeoCalcDesk-1.0-SNAPSHOT.jar
```

O si estás usando un IDE como IntelliJ IDEA o Eclipse, simplemente importa el proyecto y ejecuta la clase `Main`.

## Uso

1. Selecciona la pestaña de la figura que deseas calcular
2. Ingresa las dimensiones requeridas
3. Haz clic en "Calcular" para ver los resultados
4. Usa el botón "Limpiar" para borrar los campos

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   ├── model/       # Modelos de figuras 3D
│   │   ├── ui/          # Interfaz de usuario
│   │   └── Main.java    # Punto de entrada de la aplicación
│   └── resources/       # Recursos (si los hay)
└── test/               # Pruebas unitarias (opcional)
```

## Tecnologías Utilizadas

- Java 11+
- Java Swing para la interfaz gráfica
- Maven para la gestión de dependencias

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más información.

## Capturas de Pantalla

*(Incluir capturas de pantalla de la aplicación en funcionamiento)*

## Contribuciones

Las contribuciones son bienvenidas. Por favor, lee las pautas de contribución antes de enviar un pull request.

## Autor

[Cesar Londoño] - [Caesarals@gmail.com]
