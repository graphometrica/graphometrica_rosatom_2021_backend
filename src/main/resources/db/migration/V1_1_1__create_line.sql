create table line
(
    id varchar(20) not null
        constraint line_pk
            primary key,
    name varchar(500) not null,
    is_circle bool,
    "is_mcc" bool,
    color varchar(10) not null,
    payload text
);

INSERT INTO line (id, name, is_circle, is_mcc, color, payload) VALUES
    ('line1', 'Сокольническая линия', null, null, 'e42518', null),
    ('line2', 'Замоскворецкая линия', null, null, '4baf4f', null),
    ('line3', 'Арбатско-Покровская линия', null, null, '0572b9', null),
    ('line4', 'Филёвская линия', null, null, '24bcee', null),
    ('line5', 'Кольцевая линия', true, null, '925233', null),
    ('line6', 'Калужско-Рижская линия', null, null, 'ef7e24', null),
    ('line7', 'Таганско-Краснопресненская линия', null, null, '943f90', null),
    ('line8', 'Калининская линия', null, null, 'FFCD1E', null),
    ('line8A', 'Солнцевская линия', null, null, 'FFCD1E', null),
    ('line9', 'Серпуховско-Тимирязевская линия', null, null, 'adacac', null),
    ('line10', 'Люблинско-Дмитровская линия', null, null, 'BED12E', null),
    ('line11', 'Большая Кольцевая линия', null, null, '89CDCF', null),
    ('line11A', 'Каховская линия', null, null, '89CDCF', null),
    ('line12', 'Бутовская линия', null, null, 'BAC8E8', null),
    ('line13', 'Монорельс', null, null, '0A72B9', null),
    ('line14', 'МЦК', null, true, 'ffcec6', null),
    ('line15', 'Некрасовская линия', null, null, 'd68ab1', null),
    ('lineD1', 'МЦД-1', null, null, '000000', null),
    ('lineD2', 'МЦД-2', null, null, '000000', null);