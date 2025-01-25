//
// Created by dani on 9/14/24.
//

#include "PatientPrepaid.h"


PatientPrepaid::PatientPrepaid(long id, const string &name, const string &city, short stratum, EPlain e_plain)
    : Patient(id, name, city, stratum), ePlain(e_plain) {
}

EPlain PatientPrepaid::get_e_plain() const {
    return ePlain;
}

void PatientPrepaid::set_e_plain(const EPlain e_plain) {
    ePlain = e_plain;
}

double PatientPrepaid::calculateBond() {
    return 260000; // 1300000 * 0.2
}
