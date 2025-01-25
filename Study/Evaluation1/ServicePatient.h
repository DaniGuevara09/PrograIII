//
// Created by dani on 9/14/24.
//

#ifndef SERVICEPATIENT_H
#define SERVICEPATIENT_H
#include <vector>
#include "EPlain.h"
#include "Patient.h"
using namespace std;


class ServicePatient : public Patient{
public:
    ServicePatient();

    Patient* findByld(long id);

    bool addPatient(long id, const string &name, const string &city, short int stratum, EPlain plain);

    bool addPatient(long id, const string &name, const string &city, short int stratum, char category);

    bool addPatient(long id, const string &name, const string &city, short int stratum, bool state);

    vector<Patient*> findByName(const string &name);

    vector<Patient *> get_patients() const;

    double calculateBond() override;

private:
    vector<Patient*> patients;
};



#endif //SERVICEPATIENT_H
