//
// Created by dani on 9/16/24.
//

#ifndef SERVICEPATIENT_H
#define SERVICEPATIENT_H
#include <ostream>
#include <vector>
#include "EPlain.h"
#include "Patient.h"


class ServicePatient {
public:
    ServicePatient();

    Patient* findById(long id);

    vector<Patient*> findByName(string name);


    bool addPatient(long id, const string &name, const string &city, short int stratum, EPlain plain);

    bool addPatient(long id, const string &name, const string &city, short int stratum, char category);

    bool addPatient(long id, const string &name, const string &city, short int stratum, bool state);

    vector<Patient*> getPatients();

    string print() const;

private:
    vector<Patient*> patients;
};



#endif //SERVICEPATIENT_H
