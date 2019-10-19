# UAM USS API

## Operational States

![alt text](diagrams/tcl4-statemachine.png "Operational States")

## Diff between this and UTM 

curl --silent  -o commons.yml  https://raw.githubusercontent.com/nasa/utm-apis/v4-draft/utm-domains/utm-domain-commons.yaml && grep  -n MUST commons.yml


## Rendering OpenAPI

Swagger offers several open access tools for spec browsing, for example  "http://petstore.swagger.io/?url=RAW" where RAW is the raw github file, eg:

http://petstore.swagger.io/?url=https://raw.githubusercontent.com/nasa/utm-apis/v4-draft/uss-api/swagger.yaml

Swagger rendering is especially useful to descend into the models from the API. For example to view Operation.submit_time,
render the USS-API from github v4-draft branch, descend GET Operation, then use the "Example Value | Model"
section of the Operation model to descend into "Model".
