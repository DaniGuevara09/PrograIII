//
// Created by dani on 9/16/24.
//

#ifndef PATIENTCONTRIBUTOR_H
#define PATIENTCONTRIBUTOR_H
#include <ostream>

#include "Patient.h"


class PatientContributor : public Patient{
public:
    PatientContributor(long id, const string &name, const string &city, short stratum, char category);

    char get_category() const;

    void set_category(const char category);

    double calculateBond() override;

    string print() const;

private:
    char category;
};



#endif //PATIENTCONTRIBUTOR_H
