use AuctionSystem

create table Clients (
Id int identity(25000 ,1) primary key,
Name nvarchar (50) ,
Email nvarchar (100) ,
Birthday date,
Username nvarchar (50) ,
Password nvarchar (50) ,
)


create table Products (
Id int identity(1 ,1) primary key,
Id_Client int  foreign key references Clients (Id) on delete cascade on update cascade,
product nvarchar (50) ,
Sold Bit DEFAULT 0,
Price int,
Details nvarchar (250) 
)

create table Bid (
Id int identity(1 ,1) primary key,
Id_Product int  foreign key references Products (Id) on delete cascade on update cascade,
Id_Client int  foreign key references Clients (Id),
Price int
)