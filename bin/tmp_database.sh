#!/usr/bin/env bash

echo " "
echo "ВАЖНО! Изменяем пароль пользователю postgers на admin"
sudo -u postgres psql -c "ALTER USER postgres WITH PASSWORD 'admin'"

echo " "
echo "Создание тестовой таблицы медикоментов - pg_medicine"
sudo -u postgres psql -c "
    CREATE TABLE pg_medicine (
        id serial PRIMARY KEY,
        name varchar (2000) NOT NULL,
        customer varchar (250) NOT NULL,
        price varchar (50) NOT NULL,
        stock varchar (450),
        available bool,
        create_date timestamp,
        update_date timestamp
	);
"
echo " "
sudo -u postgres psql -c "\d"

sudo -u postgres psql -c "INSERT INTO pg_medicine VALUES (nextval('pg_medicine_id_seq'), 'Корм', 'Всевол', '315', 'Склад 2', true, current_timestamp, current_timestamp); COMMIT;"