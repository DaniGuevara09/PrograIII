//
// Created by dani on 9/5/24.
//

#ifndef SALE_H
#define SALE_H
#include <string>
#include "Customer.h"
#include "Moto.h"

class Moto;
class Customer;

class Sale {
public:
    Sale();

    Sale(int id, std::string date, Customer customer, Moto &moto);

    bool newSale(Customer customer, Moto moto);
    bool updateSale(int id, std::string date, Customer &customer, Moto &moto);
    bool generateReceipt();

private:
    int id;
    std::string date;
    Customer customer;
    Moto moto;
};



#endif //SALE_H
