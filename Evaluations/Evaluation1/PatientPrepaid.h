//
// Created by dani on 9/16/24.
//

#ifndef PATIENTPREPAID_H
#define PATIENTPREPAID_H
#include <ostream>

#include "EPlain.h"
#include "Patient.h"


class PatientPrepaid : public Patient{
public:
    PatientPrepaid(long id, const string &name, const string &city, short int stratum, EPlain plain);

    EPlain get_plain() const;

    void set_plain(const EPlain plain);

    double calculateBond() override;

    friend std::ostream & operator<<(std::ostream &os, const PatientPrepaid &obj);

private:
    EPlain plain;
};



#endif //PATIENTPREPAID_H
