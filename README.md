## Merchant Service

A Service that provide and manages all of the merchant, including add new merchant, fetch all or one of registered merchant, and receive payment from wallet user.

## How to run service
All the service related is run by command of `docker-compose up` that provided by [Wallet Service](https://github.com/KrisRaya/wallet-service).
Once the service is up, go to [Merchant Service Swagger UI page](http://localhost:8080/merchant/swagger-ui.html) to hit the provided API.

### Note on the API
* `/payMerchant` API is an API to add merchant balance when there is a transaction from wallet to merchant, this API consume by Transaction Service that directly doing the payment function