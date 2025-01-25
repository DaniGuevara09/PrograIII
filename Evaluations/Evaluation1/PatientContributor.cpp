//
// Created by dani on 9/16/24.
//

#include "PatientContributor.h"

PatientContributor::PatientContributor(long id, const string &name, const string &city, short stratum, char category) :
    Patient(id, name, city, stratum), category(category){
}

char PatientContributor::get_category() const {
    return category;
}

void PatientContributor::set_category(const char category) {
    this->category = category;
}

double PatientContributor::calculateBond() {
    switch (toupper(category)) {
        case 'A':
            return 4500;
        case 'B':
            return 12000;
        case 'C':
            return 23500;
        case 'D':
            return 43000;
        default:
            return 0;
    }
}
