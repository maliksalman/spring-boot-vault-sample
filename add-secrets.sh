#!/bin/bash

function createKeys {

  SECRET_NAME=$1
  VALUE_PREFIX=$2
  SERVER=$3

  echo
  echo "Adding secrets to ${SECRET_NAME} ..."
  curl -s -X POST \
    -H "X-Vault-Token: my-root" \
    -H "Content-Type: application/json" \
    -d "{ \"data\": { \"my.key1\":\"${VALUE_PREFIX}-value-1\", \"my.key2\":\"${VALUE_PREFIX}-value-2\" }}" \
    http://${SERVER}:8200/v1/secret/data/${SECRET_NAME} > /dev/null
  curl -X GET \
    -H "X-Vault-Token: my-root" \
    http://${SERVER}:8200/v1/secret/data/${SECRET_NAME} -s | jq .data.data
}

SERVER=${1:-localhost}

createKeys spring-boot-vault-sample default ${SERVER}
createKeys spring-boot-vault-sample/dev dev ${SERVER}
createKeys spring-boot-vault-sample/prod prod ${SERVER}
