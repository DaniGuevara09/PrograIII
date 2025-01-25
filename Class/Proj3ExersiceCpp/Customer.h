//
// Created by dani on 9/5/24.
//

#ifndef CUSTOMER_H
#define CUSTOMER_H
#include <string>
#include <vector>
#include "Sale.h"

class Sale;

class Customer {
public:

    Customer();

    Customer(int id_customer, std::string &name, std::string &address, std::string &phone,
        std::string &email, Sale *sales);

    bool addSale(Sale sale);
    bool updateSale(Sale sale);
    std::string toString();

private:
    int idCustomer;
    std::string name;
    std::string address;
    std::string phone;
    std::string email;
    std::vector<Sale*> sales;
};



#endif //CUSTOMER_H
