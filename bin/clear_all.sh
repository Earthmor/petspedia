#!/usr/bin/env bash
echo " "

echo "Очищаем базу данных (Удаление табилицы pg_medicine)"
sudo -u postgres psql -c "DROP TABLE pg_medicine"

echo " "

