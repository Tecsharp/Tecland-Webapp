# Tecland Webapp
Aplicación web para administrar un servidor de Minecraft basado en Spigot/Bukkit, con el uso de los plugins más importantes para la economía de un servidor survival, se ha creado el proyecto en Springboot, Thymeleaf y Maven.


## Plugins necesarios en Minecraft Server
| Plugin | Descarga |
| ------ | ------ |
| AuthMe | [Spigot](https://www.spigotmc.org/resources/authmereloaded.6269/) - [GitHub](https://github.com/AuthMe/AuthMeReloaded)| 
| JobsReborn | [Spigot](https://www.spigotmc.org/resources/jobs-reborn.4216/) - [GitHub](https://github.com/Zrips/Jobs)|
| EssentialsMysqlStorage | [Spigot](https://www.spigotmc.org/resources/essentials-mysql-storage-extension.25673/) - [GitHub](https://github.com/brunyman/Essentials-MySQL-Storage-Extension) |
| AdvancedAchievement | [Spigot ](https://www.spigotmc.org/resources/advanced-achievements.83466/) - [GitHub](https://github.com/PyvesB/advanced-achievements) |

## Características de la app

#### 1. SISTEMA DE LOGIN:
   
   Cuenta con un sistema de inicio de sesión, con la misma encriptación que usa el plugiun AuthMe, además está totalmente sincronizado con el servidor, por lo cual te indicará desde la app tu última ip y si tú o un usuario está conectado.

#### 2. SISTEMA DE LOGROS:

   Con el plugin AdvancedAchievement se logra crear un sistema de logros que son totalmente modificables, es cuestión de agregarlos directamente en la configuración del plugin para que la app los reconozca, manualmente tendrás que crear la miniatura, agregarla en la carpeta de "logros" y dar de alta la URL en la base de datos para que la pueda encontrar automáticamente cuando un usuario alcance ese logro.

#### 3. SISTEMA DE ESTADÍSTICAS:

   Las estadísticas están casi totalmente recogidas del plugin AdvancedAchievment, por lo cual es muy necesario, éste nos entrega valores como "camas usadas" y el "número de pasos". Pero JobsReborn nos entrega estadísticas de niveles de trabajo, por lo que la aplicación no sería lo mismo sin este plugin.

#### 4. SISTEMA DE AMIGOS:

   Este apartado sólo te permite agregar amigos y ver sus estados de conexión por ahora. También puedes ver sus perfiles buscando su nombre en el navegador:
```sh
127.0.0.1/nombreusuario
```
#### 5. PANEL ADMIN:

   Un panel pensado en administrar a los usuarios que ingresan, aún no está terminado, por lo cual sólo muestra una lista donde se puede editar o eliminar un usuario, por ahora.

