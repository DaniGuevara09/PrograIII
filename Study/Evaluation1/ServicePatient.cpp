//
// Created by dani on 9/14/24.
//

#include "ServicePatient.h"

#include "PatientContributor.h"
#include "PatientPrepaid.h"
#include "PatientSubsidized.h"

ServicePatient::ServicePatient(){}

Patient * ServicePatient::findByld(long num) {
    for (Patient *patient : patients) {
        if (patient->get_id() == num) {
            return patient;
        }
    }
    return nullptr;
}

bool ServicePatient::addPatient(long id, const string &name, const string &city, short int stratum, EPlain plain) {
    try {
        patients.push_back(new PatientPrepaid(id, name, city, stratum, plain));
        return true;
    } catch (std::exception& e ) {
        return false;
    }
}


bool ServicePatient::addPatient(long id, const string &name, const string &city, short int stratum, char category) {
    try {
        patients.push_back(new PatientContributor(id, name, city, stratum, category));
        return true;
    } catch (std::exception& e) {
        return false;
    }
}

bool ServicePatient::addPatient(long id, const string &name, const string &city, short int stratum, bool state) {
    try {
        patients.push_back(new PatientSubsidized(id, name, city, stratum, state));
        return true;
    } catch (std::exception e) {
        return false;
    }
}

vector<Patient *> ServicePatient::findByName(const string &name) {
    vector<Patient *> patientsList;

    for (Patient *patient : patients) {
        if (patient->get_name() == name) {
            patientsList.push_back(patient);
        }
    }
    return patientsList;
}

vector<Patient *> ServicePatient::get_patients() const {
    return patients;
}

double ServicePatient::calculateBond() {
    for (Patient *patient : patients) {
        if (patient.)
    }
    return 0.0;
}
