cmake_minimum_required(VERSION 3.29)
project(Evaluation1)

set(CMAKE_CXX_STANDARD 20)

add_executable(Evaluation1 main.cpp
        Patient.cpp
        Patient.h
        PatientSubsidized.cpp
        PatientSubsidized.h
        EGender.cpp
        EGender.h
        PatientPrepaid.cpp
        PatientPrepaid.h
        EPlain.h
        PatientContributor.cpp
        PatientContributor.h
        ServicePatient.cpp
        ServicePatient.h)
