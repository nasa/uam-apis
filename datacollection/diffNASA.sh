# https://github.com/astm-utm/Protocol/compare/implementation_2020q2..issmith1:implementation_2020q2

curl -o local-astm-utm.yaml -LJO   https://raw.githubusercontent.com/astm-utm/Protocol/implementation_2020q2/utm.yaml
curl -o local-NASA-utm.yaml -LJO   https://raw.githubusercontent.com/nasa/uam-apis/master/datacollection/nasa-astm-utm.yaml

# linux: diff astm-utm.yaml NASA-utm.yaml
# os/x, filemerge astm-utm.yaml NASA-utm.yaml

vimdiff local-astm-utm.yaml local-NASA-utm.yaml
