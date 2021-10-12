DROP DATABASE IF EXISTS shop;
-- creamos la bd
CREATE DATABASE shop;
-- activamos la bd
USE shop;

create table TIPO_USUARIO(
idtipo int auto_increment,
descripcion varchar(50),
primary key (idtipo)
);

CREATE TABLE USUARIO(
id  int auto_increment,
nombre varchar(15),
apellido varchar(25),
usuario char(45) NOT NULL unique,
pswrd char(100) NOT NULL,
fecha_nac  date,
idtipo int,
estado  boolean,
primary key (id),
foreign key (idtipo) references TIPO_USUARIO(idtipo)
);

create table TIPO_PRODUCTO(
idcategoria int auto_increment,
descripcion varchar(50),
primary key (idcategoria)
);

create table PROVEEDOR(
id  int auto_increment,
nombre varchar(50),
descripcion varchar(100),
estado  boolean,
primary key (id)
);

CREATE TABLE PRODUCTO(
id int auto_increment,
descripcion varchar(100) not null,
precio double not null,
stock_actual int not null,
descuento int,
imagen LONGTEXT,
popular boolean,
idcategoria int not null,
proveedor int null,
primary key (id),
foreign key (idcategoria) references TIPO_PRODUCTO(idcategoria),
foreign key (proveedor) references PROVEEDOR(id)
);

CREATE TABLE BOLETA(
id int auto_increment,
idusuario int not null,
fecha date,
total double,
primary key(id),
foreign key (idusuario) references USUARIO(id)
);

CREATE TABLE DETALLE_BOLETA(
id int auto_increment,
idBoleta int not null,
idprod int not null,
cantidad int,
precioUnitario double,
precioTotal double,
primary key(id),
foreign key (idBoleta) references BOLETA(id),
foreign key (idprod) references PRODUCTO(id)
);

insert into TIPO_USUARIO values (NULL, 'Basico');
insert into TIPO_USUARIO values (NULL, 'Normal');
insert into TIPO_USUARIO values (NULL, 'Premiun');
select * from TIPO_USUARIO;

insert into USUARIO values(NULL, 'Luis', 'Lucas', 'user01', '1234', curdate(), 3, true);
insert into USUARIO values(NULL, 'Saul', 'Hudson', 'user02', '1234', curdate(), 2, true);
insert into USUARIO values(NULL, 'Perez', 'xd', 'user03', '1234', curdate(), 1, true);
select * from USUARIO;

insert into TIPO_PRODUCTO values (NULL, 'Gaming');
insert into TIPO_PRODUCTO values (NULL, 'Funko');
insert into TIPO_PRODUCTO values (NULL, 'Coleccionables');
insert into TIPO_PRODUCTO values (NULL, 'Audio');
insert into TIPO_PRODUCTO values (NULL, 'Monitores');
insert into TIPO_PRODUCTO values (NULL, 'Accesorios');
select * from TIPO_PRODUCTO;


insert into PROVEEDOR values (NULL, 'Proveedor01', 'Empresa que se encarga de distribuir Gaming', true);
insert into PROVEEDOR values (NULL, 'Proveedor02', 'Empresa que se encarga de distribuir Funkos', true);
insert into PROVEEDOR values (NULL, 'Proveedor03', 'Empresa que se encarga de distribuir Collecionables', true);
insert into PROVEEDOR values (NULL, 'Proveedor04', 'Empresa que se encarga de distribuir Audio', true);
insert into PROVEEDOR values (NULL, 'Proveedor05', 'Empresa que se encarga de distribuir Monitores', true);
insert into PROVEEDOR values (NULL, 'Proveedor06', 'Empresa que se encarga de distribuir Accesorios', true);
select * from PROVEEDOR;

insert into PRODUCTO values (NULL, 'Monitor 29 pulgadas', 999.99, 100, null, null, true, 5, 5);
insert into PRODUCTO values (NULL, 'PS5', 3999.99, 100, null, null, true, 1, 1);
select * from PRODUCTO;