cmake_minimum_required(VERSION 3.29)
project(proj4Associations)

set(CMAKE_CXX_STANDARD 20)

add_executable(proj4Associations main.cpp
        Figure.cpp
        Figure.h
        Point.cpp
        Point.h)
