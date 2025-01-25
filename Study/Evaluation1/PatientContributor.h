//
// Created by dani on 9/14/24.
//

#ifndef PATIENTCONTRIBUTOR_H
#define PATIENTCONTRIBUTOR_H
#include "Patient.h"


class PatientContributor : public Patient{

public:
    PatientContributor(long id, const string &name, const string &city, short stratum, char category);

    char get_category() const;

    void set_category(const char category);

    double calculateBond() override;

private:
    char category;
};



#endif //PATIENTCONTRIBUTOR_H
