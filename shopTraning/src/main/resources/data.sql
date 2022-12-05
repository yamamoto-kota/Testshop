CREATE TABLE TEST(ID INT PRIMARY KEY,
   NAME VARCHAR(255));
INSERT INTO TEST VALUES(1, 'Hello');
INSERT INTO TEST VALUES(2, 'World');

CREATE TABLE UserForm (
    ID number PRIMARY KEY AUTO_INCREMENT,
    USERNAME VARCHAR(255) NOT NULL,
    ADDRESS VARCHAR(255),
    TOTALPRICE number(255),
    PURCHASEDATE varchar(255)
);

CREATE TABLE AllGoods(
    ID number(255) NOT NULL PRIMARY KEY,
    NAME VARCHAR(255),
    GENRE varchar(255),
    PRICE number(255),
    IMG varchar(255),
    PURCHASEFLAG number(255),
    QUANTITY number(255)
);

CREATE TABLE CARTGOODS(
    ID number(255) NOT NULL PRIMARY KEY,
    NAME VARCHAR(255),
    GENRE varchar(255),
    PRICE number(255),
    IMG varchar(255),
    PURCHASEFLAG number(255),
    QUANTITY number(255)
);


INSERT INTO AllGoods (ID, NAME, genre, price, quantity) VALUES (1, 'bread', 'eat', 100, 0);
INSERT INTO AllGoods (ID, NAME, genre, price, quantity) VALUES (2, 'apple', 'eat', 200, 0);
INSERT INTO AllGoods (ID, NAME, genre, price, quantity) VALUES (3, 'bicycle', 'other', 300, 0);
INSERT INTO AllGoods (ID, NAME, genre, price, quantity) VALUES (4, 'PC', 'other', 1000, 1);

INSERT INTO CARTGOODS (ID, NAME, genre, price, quantity) VALUES (1, 'bread', 'eat', 100, 1);
INSERT INTO CARTGOODS (ID, NAME, genre, price, quantity) VALUES (2, 'apple', 'eat', 200, 2);
INSERT INTO CARTGOODS (ID, NAME, genre, price, quantity) VALUES (4, 'PC', 'other', 1000, 1);
