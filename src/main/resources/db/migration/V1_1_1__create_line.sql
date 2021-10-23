create table line
(
    id varchar(20) not null
        constraint line_pk
            primary key,
    name varchar(500) not null,
    is_circle bool,
    "is_mcc" bool,
    color varchar(10) not null,
    payload jsonb
);

INSERT INTO line (id, name, is_circle, is_mcc, color, payload) VALUES ('line1', 'Сокольническая линия', null, null, 'e42518', null);
INSERT INTO line (id, name, is_circle, is_mcc, color, payload) VALUES ('line2', 'Замоскворецкая линия', null, null, '4baf4f', null);
INSERT INTO line (id, name, is_circle, is_mcc, color, payload) VALUES ('line3', 'Арбатско-Покровская линия', null, null, '0572b9', null);
INSERT INTO line (id, name, is_circle, is_mcc, color, payload) VALUES ('line4', 'Филёвская линия', null, null, '24bcee', null);
INSERT INTO line (id, name, is_circle, is_mcc, color, payload) VALUES ('line5', 'Кольцевая линия', true, null, '925233', null);
INSERT INTO line (id, name, is_circle, is_mcc, color, payload) VALUES ('line6', 'Калужско-Рижская линия', null, null, 'ef7e24', null);
INSERT INTO line (id, name, is_circle, is_mcc, color, payload) VALUES ('line7', 'Таганско-Краснопресненская линия', null, null, '943f90', null);
INSERT INTO line (id, name, is_circle, is_mcc, color, payload) VALUES ('line8', 'Калининская линия', null, null, 'FFCD1E', null);
INSERT INTO line (id, name, is_circle, is_mcc, color, payload) VALUES ('line8A', 'Солнцевская линия', null, null, 'FFCD1E', null);
INSERT INTO line (id, name, is_circle, is_mcc, color, payload) VALUES ('line9', 'Серпуховско-Тимирязевская линия', null, null, 'adacac', null);
INSERT INTO line (id, name, is_circle, is_mcc, color, payload) VALUES ('line10', 'Люблинско-Дмитровская линия', null, null, 'BED12E', null);
INSERT INTO line (id, name, is_circle, is_mcc, color, payload) VALUES ('line11', 'Большая Кольцевая линия', null, null, '89CDCF', null);
INSERT INTO line (id, name, is_circle, is_mcc, color, payload) VALUES ('line11A', 'Каховская линия', null, null, '89CDCF', null);
INSERT INTO line (id, name, is_circle, is_mcc, color, payload) VALUES ('line12', 'Бутовская линия', null, null, 'BAC8E8', null);
INSERT INTO line (id, name, is_circle, is_mcc, color, payload) VALUES ('line13', 'Монорельс', null, null, '0A72B9', null);
INSERT INTO line (id, name, is_circle, is_mcc, color, payload) VALUES ('line14', 'МЦК', null, true, 'ffcec6', null);
INSERT INTO line (id, name, is_circle, is_mcc, color, payload) VALUES ('line15', 'Некрасовская линия', null, null, 'd68ab1', null);
INSERT INTO line (id, name, is_circle, is_mcc, color, payload) VALUES ('lineD1', 'МЦД-1', null, null, '000000', null);
INSERT INTO line (id, name, is_circle, is_mcc, color, payload) VALUES ('lineD2', 'МЦД-2', null, null, '000000', null);