drop table if exists messages;
drop table if exists message_details;
drop table if exists templates;
drop table if exists users;
drop table if exists group_users;
drop table if exists subjects_mail;

create table if not exists group_users
(
    id   serial primary key,
    name text not null unique
);

create table if not exists subjects_mail
(
    id      serial primary key,
    subject text not null unique
);

create table if not exists templates
(
    id               serial primary key,
    template         text not null unique,
    subject_email_id int references subjects_mail (id)
);

create table if not exists users
(
    id             serial primary key,
    name           text not null,
    surname        text not null,
    patronymic     text,
    email          text not null unique,
    group_users_id int references group_users (id)
);

create table if not exists message_details
(
    id           serial primary key,
    errors       text,
    message_text text,
    date         timestamp,
    status       text,
    date_status  text
);

create table if not exists messages
(
    id                serial primary key,
    group_users       int references group_users (id),
    template_id       int references templates (id),
    subject_id        int references subjects_mail (id),
    message_detail_id int references message_details (id),
    subject_email_id  int references subjects_mail (id),
    unique_message    text unique not null,
    type_file         text,
    data              jsonb,
    file              bytea
);

insert into group_users (name)
values ('Группа пользователей 1'),
       ('Группа пользователей 2'),
       ('Группа пользователей 3');


insert into users (name, group_users_id, surname, patronymic, email)
values ('Алекс', 1, 'Валекс', 'Валерьевич', 'duxesi_pizu3@yahoo.com'),
       ('Фролов', 1, 'Иван', 'Миронович', 'vesalir_ifa80@hotmail.com'),
       ('Попова', 2, 'Милана', 'Валерьевич', 'legeiffoffeipra-2921@yopmail.com'),
       ('Федоров', 2, 'Лев', 'Дмитриевич', 'taruk-iwiho3@hotmail.com'),
       ('Петрова', 2, 'Александра', 'Всеволодовна', 'fifusi-felo54@yandex.ru'),
       ('Никитин', 3, 'Даниил', 'Константинович', 'cor-idutecu3@inbox.ru'),
       ('Леонова', 3, 'Дарья', 'Ярославовна', 'peb-oyonana80@yandex.ru'),
       ('Матвеев', 3, 'Иван', 'Миронович', 'xoyawa_depe49@aol.com'),
       ('Захарова', 3, 'Ева', 'Михайловна', 'tupu-tajuda31@yahoo.com');

insert into subjects_mail (subject)
values ('Операция со счетом'),
       ('Кредит'),
       ('Реклама');

insert into templates (template, subject_email_id)
values ('<!DOCTYPE html>
<html>
<head>
    <title>Покупки/платежи</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .transaction { margin-bottom: 20px; }
        .transaction strong { color: #007bff; }
    </style>
</head>
<body>
    <h1>Уважаемый(ая) $name,</h1>
    <p>Уведомляем Вас о последней транзакции на Вашем счете $account_number</p>
    <div class="transaction">
        <strong>Покупка/платеж:</strong> на сумму $sum руб., совершенный $date_transactional.
    </div>
    <p>С уважением,<br>$bank_name</p>
</body>
</html>', 1),
       ('<!DOCTYPE html>
<html>
<head>
    <title>Перевод денежных средств</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .transaction { margin-bottom: 20px; }
        .transaction strong { color: #007bff; }
    </style>
</head>
<body>
    <h1>Уважаемый(ая) $name,</h1>
    <p>Уведомляем Вас о переводе денежных средств с Вашего счета $account_number_sender на счет $account_number_recipient</p>
    <div class="transaction">
        <strong>Перевод:</strong> на сумму $sum руб., совершенный $date_transactional.
    </div>
    <p>С уважением,<br>$bank_name</p>
</body>
</html>', 1),
       ('<!DOCTYPE html>
<html>
<head>
    <title>Кредит</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .transaction { margin-bottom: 20px; }
        .transaction strong { color: #007bff; }
    </style>
</head>
<body>
    <h1>Уважаемый(ая) $name,</h1>
    <p>Уведомляем Вас о одобрении кредита $credit_type</p>
    <div class="transaction">
        <strong>Сумма:</strong> $sum руб.
    </div>
    <p>С уважением,<br>$bank_name</p>
</body>
</html>', 2),
       ('<!DOCTYPE html>
<html>
<head>
    <title>Реклама</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .transaction { margin-bottom: 20px; }
        .transaction strong { color: #007bff; }
    </style>
</head>
<body>
    <h1>Уважаемый(ая) $name,</h1>
    <p>Уведомляем Вас о новом инструменте инвестирования $investment_type</p>
    <p>С уважением,<br>$bank_name</p>
</body>
</html>', 3);