//
// Created by dani on 9/14/24.
//

#ifndef PATIENT_H
#define PATIENT_H
#include <ostream>
#include <string>

#include "EGender.h"
using namespace std;


class Patient {

public:
    Patient();

    Patient(const long id, const string &name, const string &city, const short int stratum);

    long & get_id();

    void set_id(const long id);

    string & get_name();

    void set_name(const string &name);

    string & get_city();

    void set_city(const string &city);

    short int & get_stratum();

    void set_stratum(const short int stratum);

    virtual double calculateBond() = 0;

    friend std::ostream & operator<<(std::ostream &os, const Patient &obj);

    virtual ~Patient();

private:
    EGender egender;

protected:
    long id{};
    string name;
    string city;
    short int stratum{};
};

#endif //PATIENT_H
