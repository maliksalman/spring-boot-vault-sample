#!/bin/bash

echo
echo "Adding secret keys ..."

SECRET_NAME='spring-boot-vault-sample'
curl -X POST \
  -H "X-Vault-Token: my-root" \
  -H "Content-Type: application/json" \
  -d '{ "data": { "key1":"value1", "key2":"value2" }}' \
  http://localhost:8200/v1/secret/data/${SECRET_NAME}

echo
echo "Secret keys in vault ..."
curl -X GET \
  -H "X-Vault-Token: my-root" \
  http://localhost:8200/v1/secret/data/${SECRET_NAME} -s | jq .data.data