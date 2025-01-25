//
// Created by dani on 9/16/24.
//

#include "PatientSubsidized.h"

PatientSubsidized::PatientSubsidized(long id, const string &name, const string &city, short int stratum, bool state): Patient(id, name, city, stratum),
    state(state) {
}

void PatientSubsidized::set_state(bool state) {
    this->state = state;
}

bool PatientSubsidized::isState() {
    return state;
}

double PatientSubsidized::calculateBond() {
    return 1300000 * 0.01;
}
