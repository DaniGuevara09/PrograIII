#include <iostream>

#include "ServicePatient.h"
using namespace std;

int main() {

    ServicePatient *patient = new ServicePatient();

    patient->addPatient(10, "Dani", "Duitama", 3, SILVER);
    patient->addPatient(10, "Dani", "Sogamoso", 3, "A");
    patient->addPatient(10, "Camila", "Tunja", 3, true);

    return 0;
}
