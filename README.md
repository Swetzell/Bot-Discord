# Bot de Discord en Azure

Este repositorio contiene el código para un bot de Discord creado con Java, Maven y Docker. Es un bot simple que construí para aprender y, en el proceso, también adquirí conocimientos para subirlo a un servidor con Azure y Docker. El bot está diseñado para interactuar con usuarios en servidores de Discord, proporcionando funcionalidades personalizadas que pueden extenderse según las necesidades. Además, sigo aprendiendo Java a medida que desarrollo este tipo de proyectos.

## Tecnologías utilizadas

- **Java**: El lenguaje de programación principal utilizado para crear la lógica del bot.
- **Docker**: Utilizado para contenerizar la aplicación y facilitar su despliegue en diferentes entornos, como Azure.
- **Maven**: Utilizada para la gestión de dependencias y automatización de compilación que permite construir, probar, y empaquetar la aplicación de manera eficiente.
- **Azure**: Utilizada para alojar y desplegar el bot, aprovechando sus capacidades de escalabilidad y administración de contenedores.

## Despliegue en Azure

El bot está desplegado utilizando **Azure Container Instances**. A continuación se describen los pasos generales para el despliegue:

1. **Creación de la imagen Docker**: La aplicación fue contenida en una imagen Docker para que pudiera ser fácilmente desplegada en cualquier plataforma que soporte contenedores.
2. **Subida de la imagen a Azure**: La imagen Docker fue subida a **Azure Container Instances**, que proporciona un entorno eficiente y escalable para ejecutar aplicaciones en contenedores sin necesidad de gestionar servidores.
3. **Configuración de variables de entorno**: Se configuraron las variables de entorno necesarias para el correcto funcionamiento del bot, como el **token de Discord** y otras configuraciones específicas de la aplicación.

### URL de la instancia de contenedor:
`https://miregistroacr.azurecr.io/espongebot:v1`

## Instrucciones para ejecución local

Para ejecutar el bot en tu máquina local, sigue los siguientes pasos:

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/Swetzell/Bot-Discord.git
