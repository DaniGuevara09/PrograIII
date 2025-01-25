#include <iostream>

#include "ServicePatient.h"

int main()
{
    ServicePatient *service = new ServicePatient();

    service->addPatient(1, "Dani", "Duitama", 3, SILVER);
    service->addPatient(2, "Dani", "Sogamoso", 4, 'A');
    service->addPatient(3, "Cami", "Duitama", 5, true);

    for (int i = 0; i < service->getPatients().size(); i++) {
        cout << service->getPatients()[i]->print()<< endl;
    }

    cout << "\n\n_____________ List of the patients with the same name _____________" << endl;
    vector<Patient *> foundPatients = service->findByName("Dani");

    for (int i = 0; i < foundPatients.size(); i++) {
        cout << foundPatients[i]->print() << endl;
    }

}
