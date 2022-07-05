DROP TABLE IF EXISTS order_product;
DROP TABLE IF EXISTS ordering;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS product_type;

CREATE TABLE client (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  phone VARCHAR(11) NOT NULL,
  name VARCHAR(18) NOT NULL,
  address VARCHAR(50) NOT NULL
);

CREATE TABLE employee (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  phone VARCHAR(11) NOT NULL,
  name VARCHAR(18) NOT NULL,
  job_title VARCHAR(22) NOT NULL
);

CREATE TABLE product_type (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(18) NOT NULL
);

CREATE TABLE ordering (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  created_date DATE NOT NULL,
  completed_date DATE NOT NULL,
  employee_id BIGINT,
  client_id BIGINT,
  foreign key (employee_id) references employee(id),
  foreign key (client_id) references client(id)
);

CREATE TABLE product (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(18) NOT NULL,
  price DECIMAL NOT NULL,
  type_id BIGINT,
  foreign key (type_id) references product_type(id)
);

CREATE TABLE order_product (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  amount BIGINT NOT NULL,
  order_id BIGINT,
  product_id BIGINT,
  foreign key (order_id) references ordering(id),
  foreign key (product_id) references product(id)
);