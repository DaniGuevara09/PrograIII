//
// Created by Jairo Riaño on 30/08/24.
//

#ifndef PROJECTCPP_SALE_H
#define PROJECTCPP_SALE_H

#include <string>
#include <ostream>


class Sale {
public:
    Sale();

    Sale(const std::string &item, double cost, short amount);

    const std::string &getItem() const;

    void setItem(const std::string &item);

    double getCost() const;

    void setCost(double cost);

    short getAmount() const;

    void setAmount(short amount);

    friend std::ostream &operator<<(std::ostream &os, const Sale &sale);

    virtual ~Sale();

private:
    std::string item;

    double cost;

    short int amount;

    double calcDiscount();
};


#endif //PROJECTCPP_SALE_H
