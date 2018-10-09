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
	( 1, '���', '�����'),
	( 2, '������', '����'),
	( 3, '�������', '����'),
	( 4, '����', '����'),
	( 5, '�������', '������'),
	( 6, '���', '������'),
	( 7, '�����', '�������'),
	( 8, '����', '����'),
	( 9, '������-�������', '������'),
	(10, '������','����');

INSERT INTO books (book_id, name, genre) VALUES
	(1, '��� �� �����','��������'),
	(2, '������ � ������','��������'),
	(3, '������� ����','���������� �������'),
	(4, '�����������','�������'),
	(5, '���������� �������','������'),
	(6, '������� �������','������'),
	(7, '������ ����������������','�������'),
	(8, '����������� � ������ �����','������� ����������'),
	(9, '������ ����� �� 80 ����','�����������'),
	(10, '������������ ������','�����������'),
	(11, '���� ���������','��������� �������'),
	(12, '����� �������','��������� �������');

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