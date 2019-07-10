-- schema.sql
drop database if exists db_mall;

create database db_mall;

use db_mall;
#grant 权限 on 数据库.* to 用户名@登录主机 identified by “密码”
grant select, insert, update, delete on db_mall.* to 'root'@'localhost' identified by 'root';

#商品表
#名称,内容,商品介绍,商品详情介绍,商品标签,商品数量,生产时间,生产地,原价,折扣价,计量单位,存放温度
create table t_goods (
    `id` bigint not null auto_increment,
    `name` varchar(50) not null,
    `content` varchar(500),
    `goods_intro` varchar(50) ,
    `detail_intro` varchar(50),
    `label` varchar(50),
    `amount` int,
    `production_time` varchar(50),
    `production_place` varchar(50),
    `origin_price` decimal(9,2),
    `discount_price` decimal(9,2),
    `measure_unit` varchar(50) ,
    `storage_temp` varchar(50) ,
    primary key (`id`)
) engine=innodb default charset=utf8;

#媒体资源表
create table t_media_resource(
  `id` bigint not null auto_increment,
  `name` varchar(50),
  `url` varchar(500) not null,
  primary key (`id`)
)engine=innodb default charset=utf8;

#用户表
create table t_user(
  `id` bigint not null auto_increment,
  `name` varchar(50) not null,
  `image` varchar(500),
  `phone_number` int(11),
  `wechat_bind` varchar(500),
  `qr_code` varchar(500),
  primary key (`id`)
)engine=innodb default charset=utf8;

#收获地址表
create table t_address (
    `id` bigint not null auto_increment,
    `user_id` bigint not null,
    `name` varchar(50),
    `gender` int,
    `phone_number` int(11),
    `address` varchar(50),
    `subaddress` varchar(50),
    `type` int,
    foreign key(`user_id`) references t_user (`id`),
    primary key (`id`)
) engine=innodb default charset=utf8;

#优惠劵表
#名称,有效期,限制条件,价格,是否已使用
create table t_coupon(
    `id` bigint not null auto_increment,
    `user_id` bigint not null,
    `name` varchar(50),
    `period` varchar(50),
    `limit_max` varchar(50),
    `price` decimal(9,2),
    `is_used` int,
    primary key (`id`),
    foreign key(`user_id`) references t_user (`id`)
) engine=innodb default charset=utf8;

#订单表
#用户id,商品费用,配送费,总价,订单状态,用户id外键
create table t_order (
    `id` bigint not null auto_increment,
    `user_id` bigint not null,
    `goods_price` decimal(9,2),
    `delivery_price` decimal(9,2),
    `all_price` decimal(9,2),
    `state` varchar(50),
    foreign key(`user_id`) references t_user (`id`),
    primary key (`id`)
) engine=innodb default charset=utf8;

#订单和商品关系表
#订单id,商品id,商品数量,商品价格,#订单id外键,商品id外键
create table t_order_goods_relation(
   `id` bigint not null auto_increment,
   `order_id` bigint not null,
   `goods_id` bigint not null,
   `goods_number` int,
   `goods_price` decimal(9,2),
   foreign key(`order_id`) references t_order (`id`),
   foreign key(`goods_id`) references t_goods (`id`),
   primary key (`id`)
) engine=innodb default charset=utf8;

