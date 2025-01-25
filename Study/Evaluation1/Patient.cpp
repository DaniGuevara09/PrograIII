//
// Created by dani on 9/14/24.
//

#include "Patient.h"

Patient::Patient() {
}

Patient::Patient(const long id, const string &name, const string &city, const short int stratum)
    : id(id), name(name), city(city), stratum(stratum) {
}

long & Patient::get_id() {
    return id;
}

void Patient::set_id(const long id) {
    this->id = id;
}

string & Patient::get_name() {
    return name;
}

void Patient::set_name(const string &name) {
    this->name = name;
}

string & Patient::get_city() {
    return city;
}

void Patient::set_city(const string &city) {
    this->city = city;
}

short int & Patient::get_stratum() {
    return stratum;
}

void Patient::set_stratum(const short int stratum) {
    this->stratum = stratum;
}

Patient::~Patient() {
}

std::ostream & operator<<(std::ostream &os, const Patient &obj) {
    return os
           << "id: \t" << obj.id
           << " \t\tname: \t" << obj.name
           << " \t\tcity: \t" << obj.city
           << " \t\tstratum: \t" << obj.stratum;
}
