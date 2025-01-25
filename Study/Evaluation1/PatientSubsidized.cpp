//
// Created by dani on 9/14/24.
//

#include "PatientSubsidized.h"

PatientSubsidized::PatientSubsidized(long id, const string &name, const string &city, short stratum, bool state)
    : Patient(id, name, city, stratum), state(state) {
}

void PatientSubsidized::set_state(const bool state) {
    this->state = state;
}

bool PatientSubsidized::is_state() const {
    return state;
}

double PatientSubsidized::calculateBond() {
    return 130000;
}
