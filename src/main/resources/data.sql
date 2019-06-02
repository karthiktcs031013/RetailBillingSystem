DROP TABLE IF EXISTS customer_category;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS affiliate;

CREATE TABLE customer_category (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    type VARCHAR(3) NOT NULL,
    description VARCHAR(50) NOT NULL
);

CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    joining_date VARCHAR(12) NOT NULL,
    designation VARCHAR(30)
);

CREATE TABLE affiliate (
    id INT AUTO_INCREMENT PRIMARY KEY,
    partner_name VARCHAR(40) NOT NULL,
    partner_identification VARCHAR(30) NOT NULL
);

CREATE TABLE customer (
  customer_id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL,
  mobile_no VARCHAR(12) NOT NULL,
  category VARCHAR(3) NOT NULL,
  employee_id INT,
  affiliate_id INT,
  subscribe_date DATE DEFAULT NULL
);



INSERT INTO customer_category (type,description) VALUES
    ('E','Employee of the Shop');
INSERT INTO customer_category (type,description) VALUES
    ('A','Affiliate to this Store');
INSERT INTO customer_category (type,description) VALUES
    ('NA','Not Applicable');

INSERT INTO employee (joining_date,designation) VALUES
    ('2013-10-03','AST');
INSERT INTO employee (joining_date,designation) VALUES
    ('2004-01-01','AST');

INSERT INTO affiliate (partner_name,partner_identification) VALUES
    ('ABC Pvt Ltd','Employee ID');
INSERT INTO affiliate (partner_name,partner_identification) VALUES
    ('TCS','Employee ID');


INSERT INTO customer (name, email, mobile_no,category,employee_id,subscribe_date) VALUES
  ('Aliko', 'abc@gmail.com', '+832423434','E',1,CURRENT_TIMESTAMP());
INSERT INTO customer (name, email, mobile_no,category,affiliate_id,subscribe_date) VALUES
  ('Bala', 'def@gmail.com', '+832423434','A',1,CURRENT_TIMESTAMP());
INSERT INTO customer (name, email, mobile_no,category,subscribe_date) VALUES
  ('Rohit', 'erf@gmail.com', '+832423434','NA',CURRENT_TIMESTAMP());
INSERT INTO customer (name, email, mobile_no,category,subscribe_date) VALUES
  ('Ram', 'ram@gmail.com', '+832423434','NA',TO_DATE('2015-12-15','YYYY-MM-DD'));