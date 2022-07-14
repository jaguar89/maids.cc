# maids.cc

#Simple REST APIs project built with spring boot.

#Run Postman and make some tests: 

#1- GET all clients : http://localhost:8080/api/clients

#2- POST one client : http://localhost:8080/api/clients

          {
          "name" : "userName",
          "lastName":"lastName",
          "mobile":"09651254778"
          }
          
#3- PUT sepcific client : http://localhost:8080/api/clients/1

          {
          "name" : "new userName",
          "lastName":"new lastName",
          "mobile":"0993244406"
          }

#4- GET all sales : http://localhost:8080/api/clients/1/sales

#5- POST one sale : http://localhost:8080/api/clients/1/sales

            {
            "seller":"name of seller",
            "total": 6,
            "quantity" : 2,
            "price" : 150
            }

#6- PUT specific sale : http://localhost:8080/api/clients/2/sales/2

            {
            "seller":"new name",
            "total": 11,
            "quantity" : 5,
            "price" : 120
            }
            
#7- POST one product : http://localhost:8080/api/products

            {
              "name" : "HP",
              "description":"core i3",
              "category" : "Laptop"
            }
            
#8- GET all product :  http://localhost:8080/api/products

#9- PUT specific product : http://localhost:8080/api/products/1

            {
              "name" : "Lenovo",
              "description":"core i5",
              "category" : "Laptop"
            }
