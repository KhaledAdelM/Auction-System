create database AuctionSystem
on
primary (
name = AuctionSystemprimary ,
filename = 'D:\FCAIHU\2022-2023\Parallel Processing\DataBase/AuctionSystem.mdf',
size = 10MB ,
filegrowth = 5%
)
log on (
name = AuctionSystemlog ,
filename = 'D:\FCAIHU\2022-2023\Parallel Processing\DataBase/AuctionSystem.ldf',
size = 9MB ,
filegrowth = 5%
)
