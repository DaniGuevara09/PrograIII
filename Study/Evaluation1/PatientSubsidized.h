//
// Created by dani on 9/14/24.
//

#ifndef PATIENTSUBSIDIZED_H
#define PATIENTSUBSIDIZED_H
#include <string>
#include "Patient.h"

class PatientSubsidized : public Patient {
public:
    PatientSubsidized(long id, const string &name, const string &city, short stratum, bool state);
    void set_state(const bool state);
    bool is_state() const;
    double calculateBond() override;

private:
    bool state;
};

#endif //PATIENTSUBSIDIZED_H
