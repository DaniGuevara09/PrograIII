//
// Created by dani on 9/16/24.
//

#include "PatientPrepaid.h"

PatientPrepaid::PatientPrepaid(long id, const string &name, const string &city, short int stratum, EPlain plain): Patient(id, name, city, stratum),
    plain(plain) {
}

EPlain PatientPrepaid::get_plain() const {
    return plain;
}

void PatientPrepaid::set_plain(const EPlain plain) {
    this->plain = plain;
}

double PatientPrepaid::calculateBond() {
    return 1300000 * 0.2;
}
