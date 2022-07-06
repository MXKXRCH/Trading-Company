--liquibase formatted sql
--changeset mak:inset-data-01

insert into product_type values
(1, 'Food'),
(2, 'Clothes'),
(3, 'Electronics'),
(4, 'Hobie');

insert into product values
(1, 'Porridge', 50, 1),
(2, 'Hat', 500, 2),
(3, 'PC', 15000, 3),
(4, 'Guitar', 4000, 4),
(5, 'Cheese', 150, 1),
(6, 'Potato', 20, 1),
(7, 'Shoes', 4000, 2),
(8, 'Headphones', 1000, 3);

insert into client values
(1, '89423426', 'Igor', '2251mm'),
(2, '89478966', 'Lisa', '2012xc'),
(3, '89326661', 'Oleg', '2382po'),
(4, '89021563', 'Anna', '2914ly');

insert into employee values
(1, '52-82-123', 'Alex', 'master'),
(2, '41-56-123', 'Miha', 'student');

insert into ordering values
(1, DATE '2021-05-10', DATE '2021-06-01', 2, 2),
(2, DATE '2021-05-08', DATE '2021-05-31', 1, 2),
(3, DATE '2021-06-15', DATE '2021-07-08', 2, 3),
(4, DATE '2021-09-05', DATE '2022-09-20', 1, 4);

insert into order_product values
(1, 1, 1, 4),
(2, 1, 1, 2),
(3, 1, 2, 3),
(4, 5, 3, 1),
(5, 1, 3, 8),
(6, 2, 4, 5);