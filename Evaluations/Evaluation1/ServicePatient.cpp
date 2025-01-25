//
// Created by dani on 9/16/24.
//

#include "ServicePatient.h"

#include "PatientContributor.h"
#include "PatientPrepaid.h"
#include "PatientSubsidized.h"

ServicePatient::ServicePatient() {
}

Patient * ServicePatient::findById(long id) {
    for (Patient *patient : this->patients) {
        if (patient->get_id() == id) {
            return patient;
        }
    }
    return nullptr;
}

vector<Patient *> ServicePatient::findByName(string name){

    vector <Patient*> list;

    for (Patient *patient : this->patients) {
        if (patient->get_name() == name) {
            list.push_back(patient);
        }
    }
    return list;
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
        if (category == 'A' || category == 'a' || category == 'B' || category == 'b' || category == 'C' || category == 'c'
            || category == 'D' || category == 'd') {

            patients.push_back(new PatientContributor(id, name, city, stratum, category));
            return true;
        }
        return false;
    } catch (std::exception& e ) {
        return false;
    }
}

bool ServicePatient::addPatient(long id, const string &name, const string &city, short int stratum, bool state) {
    try {
        patients.push_back(new PatientSubsidized(id, name, city, stratum, state));
        return true;
    } catch (std::exception& e ) {
        return false;
    }
}

vector<Patient *> ServicePatient::getPatients() {
    return patients;
}

string ServicePatient::print() const {

    for (Patient *patient : patients) {
        PatientContributor *contributor = dynamic_cast<PatientContributor *>(patient);
        PatientPrepaid *prepaid = dynamic_cast<PatientPrepaid *>(patient);
        PatientSubsidized   *subsidized = dynamic_cast<PatientSubsidized *>(patient);

        if (contributor) {
            return " Category: " + contributor->get_category();
        } else if (prepaid) {
            return " Plain: " + prepaid->get_plain();
        }
    }
}
