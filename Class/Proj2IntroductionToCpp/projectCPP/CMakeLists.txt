cmake_minimum_required(VERSION 3.28)
project(projectCPP)

set(CMAKE_CXX_STANDARD 17)

add_executable(projectCPP main.cpp
        Sale.h
        Sale.cpp
        Node.h)
