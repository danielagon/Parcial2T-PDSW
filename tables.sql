
CREATE TABLE `USUARIOS` (
  `email` varchar(40)  NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`email`)
) ;


CREATE TABLE `ENTRADAS_FOROS` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_hora` timestamp,
  `contenido` text NOT NULL,
  `USUARIOS_email` varchar(40)  NOT NULL,
  PRIMARY KEY (`id`)
) ;


CREATE TABLE `COMENTARIOS` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_hora` timestamp,
  `contenido` text  NOT NULL,
  `ENTRADAS_FOROS_id` int(11) NOT NULL,
  `USUARIOS_email` varchar(40)  NOT NULL,
  PRIMARY KEY (`id`)
) ;



