# Nombre del Proyecto: Magic Ticket

## 🎪 Descripción del Proyecto

Magic Ticket es una plataforma web integral diseñada para la gestión y venta de tickets para shows de circo. El sistema ofrece dos roles de usuario principales: **Manager** y **Usuario**. Los Managers tienen control total sobre los shows, pudiendo añadir, editar y eliminar eventos. Los Usuarios, por otro lado, pueden explorar los shows disponibles, comprar tickets y revisar su historial de compras.

Este proyecto ha sido desarrollado utilizando un enfoque de **API RESTful** con **Spring Boot** para el backend, y una interfaz de usuario dinámica con **HTML, CSS y JavaScript** en el frontend. La persistencia de datos se maneja con **MySQL** a través de **JPA/Hibernate**.

-----

## ✨ Características Principales

### Para Managers:

  * **Gestión de Shows (CRUD):**
      * **Añadir Shows:** Registrar nuevos espectáculos con detalles como nombre, ubicación, fecha y hora, y precios de diferentes tipos de asientos (General, Platea, VIP).
      * **Editar Shows:** Modificar la información de shows existentes.
      * **Eliminar Shows:** Remover espectáculos de la lista.
  * **Visualización de Shows:** Ver todos los shows registrados.

### Para Usuarios:

  * **Exploración de Shows:** Visualizar la lista de todos los shows disponibles.
  * **Compra de Tickets:** Seleccionar un show y adquirir tickets para las diferentes zonas.
  * **Historial de Compras:** Acceder a un listado de todos los tickets comprados.

### Aspectos Técnicos:

  * **API RESTful:** Comunicación entre frontend y backend a través de endpoints REST.
  * **Base de Datos Relacional:** Almacenamiento persistente de datos en MySQL.
  * **Persistencia de Datos:** Utilización de JPA con Hibernate para la interacción con la base de datos.
  * **Interfaz de Usuario Responsiva:** Desarrollada con HTML, CSS y JavaScript, con el soporte de Bootstrap para un diseño moderno y adaptable.

-----

## 🛠️ Tecnologías Utilizadas

  * **Backend:**
      * Java 21
      * Spring Boot 3.4.6
      * Spring Data JPA
      * Hibernate
      * Maven (Gestor de dependencias)
  * **Base de Datos:**
      * MySQL
  * **Frontend:**
      * HTML5
      * CSS3
      * JavaScript 
      * Bootstrap 5
  * **Herramientas:**
      * Postman (para pruebas de API)
      * IntelliJ IDEA 

-----

## 🚀 Cómo Ejecutar el Proyecto

### Requisitos Previos

Asegúrate de tener instalados los siguientes programas:

  * **JDK 21**
  * **Apache Maven**
  * **MySQL Server**
  * Un IDE como **IntelliJ IDEA**

### Configuración de la Base de Datos

1.  Crea una base de datos MySQL con el nombre `circusweb_db`
2.  Actualiza las credenciales de tu base de datos en el archivo `src/main/resources/application.properties` de tu proyecto Spring Boot:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/circusweb_db
    spring.datasource.username= tu_usuario_mysql
    spring.datasource.password= tu_contraseña_mysql
    spring.datasource.driver-class = com.mysql.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```
    
### Ejecución del Backend (Spring Boot)

1.  Clona este repositorio:
    ```bash
    git clone https://github.com/Milagrosxp/CircusWebAplication
    ```
2.  Navega a la raíz del proyecto Spring Boot y compila el proyecto con Maven:
3.  Ejecuta la aplicación Spring Boot:
    El backend se iniciará en `http://localhost:8080`.

### Ejecución del Frontend

1.  Abre la carpeta del frontend llamada View, busca el archivo HTML principal, lo puedes encontrar como `indexPrincipal.html` y lo abres en tu navegador.

-----

## 📄 Bitácora de Commits

El historial de Git (`git log`) refleja la evolución del proyecto, mostrando los commits significativos que documentan el trabajo individual y en equipo, así como la progresión de las características implementadas. Se han realizado al menos 5 commits significativos por persona, distribuidos a lo largo del tiempo de desarrollo.

