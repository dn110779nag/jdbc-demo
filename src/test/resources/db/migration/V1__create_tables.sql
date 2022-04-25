/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  dn110
 * Created: 24 апр. 2022 г.
 */



create table items(
    id serial primary key,
    name varchar(32),
    description text
);