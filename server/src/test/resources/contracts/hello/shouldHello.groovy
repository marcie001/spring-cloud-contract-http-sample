package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        urlPath('/hello') {
            queryParameters {
                parameter 'name': value(consumer(regex(nonEmpty())), producer('Joe'))
            }
        }
    }
    response {
        status 200
        body([
               "message": "Hello, ${fromRequest().query('name')}!!"
        ])
        headers {
            contentType('application/json')
        }
    }
}
