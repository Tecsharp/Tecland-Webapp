

![]()
![]()
![]()



![](https://i.postimg.cc/j5YVt4gq/7.png)
# Tecland Webapp
Aplicación web para administrar un servidor de Minecraft basado en Spigot/Bukkit, con el uso de los plugins más importantes para la economía de un servidor survival, se ha creado el proyecto en Springboot, Thymeleaf y Maven.

## Recomendación de uso
Esta aplicación web realmente es para servidores medianos o de uso personal con amigos, puesto a que podría tener problemas de rendimiento si es que la usas con un servidor de Spigot con mods, pero bien se puede utilizar para servidores sin mods como Bukkit.

## Instalación
   Para instalarlo, puedes usar XAMPP en Windows o instalar LAMP en Linux.

   En los archivos del repositorio se encuentra el archivo de base de datos "tecland", la aplicación accede a esta base de datos desde el puerto 3306 de forma predeterminada, con el usuario "root" y la contraseña vacía, al igual que necesita de una base de datos llamada "springSession" que es donde se aloja el inicio de sesión, esta no importa que esté vacía, la app se encarga de llenarla y vaciarla de forma automática, pero debe existir con las mismas credenciales.

   Las credenciales se pueden cambiar desde las propiedades de la app en Spring y desde la clase "Constantes" donde están las credenciales del controlador de JDBC.

## Plugins necesarios en Minecraft Server
| Plugin | Descarga |
| ------ | ------ |
| AuthMe | [Spigot](https://www.spigotmc.org/resources/authmereloaded.6269/) - [GitHub](https://github.com/AuthMe/AuthMeReloaded)| 
| JobsReborn | [Spigot](https://www.spigotmc.org/resources/jobs-reborn.4216/) - [GitHub](https://github.com/Zrips/Jobs)|
| EssentialsMysqlStorage | [Spigot](https://www.spigotmc.org/resources/essentials-mysql-storage-extension.25673/) - [GitHub](https://github.com/brunyman/Essentials-MySQL-Storage-Extension) |
| AdvancedAchievement | [Spigot ](https://www.spigotmc.org/resources/advanced-achievements.83466/) - [GitHub](https://github.com/PyvesB/advanced-achievements) |

## Características de la app

#### 1. SISTEMA DE LOGIN

   ![](https://i.postimg.cc/qRc7TRGY/8.png)
   
   Cuenta con un sistema de inicio de sesión, con la misma encriptación que usa el plugiun AuthMe, además está totalmente sincronizado con el servidor, por lo cual te indicará desde la app tu última ip y si tú o un usuario está conectado.

#### 2. SISTEMA DE LOGROS
   ![](https://i.postimg.cc/R0ySftg2/5.png)
   
   Con el plugin AdvancedAchievement se logra crear un sistema de logros que son totalmente modificables, es cuestión de agregarlos directamente en la configuración del plugin para que la app los reconozca, manualmente tendrás que crear la miniatura, agregarla en la carpeta de "logros" y dar de alta la URL en la base de datos para que la pueda encontrar automáticamente cuando un usuario alcance ese logro.

#### 3. SISTEMA DE ESTADÍSTICAS
   ![](https://i.postimg.cc/ZqCYCHxr/6.png)
   
   Las estadísticas están casi totalmente recogidas del plugin AdvancedAchievment, por lo cual es muy necesario, éste nos entrega valores como "camas usadas" y el "número de pasos". Pero JobsReborn nos entrega estadísticas de niveles de trabajo, por lo que la aplicación no sería lo mismo sin este plugin.

#### 4. SISTEMA DE AMIGOS
   ![](https://i.postimg.cc/RVLZ8N0n/3.png)
   
   Este apartado sólo te permite agregar amigos y ver sus estados de conexión por ahora. También puedes ver sus perfiles buscando su nombre en el navegador:
```sh
127.0.0.1/nombreusuario
```
#### 5. PANEL ADMIN
   ![](https://i.postimg.cc/JhDqPwQt/9.png)
   Un panel pensado en administrar a los usuarios que ingresan, aún no está terminado, por lo cual sólo muestra una lista donde se puede editar o eliminar un usuario, por ahora.

#### Thymeleaf
   Se modificó el template de Materio para realizar esta app.

