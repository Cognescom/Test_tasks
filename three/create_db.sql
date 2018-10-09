DROP DATABASE IF EXISTS db_books;
DROP ROLE IF EXISTS temp;

CREATE DATABASE db_books
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Russian_Russia.1251'
       LC_CTYPE = 'Russian_Russia.1251'
       CONNECTION LIMIT = -1;

CREATE USER temp WITH password 'temp';