Puedes ver el historial de commits en GitHub: [Link al Historial de Commits del Repositorio](https://github.com/Milagrosxp/CircusWebAplication/commits/master/)

-----

## 🧪 Pruebas Funcionales con Postman

Se han realizado pruebas de la API REST utilizando Postman para asegurar la funcionalidad de cada endpoint del CRUD. Puede acceder a estás pruebas a partir del siguiente enlace: [Colección de Postman](https://web.postman.co/workspace/My-Workspace~e220957b-4452-4f91-837a-554372bc8c56/collection/45518391-8625e997-1b38-436c-b8d1-2710f6a61c13?action=share&source=copy-link&creator=45518391).

-----

## 🖥️ Interfaz Gráfica (Frontend)

La interfaz de usuario ha sido desarrollada con HTML, CSS y JavaScript, y se conecta directamente con la API REST de Spring Boot para ofrecer una experiencia de usuario fluida. Para acelerar el desarrollo del frontend y asegurar una implementación eficiente y con buenas prácticas, se utilizó YouTube, Google y ChatGPT como principales herramientas de apoyo.

## ETAPA INICIAL

### Estructura Inicial de Archivos del Frontend:
Basado en la estructura que se tenía originalmente en el proyecto de NetBeans y tomando como inspiración las páginas de ventas de Tickets StarTicket, SpecialTicket, eTicket y TicketMaster; Se decidió que la estructura general del FrontEnd sería la siguiente:
```
View/
| Principal (banner, introduction, features)
|
|__ Log In (REGISTER)
|   |
|   |__ Shows
|   |   |
|   |   |__ Register Shows (Forms, Table)
|   |
|   |__ Tickets
|      |
|      |__ See Shows (Cards with Button) 
|      |
|      |__ Buy Tickets ()
|      |
|      |__ My Tickets (Lista de Tickets comprados(table))
|   
|__ About Us (mision, vision, valores, etc)
|
|__ Legal Aspects
    |
    |__Terms & Conditions
    |__Privacy Politics
```
![Circus Web Meeting 2025-07-03 09_07 AM_Page 1- 1751556942614](https://github.com/user-attachments/assets/eef0fb85-d328-4afd-a543-7ceb5a33cb4a)
![Circus Web Meeting 2025-07-03 09_40 AM_Page 1- 1751558430042](https://github.com/user-attachments/assets/fd521a5a-6ad4-4015-8e70-b77cfad5a45c)

A partir de esto, con el siguiente Prompt **-Podrías darme ideas de paletas de colores que se puedan implementar en una página web de compra de tikets de circo?-** ChatGPT creó 5 paletas de colores distintas, de las cuales se eligió la que aparece a continuación. Los fonts utilizados fueron Rye y Monserrat de Google Fonts para encabezados y botones. Para el texto se utilizó la familia de Arial, Helvetica, sans-serif.
  * --rojo-carmesi: #D72638;
  * --amarillo-oro: #FFD23F;
  * --azul-marino: #1B1B3A;
  * --blanco-crema: #F8F1FF;
  * --negro-humo: #2E2E2E;

## ETAPA INTERMEDIA
Durante la creación del código se utilizó **Youtube** para crear la [animación de scroll](https://www.google.com/search?q=https://www.youtube.com/shorts/p8HPqBVp9lI%C2%A0), aprender a [insertar un video en html](https://www.google.com/search?q=https://www.youtube.com/shorts/bZfHkjC7tFA%C2%A0) y conocer las páginas que fueron utilizadas como inspiración para el footer del FrontEnd: [HoodzpahDesign](https://hoodzpahdesign.com/) y [MadeByShape](https://madebyshape.co.uk/).
Se investigó en **Google** como hacer un banner transparente y se obtuvo el css en [MDBootstrap](https://mdbootstrap.com/snippets/standard/mdbootstrap/2949651?view=side) para que funcionara. También se obtuvo el componente de [User Rating Card](https://www.w3schools.com/howto/howto_css_user_rating.asp) y [Testimonials](https://www.w3schools.com/howto/howto_css_testimonials.asp) en W3Schools.
Y finalmente **ChatGPT (OpenAI)** fue empleado para la creación de código JavaScript y optimización de código CSS, así como para aclarar dudas con respecto a ciertos errores que surgían en el proceso. Por ejemplo: Se obtuvo la animación de giggle con el Prompt **-Podrías explicarme como hacer que un button tenga una animación de giggle en css?-**, también se arregló el error de autoplay de video con el Prompt **-Me podés explicar porque el video no se autoreproduce en loop a pesar de haber colocado las propiedades de autoplay y loop?-** y el error de títulos centrados con el Prompt **-podrías explicarme por qué a pesar de que coloco esta línea así: `<h2 class="animate-on-scroll" style="text-align: center;">Our Core Values</h2>`, no se coloca el título centrado? El css de esa sección está así: --inserte sección de css values--**; así como se logró hacer que los banners fueran responsive con el Prompt **-como puedo hacer que el siguiente banner sea responsive, manteniendo el tamaño original de la imagen? --Inserte código css original--. -**. 
Y en la página de Legal Aspects se mejoró el css de un componente de Bootstrap mediante el prompt **-Podrías mejorar el css del siguiente código para que se vea como la imagen que te mandé(guía visual que aparece en la etapa inicial), manteniendo esa idea del css original que si se presionaba terms, el fondo era blanco crema y el color de letra azul; y si se presionaba privacy el fondo era azul y el color de letra blanco crema?: --Inserte código HTML y [código original CSS](https://www.w3schools.com/howto/howto_js_tab_header.asp)--. -** Asimismo, se utilizó en el módulo de Tickets con el siguiente prompt **-Me podrias ayudar a agregar en el documento HTML de compra el codigo de JavaScript para poder realizar la compra de los tickets y sus verificaciones.-**.

## VERSION FINAL

### Estructura de Archivos del Frontend:
```
    View/
    ├── assets/
    │   ├── css/
    │   │   ├── seeShowsStyle.css
    │   │   ├── shows.css
    │   │   ├── styleUserRegister.css
    │   │   ├── stylePrincipal.css
    │   │   └── styleAboutLegal.css
    │   ├── img/
    │   └── video/
    ├── about.html
    ├── compra.html
    ├── indexPrincipal.html
    ├── legal.html
    ├── login.html
    ├── myTicket.html
    ├── seeShows.html
    ├── shows.html
    └── userRegister.html
```
