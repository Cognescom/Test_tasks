DROP TABLE IF EXISTS link_table;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

CREATE TABLE books(
	book_id SERIAL,
	name varchar(100),
	genre varchar(50),
	PRIMARY KEY(book_id)
);
CREATE TABLE authors(
	author_id SERIAL,
	name varchar(80),
	surname varchar(80),
	PRIMARY KEY(author_id)
);
CREATE TABLE link_table(
	book_id integer not null,
	author_id integer not null,
	FOREIGN KEY (book_id) REFERENCES books(book_id),
	FOREIGN KEY (author_id) REFERENCES authors(author_id)
);

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO temp;

DELETE FROM authors;
DELETE FROM books;
DELETE FROM link_table;

INSERT INTO authors (author_id, name, surname) VALUES
	( 1, 'Дэн', 'Браун'),
	( 2, 'Стивен', 'Кинг'),
	( 3, 'Гиллиан', 'Флин'),
	( 4, 'Илья', 'Ильф'),
	( 5, 'Евгений', 'Петров'),
	( 6, 'Нил', 'Гейман'),
	( 7, 'Терри', 'Пратчет'),
	( 8, 'Жюль', 'Верн'),
	( 9, 'Джордж-Реймонд', 'Мартин'),
	(10, 'Виктор','Мора');

INSERT INTO books (book_id, name, genre) VALUES
	(1, 'Код да Винчи','Детектив'),
	(2, 'Ангелы и Демоны','Детектив'),
	(3, 'Зеленая миля','Магический реализм'),
	(4, 'Исчезнувшая','Триллер'),
	(5, 'Двенадцать стульев','Сатира'),
	(6, 'Золотой теленок','Сатира'),
	(7, 'Добрые предзнаменования','Фэнтези'),
	(8, 'Путешествие к центру Земли','Научная фантастика'),
	(9, 'Вокруг света за 80 дней','Приключения'),
	(10, 'Таинственный остров','Приключения'),
	(11, 'Игра престолов','Эпическое фэнтези'),
	(12, 'Битва королей','Эпическое фэнтези');

INSERT INTO link_table (book_id, author_id) VALUES
	(1,1),
	(2,1),
	(3,2),
	(4,3),
	(5,4),
	(5,5),
	(6,4),
	(6,5),
	(7,6),
	(7,7),
	(8,8),
	(9,8),
	(9,10),
	(10,8),
	(11,9),
	(12,9);