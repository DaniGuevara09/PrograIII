//
// Created by dani on 9/16/24.
//

#include "Patient.h"

Patient::Patient(long id, const string &name, const string &city, short int stratum): id(id),
    name(name),
    city(city),
    stratum(stratum) {
}

long Patient::get_id() const {
    return id;
}

void Patient::set_id(const long id) {
    this->id = id;
}

string Patient::get_name() const {
    return name;
}

void Patient::set_name(const string &name) {
    this->name = name;
}

string Patient::get_city() const {
    return city;
}

void Patient::set_city(const string &city) {
    this->city = city;
}

short int Patient::get_stratum() const {
    return stratum;
}

void Patient::set_stratum(const short int stratum) {
    this->stratum = stratum;
}

double Patient::calculateBond() {
    return 0.0;
}

string Patient::print() const {
    return "ID: " + std::to_string(id)  + ", Name: " + name + ", City: " + city + ", Stratum: " + std::to_string(stratum);
}

