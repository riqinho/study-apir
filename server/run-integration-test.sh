#!/usr/bin/env bash
set -e 

apt update
apt install -y jq

HTTP_STATUS=$(
  curl -X 'POST' \
  'http://localhost:9000/api/v5/produtos' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -o product_create.json \
  -w "%{http_code}" \
  -d '{
  "nome": "melancia"
}'
)

echo "Status HTTP: $HTTP_STATUS"

if [ "$HTTP_STATUS" -ne 201 ]; then
  echo "Erro ao cadastrar produto"
  exit 0
fi

PRODUTO_ID=$(jq '.id' product_create.json)

echo "ID do produto criado: $PRODUTO_ID"

HTTP_STATUS=$(curl -X 'GET' 'http://localhost:9000/api/v5/produtos' -o product_list.json -w "%{http_code}" -H 'accept: */*')

echo "Status HTTP: $HTTP_STATUS"

if [ "$HTTP_STATUS" -ne 200 ]; then
  echo "Erro ao acessar API produtos"
  exit 0
fi
