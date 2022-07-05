DROP TABLE IF EXISTS order_product_tb;
DROP TABLE IF EXISTS order_tb;
DROP TABLE IF EXISTS client_tb;
DROP TABLE IF EXISTS employee_tb;
DROP TABLE IF EXISTS product_tb;
DROP TABLE IF EXISTS product_type_tb;

CREATE TABLE client_tb (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  phone VARCHAR(11) NOT NULL,
  name VARCHAR(18) NOT NULL,
  address VARCHAR(50) NOT NULL
);

CREATE TABLE employee_tb (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  phone VARCHAR(11) NOT NULL,
  name VARCHAR(18) NOT NULL,
  job_title VARCHAR(22) NOT NULL
);

CREATE TABLE product_type_tb (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(18) NOT NULL
);

CREATE TABLE order_tb (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  created_date DATE NOT NULL,
  completed_date DATE NOT NULL,
  employee_id INT,
  client_id INT,
  foreign key (employee_id) references employee_tb(id),
  foreign key (client_id) references client_tb(id)
);

CREATE TABLE product_tb (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(18) NOT NULL,
  price FLOAT NOT NULL,
  type_id INT,
  foreign key (type_id) references product_type_tb(id)
);

CREATE TABLE order_product_tb (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  amount INT NOT NULL,
  order_id INT,
  product_id INT,
  foreign key (order_id) references order_tb(id),
  foreign key (product_id) references product_tb(id)
);