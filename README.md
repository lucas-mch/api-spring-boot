# api-spring-boot
EC2 deploy URL -> http://ec2-3-144-85-174.us-east-2.compute.amazonaws.com/

clientes endpoint http://ec2-3-144-85-174.us-east-2.compute.amazonaws.com/clientes/1


#

{
    "cliente": { "id": 1 }, "enderecoDeEntrega": { "id" : 1 },
    "pagamento": {
        "numeroDeParcelas": 10,
        "@type": "pagamentoComCartao"
    },
    "itens": [
        {"quantidade": 2 , "produto":  { "id": 3 } },
        {"quantidade": 1 , "produto":  { "id": 1 } }
    ]
}
