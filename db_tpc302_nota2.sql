
--create database db_tpc302_nota2;

use db_tpc302_nota2;

drop table cliente;
drop table estadocliente;
drop table tipocliente;

create table estadocliente(
stdcli int,
stddesc varchar(20),
primary key(stdcli));

create table tipocliente(
tipocliid int,
tipodesc varchar(100),
primary key(tipocliid));

create table cliente(
clienteid bigint identity(100201,1),
nombres varchar(100),
apellidos varchar(100),
email varchar(100),
telefono int,
edad int,
renta int,
stdcli int default 1,
tipocliid int,
primary key(clienteid),
unique(email),
foreign key(stdcli) references estadocliente(stdcli),
foreign key(tipocliid) references tipocliente(tipocliid));

insert into estadocliente values(1, 'Activo');
insert into estadocliente values(2, 'No activo');

insert into tipocliente values(1, 'Silver');
insert into tipocliente values(2, 'Gold');
insert into tipocliente values(3, 'Titan');

insert into cliente (nombres, apellidos, email, telefono, edad, renta, tipocliid) 
values('Pedro', 'Matta', 'pe.matta@tpc302.ip', 987654321, 25, 450000, 1);

insert into cliente (nombres, apellidos, email, telefono, edad, renta, tipocliid) 
values('Jessica', 'Aguilar', 'je.aguilar@tpc302.ip', 985263741, 30, 1250000, 2);

insert into cliente (nombres, apellidos, email, telefono, edad, renta, tipocliid) 
values('Andrea', 'Reyes', 'an.reyes@tpc302.ip', 974185236, 41, 2190000, 3);

select c.*, tc.tipodesc, ec.stddesc 
from cliente c 
join tipocliente tc on c.tipocliid = tc.tipocliid
join estadocliente ec on c.stdcli = ec.stdcli;

drop procedure sp_insert_cliente;
go
create procedure sp_insert_cliente
@p_clienteid int,
@p_nombre varchar(100),
@p_apellido varchar(100),
@p_email varchar(100),
@p_telefono int,
@p_edad int
as
	insert into cliente(clienteid, nombres, apellidos, email, telefono, edad)
	values(@p_clienteid, @p_nombre, @p_apellido, @p_email, @p_telefono, @p_edad);
go
select * from cliente

drop procedure sp_buscar_cliente;
go
create procedure sp_buscar_cliente
@cliid int
as
	select c.*, e.stddesc, t.tipodesc
	from cliente c 
	join estadocliente e on c.stdcli = e.stdcli
	join tipocliente t on c.tipocliid = t.tipocliid 
	where c.clienteid = @cliid;
go

go 
drop procedure sp_listar_cliente;
go
create procedure sp_listar_cliente
as
	select c.*, e.stddesc, t.tipodesc
	from cliente c 
	join estadocliente e on c.stdcli = e.stdcli
	join tipocliente t on c.tipocliid = t.tipocliid  
go
