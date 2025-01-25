//
// Created by dani on 9/16/24.
//

#ifndef PATIENT_H
#define PATIENT_H
#include <ostream>
#include <string>
#include "EGender.h"


using namespace std;


class Patient {

public:
    Patient(long id, const string &name, const string &city, short int stratum);

    long get_id() const;

    void set_id(const long id);

    string get_name() const;

    void set_name(const string &name);

    string get_city() const;

    void set_city(const string &city);

    short int get_stratum() const;

    void set_stratum(const short int stratum);

    virtual double calculateBond();

    string print() const;

private:

    EGender eGender;

protected:
    long id{};
    string name;
    string city;
    short int stratum{};
};



#endif //PATIENT_H
