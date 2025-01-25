//
// Created by dani on 9/14/24.
//

#ifndef PATIENTPREPAID_H
#define PATIENTPREPAID_H
#include "EPlain.h"
#include "Patient.h"

class PatientPrepaid : public Patient{
public:
    PatientPrepaid(long id, const string &name, const string &city, short stratum, EPlain e_plain);

    EPlain get_e_plain() const;

    void set_e_plain(const EPlain e_plain);

    double calculateBond() override;

private:
    EPlain ePlain;
};

#endif //PATIENTPREPAID_H
