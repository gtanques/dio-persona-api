## API Cadastro e Gerenciamento de Pessoas
<img src="https://img.shields.io/badge/JAVA-Spring%20Boot-green"/><img src="https://img.shields.io/badge/Lombok-red"/><img src="https://img.shields.io/badge/H2-blue"/>

### - Testes 
#### POST 
    http://localhost:8080/api/v1/people/

    {
        "firstName": "Anakin",
        "lastName": "Skywalker",
        "cpf": "331.654.987-45",
        "birthDate": "2060-08-08",
        "phones": [
            {
                "type": "MOBILE",
                "number": "(12)3456-7891"
            }
	    ]
    }
#### GET
    http://localhost:8080/api/v1/people/{id} 

#### PUT
    http://localhost:8080/api/v1/people/{id}
    {
        "firstName": "Luke",
        "lastName": "Skywalker",
        "cpf": "123.456.789-15",
        "birthDate": "2080-09-23",
        "phones": [
            {
                "type": "MOBILE",
                "number": "(12)3456-7891"
            }
        ]
    }

#### DELETE
    http://localhost:8080/api/v1/people/{id}



### - Referência
[@rpeleias - Digital Innovation One](https://github.com/rpeleias/personapi_digital_innovation_one)