//
// Created by dani on 9/16/24.
//

#ifndef PATIENTSUBSIDIZED_H
#define PATIENTSUBSIDIZED_H
#include <ostream>

#include "Patient.h"


class PatientSubsidized : public Patient{

public:
    PatientSubsidized(long id, const string &name, const string &city, short int stratum, bool state);

    void set_state(bool state);

    bool isState();

    double calculateBond() override;

private:

    bool state;
};



#endif //PATIENTSUBSIDIZED_H
