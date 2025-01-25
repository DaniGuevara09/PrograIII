cmake_minimum_required(VERSION 3.29)
project(Evaluation1)

set(CMAKE_CXX_STANDARD 20)

add_executable(Evaluation1 main.cpp
        Patient.cpp
        Patient.h
        EGender.cpp
        EGender.h
        PatientSubsidized.cpp
        PatientSubsidized.h
        EPlain.cpp
        EPlain.h
        PatientPrepaid.cpp
        PatientPrepaid.h
        PatientContributor.cpp
        PatientContributor.h
        ServicePatient.cpp
        ServicePatient.h
)
