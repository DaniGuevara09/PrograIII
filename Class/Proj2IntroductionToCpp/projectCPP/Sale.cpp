//
// Created by Jairo Riaño on 30/08/24.
//

#include <iostream>
#include "Sale.h"

Sale::Sale() {}

Sale::Sale(const std::string &item, double cost, short amount) : item(item), cost(cost), amount(amount) {}

const std::string &Sale::getItem() const {
    return item;
}

void Sale::setItem(const std::string &item) {
    Sale::item = item;
}

double Sale::getCost() const {
    return cost;
}

void Sale::setCost(double cost) {
    Sale::cost = cost;
}

short Sale::getAmount() const {
    return amount;
}

void Sale::setAmount(short amount) {
    Sale::amount = amount;
}

std::ostream &operator<<(std::ostream &os, const Sale &sale) {
    os << "item: " << sale.item << " cost: " << sale.cost << " amount: " << sale.amount;
    return os;
}

double Sale::calcDiscount() {
    return 6.0;
}

Sale::~Sale() {
    std::cout<<"Hasta la Vista Baby"<<std::endl;
}
