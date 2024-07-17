drop table if exists messages;
drop table if exists group_users;
drop table if exists message_details;
drop table if exists templates;

create table if not exists group_users
(
    id     serial primary key,
    emails varchar[]
);

create table if not exists templates
(
    id       serial primary key,
    template text not null,
    subject  text not null
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
    group_users_id    int references group_users (id),
    template_id       int references templates (id),
    message_detail_id int references message_details (id),
    unique_message    text unique not null,
    type_file         text,
    data              jsonb,
    file              bytea
);

insert into group_users (emails)
values ('{"duxesi_pizu3@yahoo.com", "vesalir_ifa80@hotmail.com", "legeiffoffeipra-2921@yopmail.com"}'),
       ('{"taruk-iwiho3@hotmail.com", "taruk-iwiho3@hotmail.com", "fifusi-felo54@yandex.ru"}'),
       ('{"cor-idutecu3@inbox.ru", "eb-oyonana80@yandex.ru", "xoyawa_depe49@aol.com", "upu-tajuda31@yahoo.com"}');

insert into templates (template, subject)
values ('<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Добро пожаловать!</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            padding: 20px;
            background-color: #f4f4f4;
            border-radius: 10px;
            width: 80%;
            margin: auto;
            text-align: center;
        }
        .button {
            background-color: #4CAF50;
            color: white;
            padding: 15px 25px;
            text-decoration: none;
            display: inline-block;
            border-radius: 5px;
            margin-top: 20px;
        }
    </style>
</head>
<body>
        <div class="container">
        <h1>Добро пожаловать в наше сообщество!</h1>
        <p>Сегодня $day<p>
        <p>Спасибо за регистрацию! Мы рады, что вы с нами.</p>
    </div>
</body>
</html>', 'Регистрация'),
       ('<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Спасибо за вашу активность!</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            padding: 20px;
            background-color: #e7f3fe;
            border-radius: 10px;
            width: 80%;
            margin: auto;
            text-align: center;
        }
        .button {
            background-color: #008CBA;
            color: white;
            padding: 15px 25px;
            text-decoration: none;
            display: inline-block;
            border-radius: 5px;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Спасибо за вашу активность!</h1>
        <p>Мы ценим ваше участие и вклад в наше $name_society.</p>
        <p>Продолжайте использовать наши сервисы и получать новые достижения.</p>
    </div>
</body>
</html>', 'Активность пользователя'),
       ('<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Особая благодарность</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            padding: 20px;
            background-color: #fff0e6;
            border-radius: 10px;
            width: 80%;
            margin: auto;
            text-align: center;
        }
        .button {
            background-color: #f44336;
            color: white;
            padding: 15px 25px;
            text-decoration: none;
            display: inline-block;
            border-radius: 5px;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Особая благодарность нашим VIP пользователям!</h1>
        <p>Мы очень ценим ваше постоянное участие и поддержку.</p>
        <p>Для вас доступны специальные предложения и бонусы: $bonus_name.</p>
    </div>
</body>
</html>', 'VIP');