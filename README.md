# GeoCalcDesk

GeoCalcDesk es una aplicación de escritorio desarrollada en Java que permite calcular el volumen y la superficie de diferentes figuras geométricas 3D de manera sencilla e intuitiva. La aplicación cuenta con una interfaz gráfica moderna y responsiva, diseñada para ofrecer una excelente experiencia de usuario.

## Características

### Interfaz Intuitiva
- Pestañas organizadas para cada tipo de figura.3D
- Diseño limpio y profesional con bordes y espaciado optimizados
- Validación de entrada en tiempo real
- Retroalimentación visual inmediata

### Figuras Soportadas
- **Caja (Prisma Rectangular)**: Cálculo de volumen y área superficial
- **Cilindro**: Cálculo de volumen y área superficial
- **Esfera**: Cálculo de volumen y área superficial

### Funcionalidades Avanzadas
- **Validación de Entrada**:
  - Comprobación de valores numéricos positivos
  - Retroalimentación visual para campos inválidos
  - Mensajes de error descriptivos
- **Atajos de Teclado**:
  - `Enter` para realizar cálculos
  - Navegación entre campos con `Tab`
  - `Escape` para limpiar campos
- **Menú Contextual**:
  - Copiar resultados al portapapeles
  - Limpiar campos con clic derecho
- **Eventos Inteligentes**:
  - Validación en tiempo real
  - Autoselección de texto al enfocar campos
  - Limpieza automática al cambiar de pestaña

## Requisitos

- Java 11 o superior
- Maven 3.6+ (solo para compilación)
- 4GB de RAM recomendados
- Resolución de pantalla mínima: 1024x768

## Cómo Ejecutar

### Desde el código fuerte:
1. Clona el repositorio:
   ```bash
   git clone https://github.com/tuusuario/GeoCalcDesk.git
   cd GeoCalcDesk
   ```
2. Compila el proyecto con Maven:
   ```bash
   mvn clean package
   ```
3. Ejecuta la aplicación:
   ```bash
   java -jar target/GeoCalcDesk-1.0-SNAPSHOT.jar
   ```

### Usando un IDE:
1. Importa el proyecto como un proyecto Maven existente
2. Ejecuta la clase `Main` en el paquete `ui`

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   ├── model/       # Modelos de figuras 3D (Caja, Cilindro, Esfera)
│   │   │   ├── Caja.java
│   │   │   ├── Cilindro.java
│   │   │   └── Esfera.java
│   │   │
│   │   ├── ui/          # Interfaz de usuario
│   │   │   ├── Calculadora3DFrame.java  # Ventana principal
│   │   │   ├── FiguraPanel.java         # Clase base abstracta
│   │   │   ├── CajaPanel.java           # Panel de Caja
│   │   │   ├── CilindroPanel.java       # Panel de Cilindro
│   │   │   └── EsferaPanel.java         # Panel de Esfera
│   │   │
│   │   └── Main.java    # Punto de entrada de la aplicación
│   │
│   └── resources/       # Recursos (imágenes, iconos, etc.)
│
└── test/               # Pruebas unitarias
    └── java/
        └── model/      # Pruebas de las clases del modelo
```

## Tecnologías Utilizadas

- **Java 11+**: Lenguaje de programación principal
- **Swing**: Biblioteca para la interfaz gráfica
- **Maven**: Gestión de dependencias y construcción
- **Java AWT**: Para manejo de eventos y gráficos
- **JUnit**: Para pruebas unitarias

## Uso

1. **Selecciona una figura** en la pestaña correspondiente
2. **Ingresa las dimensiones** requeridas
   - Usa punto (.) como separador decimal
   - Los campos se validan automáticamente
3. **Presiona Calcular** o la tecla `Enter`
4. **Los resultados** aparecerán en el área inferior
5. Usa **Limpiar** o `Escape` para reiniciar

## Características de la Interfaz

### Validación en Tiempo Real
- Los campos resaltan en rojo cuando contienen errores
- Mensajes de ayuda contextuales
- Bloqueo de caracteres no numéricos

### Navegación Intuitiva
- Cambio entre campos con `Tab`
- Cálculo con `Enter`
- Limpieza con `Escape`
- Menú contextual con clic derecho

### Retroalimentación Visual
- Bordes con títulos descriptivos
- Colores de fondo para indicar estado
- Tooltips informativos

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más información.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, lee las [pautas de contribución](CONTRIBUTING.md) antes de enviar un pull request.

## Autor

[César Londoño](mailto:caesarals@gmail.com) - Desarrollador Principal

## Capturas de Pantalla

*(Incluir capturas de pantalla de la aplicación en funcionamiento)*

## Notas de la Versión

### v1.0.0 (2025-10-21)
- Versión inicial de la aplicación
- Soporte para cálculo de Caja, Cilindro y Esfera
- Interfaz de usuario intuitiva
- Validación de entrada
- Documentación completa
