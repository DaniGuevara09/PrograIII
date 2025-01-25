//
// Created by dani on 9/5/24.
//

#ifndef MOTO_H
#define MOTO_H
#include <string>


class Moto {
public:
    Moto();

    Moto(int id_moto, std::string &brand, std::string &model, std::string &color, int year);
    std::string toString();
private:
    int idMoto;
    std::string brand;
    std::string model;
    std::string color;
    int year;
};

#endif //MOTO_H
